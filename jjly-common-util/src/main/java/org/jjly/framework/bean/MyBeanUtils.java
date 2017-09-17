package org.jjly.framework.bean;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
/**
 * 
 *  <p>提供有相同属性名的两个不同的类直接的属性值负责功能，方便对pojo的属性复制操作</p>
 * @Package org.jjly.framework.bean
 * @author Steven
 * @email hxiangnan@126.com
 * @date 2017-9-17 下午3:28:26
 * @version V1.0
 */
public class MyBeanUtils
{
	private static PropertyUtilsBean propertyUtils = new PropertyUtilsBean();
	private static PropertyUtilsBean getPropertyUtils(){
		return propertyUtils;
	}
	/**
	 * 新版，支持超类的字段赋值，将orig的属性的值复制到dest的属性里
	 * 规则：
	 * 1，只有orig源对象和目标对象里都有的属性并且属性的读写方法都是可见的才会被复制。
	 * 2，源对象中属性值为null的属性不会被复制到目标对象的属性中。
	 * 
	 * @param dest 目标。
	 * @param orig 源。
	 */
	public static void propertyUtils(Object dest, Object orig)
	{
		PropertyDescriptor[] origDescriptors =
				getPropertyUtils().getPropertyDescriptors(orig);
		for (int i = 0; i < origDescriptors.length; i++) {
			String name = origDescriptors[i].getName();
			
			if (getPropertyUtils().isReadable(orig, name) &&
					getPropertyUtils().isWriteable(dest, name)) {
				try {
					Object value = getPropertyUtils().getSimpleProperty(orig, name);
					if ((value != null) || (StringUtils.isNotBlank(ObjectUtils.toString(value)))){
						getPropertyUtils().setSimpleProperty(dest, name, value);
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				catch (NoSuchMethodException e) {
					e.printStackTrace();
				}catch (SecurityException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * <p> 
	 *	说明：不同类型的对象之间属性值的拷贝，一般用于将vo的属性值拷贝到实体类。或反过来拷贝
	 *	</p>
	 *
	 * @param orig 源对象，属性值被拷贝的对象
	 * @param destType  目标对象的类型，必须含有默认的构造方法
	 * @return 如果orig=null或destType=null则直接返回null
	 * @author Steven
	 */
	public static <T> T copyProperty(Object orig ,Class<T> destType){
		return copyProperty(orig, destType,false);
	}
	
	/**
	 * <p> 
	 *	说明：不同类型的对象之间属性值的拷贝，一般用于将vo的属性值拷贝到实体类。或反过来拷贝
	 *	</p>
	 * @param orig 源对象，属性值被拷贝的对象
	 * @param destType  目标对象的类型，必须含有默认的构造方法
	 * @param isIgnoreBeanCopyProperty 是否忽略￥{@link  BeanCopyProperty}注解
	 * @return 如果orig=null或destType=null则直接返回null
	 * @author Steven
	 */
	public static <T> T copyProperty(Object orig ,Class<T> destType,boolean isIgnoreBeanCopyProperty){
		if(orig==null||destType==null){
			return null;
		}
		try {
			T dest = destType.newInstance();
			PropertyDescriptor[] origDescriptors =
					getPropertyUtils().getPropertyDescriptors(orig);
			for (int i = 0; i < origDescriptors.length; i++) {
				String name = origDescriptors[i].getName();
				if (getPropertyUtils().isReadable(orig, name) &&
						getPropertyUtils().isWriteable(dest, name)) {//判断该属性在源输入对象里是否支持读取，在输出对象里是否支持写入
						Object value = getPropertyUtils().getSimpleProperty(orig, name);
						if ((value != null) || (StringUtils.isNotBlank(ObjectUtils.toString(value)))){//如果读取到null就不进行属性复制
							//获取属性get方法上或set方法上，或字段属性上是否有该注解
							BeanCopyProperty targetClass =getCopyTargetClass(dest,name);
							if(targetClass==null){
								getPropertyUtils().setSimpleProperty(dest, name, value);
							}else{
								if(isIgnoreBeanCopyProperty){
									continue;
								}
								//获取注解上设置的class，表示要将源属性转成成该class类型的属性
								Class propClass = targetClass.targetClass();
								if(propClass.equals(void.class)){
									//如果注解上没有配置指定要转换的目标类class类型，则从该属性的set方法中获取class类型
									PropertyDescriptor destDescriptor =
											getPropertyUtils().getPropertyDescriptor(dest, name);
									Class[] paraClasses = destDescriptor.getWriteMethod().getParameterTypes();
									propClass = paraClasses!=null&&paraClasses.length>0?paraClasses[0]:null;
								}
								if(propClass!=null){
									if(isCollection(value)){
										Collection col = (Collection) value;
										Iterator iterator = col.iterator();
										while (iterator.hasNext()) {
											Object object = (Object) iterator
													.next();
											Object propClassVulue = copyProperty(object,propClass);
											//getPropertyUtils().setSimpleProperty(dest, name, propClassVulue);
											((Collection) getPropertyUtils().getSimpleProperty(dest, name)).add(propClassVulue);
										}
									}else{
										Object propClassVulue = copyProperty(value,propClass);
										getPropertyUtils().setSimpleProperty(dest, name, propClassVulue);	
									}
									
								}
							}
						}
				}
			}
			return dest;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static boolean isCollection(Object obj) {
		return obj instanceof Collection;
	}
	/**
	 * 
	 * <p> 
	 *	说明：获取name指定的属性的上的BeanCopyProperty注解，注解覆盖顺序是，get》set》当前类的field字段》父类的field字段
	 *	</p>
	 * @param obj
	 * @param name
	 * @return 返回name指定的属性的上的BeanCopyProperty注解，注解覆盖顺序是，get》set》当前类的field字段》父类的field字段，如果都没找到，返回null
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @author Steven
	 */
	private static BeanCopyProperty getCopyTargetClass(Object obj, String name) throws NoSuchFieldException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		if(obj==null){
			return null;
		}
		//从obj中的name指定的属性里查找BeanCopyProperty注解start
		PropertyDescriptor destDescriptor =
				getPropertyUtils().getPropertyDescriptor(obj, name);
		BeanCopyProperty targetClass = null;
		if(destDescriptor!=null){
			 targetClass =destDescriptor.getReadMethod().getAnnotation(BeanCopyProperty.class);
			if(targetClass!=null){
				return targetClass;
			}
			targetClass =destDescriptor.getWriteMethod().getAnnotation(BeanCopyProperty.class);
			if(targetClass!=null){
				return targetClass;
			}
		}
		//从obj中的name指定的属性里查找BeanCopyProperty注解start
		//从obj中的name指定的字段里查找BeanCopyProperty注解start
		Field field = null;
		try {
			 field = obj.getClass().getDeclaredField(name);
		} catch (Exception e) {
			//找不到属性。表示在当前对象的类里没有该属性，继续查找该类的父类是否有该属性
			//向上获取父类的私有属性。
			try {
				field = getDeclaredField(obj,name);
			} catch (Exception e2) {
				//在该对象所属的所有父类中都没找到该属性，
			}
		}
		if(field!=null){
			targetClass = field.getAnnotation(BeanCopyProperty.class);
		}
		//从obj中的name指定的字段里查找BeanCopyProperty注解end
		return targetClass;
	}
	
	 /**   
     * 循环向上转型, 获取对象的 DeclaredField   
     * @param object : 子类对象   
     * @param fieldName : 父类中的属性名   
     * @return 父类中的属性对象   
     */          
    public static Field getDeclaredField(Object object, String fieldName){    
        Field field = null ;              
        Class<?> clazz = object.getClass() ;              
        for(; clazz != Object.class ; clazz = clazz.getSuperclass()) {    
            try {    
                field = clazz.getDeclaredField(fieldName) ;    
                return field ;    
            } catch (Exception e) {    
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。    
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了                      
            }     
        }          
        return null;    
    }   
	/**
	 * <p> 
	 *	说明：将list里的对象进行属性拷贝，放在一个list集合中返回，如果list参数为空或null不会抛出异常，而是直接返回一个空集合
	 *	</p>
	 * @param list 如果list为null或空集合，这返回一个空集合
	 * @param type 要将list里的对象的属性拷贝到指定类型的类的对象，该参数指定该对象的类的class
	 * @return
	 * @author Steven
	 */
	public static <T> List<T> copyProperty(List<?> list ,Class<T> type){
		List<T> tlist = Lists.newArrayList();
		if(list==null||list.isEmpty()){
			return tlist;
		}
		for (Object t : list) {
			T t1 = copyProperty(t, type);
			if(t1!=null){
				tlist.add(t1);	
			}
		}
		return tlist;
	}
}