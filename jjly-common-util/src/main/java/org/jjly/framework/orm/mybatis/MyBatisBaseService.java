package org.jjly.framework.orm.mybatis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.jjly.framework.mybatis.paginator.domain.Order;
import org.jjly.framework.orm.QueryBuilder;
import org.jjly.framework.orm.QueryCondition;
import org.jjly.framework.page.PageResult;

/**
 * <p>mybatis service基础接口，定义了一些通用的查询方法 </p>
 * @Package org.jjly.framework.orm
 * @author Steven
 * @e-mail 471214943@qq.com
 * @date 2017/9/9 9:32
 * @version V1.0
 */
public interface MyBatisBaseService<T, ID extends Serializable>
{
	
	/**
	 * 获取该ID对应的对象
	 * @param paramLong
	 * @return
	 */
	public T get(ID paramLong);
	
		
	/**
	 * 查询所有记录
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * 查询所有记录数
	 * @return
	 */
	public long findAllCount();
	
	/**
	 * 根据查询条件获取所有符合记录的结果
	 * @param mapCondition 查询条件
	 * @return
	 */
	public List<T> findByCondition(Map<String, Object> mapCondition);
	
	public List<T> findAll(Map<String,Object> map);
	
	/**
	 * 根据查询条件查询符合的记录数
	 * @param mapCondition 查询条件
	 * @return
	 */
	public long findByConditionCount(Map<String, Object> mapCondition);
	/**
	 * 根据查询条件获取所有符合记录的结果，并根据所给的排序规则进行排序
	 * @param mapCondition 查询条件
	 * @param orders 排序规则
	 * @return
	 */
	public List<T> findByCondition(Map<String, Object> mapCondition, List<Order> orders);
	
	/**
	 * 根据查询条件查询符合的记录数
	 * 
	 * @param queryBuilder
	 *            查询条件
	 * @return
	 */
	public List<T> findAll(QueryBuilder queryBuilder);
	
	/**
	 * 根据查询条件查询符合的记录数
	 * 
	 * @param queryBuilder
	 *            查询条件
	 * @return
	 */
	public List<T> findAll(QueryBuilder queryBuilder, List<Order> orders);
	
	/**
	 * 根据查询条件查询符合的记录数
	 * 
	 * @param queryConditions
	 *            查询条件
	 * @return
	 */
	public List<T> findAll(List<QueryCondition> queryConditions);
	/**
	 * 根据查询条件查询符合的记录数
	 * 
	 * @param queryConditions
	 *            查询条件
	 * @return
	 */
	public List<T> findAll(List<QueryCondition> queryConditions, List<Order> orders);
	
	

	
	
	
	/**
	 * 根据查询条件、当前页码、每页显示记录数获取对应的查询结果
	 * @param mapCondition 当前查询条件
	 * @param page 当前页码 从0开始。默认是0
	 * @param rows 没有显示记录数
	 * @return
	 */
	public PageResult<List<T>> findPageByCondition(Map<String, Object> mapCondition, Integer page, Integer rows);

	/**
	 * 根据查询条件、当前页码、每页显示记录数、排序条件获取对应的查询结果
	 * @param mapCondition 查询条件
	 * @param page 当前页码 从0开始。默认是0
	 * @param rows 没有显示记录数
	 * @param orders 排序条件
	 * @return
	 */
	public PageResult<List<T>> findPageByCondition(Map<String, Object> mapCondition, Integer page, Integer rows, List<Order> orders);

}