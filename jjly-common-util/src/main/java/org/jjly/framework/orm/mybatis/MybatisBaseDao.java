package org.jjly.framework.orm.mybatis;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jjly.framework.mybatis.paginator.domain.Order;
import org.jjly.framework.mybatis.paginator.domain.PageBounds;
import org.jjly.framework.mybatis.paginator.domain.PageList;
import org.jjly.framework.orm.QueryBuilder;

/**
 * <p>mybatis基础dao </p>
 * @Package org.jjly.framework.orm
 * @author Steven
 * @e-mail 471214943@qq.com
 * @date 2017/9/9 9:31
 * @version V1.0
 */
public interface MybatisBaseDao<T, ID extends Serializable> {

	/**
	 * 获取该ID对应的对象
	 * 
	 * @param paramLong
	 * @return
	 */
	public T get(ID paramLong);

	/**
	 * 查询所有记录
	 * 
	 * @return
	 */
	public List<T> findAll();

	/**
	 * 查询所有记录数
	 * 
	 * @return
	 */
	public long count();

	/**
	 * 根据查询条件获取所有符合记录的结果
	 * 
	 * @param queryBuilder
	 *            查询条件
	 * @return
	 */
	public long count(@Param("queryBuilder") QueryBuilder queryBuilder);

	/**
	 * 根据查询条件查询符合的记录数
	 * 
	 * @param queryBuilder
	 *            查询条件
	 * @return
	 */
	public List<T> findAll(@Param("queryBuilder") QueryBuilder queryBuilder);

	/**
	 * 
	 * <p>
	 * 说明：条件查询并排序
	 * </p>
	 * 
	 * @param queryBuilder
	 * @param orders
	 * @author Steven
	 */
	public List<T> findAllAndOrder(
			@Param("queryBuilder") QueryBuilder queryBuilder,
			@Param("orders") List<Order> orders);

	/**
	 * 根据查询条件、当前页码、每页显示记录数获取对应的查询结果
	 * 
	 * @param queryBuilder
	 *            当前查询条件
	 * @param pageBounds
	 *            当前页码 从0开始。默认是0
	 * @return
	 */
	public PageList<T> findAllAndPage(
			@Param("queryBuilder") QueryBuilder queryBuilder,
			PageBounds pageBounds);

	/**
	 * 根据查询条件、当前页码、每页显示记录数获取对应的查询结果
	 * 
	 * @param queryBuilder
	 *            当前查询条件
	 * @return
	 */
	public List<T> findAllByQB(@Param("queryBuilder") QueryBuilder queryBuilder);

}