package org.jjly.framework.bean;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/**
 * 
 * <p>标注该属性要进行bean属性复制，字段上的get方法》set方法>注解</p>
 * @Package org.jjly.framework.bean
 * @author Steven
 * @email 471214943@qq.com
 * @date 2017-9-17 下午12:00:59
 * @version V1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Inherited
public @interface BeanCopyProperty {
	
	/**
	 * <p>
	 * 说明：复制属性值到该参数指定类型的对象内
	 * </p>
	 * @return
	 * @author Steven
	 */
	Class<?> targetClass() default void.class;

	/**
	 * 
	 * <p>
	 * 说明：属性命列表，该列表里的属性命会被忽略不进行复制
	 * </p>
	 * 
	 * @return
	 * @author Steven
	 */
	String[] ignoreProperty() default {};

}
