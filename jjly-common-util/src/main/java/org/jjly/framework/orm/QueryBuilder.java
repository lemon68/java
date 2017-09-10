package org.jjly.framework.orm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.base.CaseFormat;
import org.jjly.framework.orm.QueryCondition.BooleanOperator;
import org.jjly.framework.orm.filter.SearchFilter;

/**
 * <p>mybatis查询条件创建者 </p>
 * @Package org.jjly.framework.orm
 * @author Steven
 * @e-mail 471214943@qq.com
 * @date 2017/9/9 9:40
 * @version V1.0
 */
public class QueryBuilder{
	
	private List<QueryCondition> andList = new ArrayList<QueryCondition>();
	private List<QueryCondition> orList = new ArrayList<QueryCondition>();

	public QueryBuilder and(QueryCondition... queryCondition) {
		if(queryCondition!=null){
			for (QueryCondition queryConditionItem : queryCondition) {
				queryConditionItem.setBooleanOperator(BooleanOperator.AND);
				andList.add(queryConditionItem);
			}
		}
		return this;
	}
	
	public QueryBuilder or(QueryCondition... createQueryCondition) {
		if(createQueryCondition!=null){
			for (QueryCondition queryCondition : createQueryCondition) {
				queryCondition.setBooleanOperator(BooleanOperator.OR);
				orList.add(queryCondition);
			}
		}
		return this;
	}

	public List<QueryCondition> getAndList() {
		return andList;
	}

	public void setAndList(List<QueryCondition> andList) {
		this.andList = andList;
	}

	public List<QueryCondition> getOrList() {
		return orList;
	}

	public void setOrList(List<QueryCondition> orList) {
		this.orList = orList;
	}

	public static QueryBuilder createQB(final Collection<SearchFilter> searchFilter){
		QueryBuilder q = new QueryBuilder();
		for (SearchFilter searchFilterItem : searchFilter) {
			String columnName=CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, searchFilterItem.fieldName);;
			q.and(QueryCondition.create(columnName,OperatorEnum.valueOf(searchFilterItem.operator.toString()), searchFilterItem.value));
		}
		return q;
	}

	public static QueryBuilder createQB(QueryCondition... queryConditions ){
		QueryBuilder q = new QueryBuilder();
		q.and(queryConditions);
		return q;
	}
	public static QueryBuilder createQB(List<QueryCondition> queryConditions ){
		QueryBuilder q = new QueryBuilder();
		for (QueryCondition queryCondition : queryConditions) {
			q.and(queryCondition);
		}
		return q;
	}
	
}