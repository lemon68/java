package org.jjly.framework.orm.mybatis;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.jjly.framework.mybatis.paginator.domain.Order;
import org.jjly.framework.mybatis.paginator.domain.PageBounds;
import org.jjly.framework.mybatis.paginator.domain.PageList;
import org.jjly.framework.orm.QueryBuilder;
import org.jjly.framework.orm.QueryCondition;
import org.jjly.framework.orm.filter.SearchFilter;
import org.jjly.framework.page.PageResult;
import org.jjly.framework.page.PageUtils;

/**
 * <p>mybatis通用只读查询的默认实现抽象类 </p>
 * @Package org.jjly.framework.orm
 * @author Steven
 * @e-mail 471214943@qq.com
 * @date 2017/9/9 9:36
 * @version V1.0
 */
public abstract class MyBatisBaseServiceImpl<T, ID extends Serializable> implements
 MyBatisBaseService<T, ID> {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	public abstract MybatisBaseDao<T,ID> getBaseDAO();
	
	public static int defPage = 0;
	public static int defSize = 20;
	
	protected PageRequest defPageRequest = new PageRequest(defPage, defSize);

	/**
	 * 
	 * <p>
	 *  说明：默认jpa分页PageRequest
	 * </p>
	 * @return
	 * @author Steven
	 */
	public PageRequest getDefPageRequest() {
		return defPageRequest;
	}


	public void setDefPageRequest(PageRequest defPageRequest) {
		this.defPageRequest = defPageRequest;
	}

	@Override
	@Transactional(readOnly = false)
	public T get(ID arg0) {
		return getBaseDAO().get(arg0);
	}

	@Override
	public List<T> findAll() {
		return (List<T>) getBaseDAO().findAll();
	}

	@Override
	public long findAllCount() {
		return getBaseDAO().count();
	}

	@Override
	public List<T> findByCondition(Map<String, Object> map) {
		return findByCondition(map, null);
	}

	@Override
	public long findByConditionCount(Map<String, Object> map) {
		List<SearchFilter> searchFilters = SearchFilter.parseToList(map);
		QueryBuilder q = QueryBuilder.createQB(searchFilters);
		return getBaseDAO().count(q);
	}

	@Override
	public List<T> findByCondition(Map<String, Object> map, List<Order> orders) {
		List<SearchFilter> searchFilters = SearchFilter.parseToList(map);
		QueryBuilder q = QueryBuilder.createQB(searchFilters);
		return getBaseDAO().findAllAndOrder(q, orders);
	}

	@Override
	public PageResult<List<T>> findPageByCondition(Map<String, Object> map,
			Integer page, Integer rows) {
		return findPageByCondition(map, page, rows, null);
	}

	@Override
	public PageResult<List<T>> findPageByCondition(Map<String, Object> map,
			Integer page, Integer rows, List<Order> orders) {
		List<SearchFilter> searchFilters = SearchFilter.parseToList(map);
		QueryBuilder q = QueryBuilder.createQB(searchFilters);
		PageBounds pageBounds = new PageBounds(page,rows,orders);
		PageList<T> result = getBaseDAO().findAllAndPage(q,pageBounds);
		return PageUtils.returnPage(result);
	}

	@Override
	public List<T> findAll(Map<String, Object> map) {
		List<SearchFilter> searchFilters = SearchFilter.parseToList(map);
		QueryBuilder q = QueryBuilder.createQB(searchFilters);
		return getBaseDAO().findAll(q);
	}

	@Override
	public List<T> findAll(QueryBuilder queryBuilder) {
		return getBaseDAO().findAll(queryBuilder);
	}

	@Override
	public List<T> findAll(QueryBuilder queryBuilder, List<Order> orders) {
		return getBaseDAO().findAllAndOrder(queryBuilder,orders);
	}

	@Override
	public List<T> findAll(List<QueryCondition> queryConditions) {
		QueryBuilder q = QueryBuilder.createQB(queryConditions);
		return getBaseDAO().findAll(q);
	}

	@Override
	public List<T> findAll(List<QueryCondition> queryConditions,
			List<Order> orders) {
		QueryBuilder q = QueryBuilder.createQB(queryConditions);
		return getBaseDAO().findAllAndOrder(q,orders);
	}
}