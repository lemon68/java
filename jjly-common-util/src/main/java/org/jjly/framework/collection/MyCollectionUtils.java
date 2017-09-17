package org.jjly.framework.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

/**
 * 
 * <p>
 * apache的 CollectionUtils增强类
 * </p>
 * 
 * @Package org.yun.framework.collection
 * @author Steven
 * @email 471214943@163.com
 * @date 2016-9-17 下午4:57:25
 * @version V1.0
 */
public class MyCollectionUtils {
	/**
	 * 
	 * 
	 * 
	 * <p>
	 * 说明：将iterable转成ArrayList
	 * </p>
	 * 
	 * @param iterable
	 * @return
	 * @author 黄乡南
	 */
	public static <T> List<T> toList(Iterable<T> iterable) {
		List<T> list = new ArrayList<T>();
		CollectionUtils.addAll(list, iterable.iterator());
		return list;
	}

	/**
	 * <p>
	 * 说明：判断集合不为null和集合数据不为空。
	 * </p>
	 * 
	 * @param collection
	 *            集合
	 * @return 当集合不等于null并且集合的数据不为空的时候返回true，否则返回false
	 * @author 黄乡南
	 */
	public static boolean isNotEmpty(Collection<?> collection) {
		return ((collection != null) && (!(collection.isEmpty())));
	}

	/**
	 * 
	 * <p>
	 * 说明：判断集合为null或集合数据为空。
	 * </p>
	 * <p>
	 * 链接：
	 * </p>
	 * 
	 * @param collection
	 * @return
	 * @auth 张生强
	 */
	public static boolean isEmpty(Collection<?> collection) {
		return !isNotEmpty(collection);
	}
}