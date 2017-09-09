package org.jjly.framework.orm;

import com.google.common.base.CaseFormat;
import org.jjly.framework.orm.filter.SearchFilter.Operator;


/**
 * 
 * <p>
 * mybatis查询条件
 * </p>
 * 
 * @Package org.yun.framework.orm
 * @author 黄乡南
 * @email hxiangnan@126.com
 * @date 2016-8-12 下午3:57:23
 * @version V1.0
 */
public class QueryCondition{
	

	/**
	 * 要查询的属性
	 */
	private String queryFiled;
	/**
	 * 要更新的值
	 */
	private Object value;

	private BooleanOperator booleanOperator;
	
	private Operator operator;

	private  QueryCondition() {
		super();
	}
	
	public  static <X,Y> QueryCondition create(String queryFiled,Operator operator,Y value){
		QueryCondition queryCondition = new QueryCondition();
		queryCondition.setQueryFiled(queryFiled);
		queryCondition.setOperator(operator);
		queryCondition.setValue(value);
		return queryCondition;
	}
	

	public String getQueryFiled() {
		return queryFiled;
	}

	public void setQueryFiled(String queryFiled) {
		this.queryFiled = queryFiled;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	
	
	public static enum BooleanOperator {
		AND,
		OR
	}
	
	
	/**
	 * 获取数据java属性对应的数据库的列名
	 */
	public String getColumnName(){
			return  CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,queryFiled );
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public BooleanOperator getBooleanOperator() {
		return booleanOperator;
	}

	public void setBooleanOperator(BooleanOperator booleanOperator) {
		this.booleanOperator = booleanOperator;
	}
	
}
