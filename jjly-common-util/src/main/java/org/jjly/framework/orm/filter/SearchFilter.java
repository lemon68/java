package org.jjly.framework.orm.filter;

import java.util.List;
import java.util.Map;

import com.alibaba.druid.sql.ast.SQLPartitionValue;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.jjly.framework.orm.OperatorEnum;

/**
 * 
 * <p>封装查询条件，包含查询字段，字段查询设置值和查询操作（NQ,EQ,LIKE等）</p>
 * @Package org.jjly.framework.orm.filter
 * @author 黄乡南
 * @email hxiangnan@126.com
 * @date 2016-11-22 上午11:41:36 
 * @version V1.0
 */

public class SearchFilter
{
	/**
	 * 查询属性名称
	 */
	public String fieldName;
	/**
	 * 值
	 */
	public Object value;
	
	/**
	 * 查询操作符，确定查询方式是like或=等方式
	 */
	public OperatorEnum operator;

	public SearchFilter(String fieldName, OperatorEnum operator, Object value)
	{
		this.fieldName = fieldName;
		this.value = value;
		this.operator = operator;
	}
	
	/**
	 * <p> 
	 *	说明：将map转换成SearchFilter对象，map的以key是以NQ("!="), EQ("="), LIKE("LIKE"), GT(">"), LT("<"), GTE(">="), LTE("<="), LTD("<="), GTD(">="),OR("OR"), NLIKE("NOT LIKE")+“_”开头的字符串才会被转换
	 *	</p>
	 * <p> 
	 * key的拼接格式：如：user类有个userName属性，对应数据库的user_name字段。key=EQ_userName 就可以使用等于号匹配出user_name相同的数据
	 * 如：user类有个role属性Role类有个roleName属性，对应数据库的role_name字段。key=EQ_role.roleName 就可以使用等于号匹配出user表中管理role表的role_name相同的数据
	 *	</p>
	 * @param searchParams 
	 * @return 返回map，key还是原来的key，value变成SearchFilter
	 * @author 黄乡南
	 */
	public static Map<String, SearchFilter> parse(Map<String, Object> searchParams)
	{
		Map filters = Maps.newHashMap();

		if(searchParams != null){
			for (Map.Entry entry : searchParams.entrySet())
			{
				String key = (String)entry.getKey();
				Object value = entry.getValue();
				if (StringUtils.isBlank(ObjectUtils.toString(value))) {
					continue;
				}

				String[] names = StringUtils.split(key, "_");
				if (names.length != 2)
					throw new IllegalArgumentException(key + " is not a valid search filter name");

				String filedName = names[1];
				OperatorEnum operator = OperatorEnum.valueOf(names[0]);

				SearchFilter filter = new SearchFilter(filedName, operator, value);
				filters.put(key, filter);
			}
		}
	
		return filters;
	}
	
	/**
	 * <p> 
	 *	说明：将map转换成SearchFilter对象，map的以key是以NQ("!="), EQ("="), LIKE("LIKE"), GT(">"), LT("<"), GTE(">="), LTE("<="), LTD("<="), GTD(">="),OR("OR"), NLIKE("NOT LIKE")+“_”开头的字符串才会被转换
	 *	</p>
	 * @param searchParams 
	 * @return 返回map，key还是原来的key，value变成SearchFilter
	 * @author 黄乡南
	 */
	public static List< SearchFilter> parseToList(Map<String, Object> searchParams)
	{
		List<SearchFilter> filters = Lists.newArrayList();
		
		if(searchParams != null){
			for (Map.Entry entry : searchParams.entrySet())
			{
				String key = (String)entry.getKey();
				Object value = entry.getValue();
				if (StringUtils.isBlank(ObjectUtils.toString(value))) {
					continue;
				}
				
				String[] names = StringUtils.split(key, "_");
				if (names.length != 2)
					throw new IllegalArgumentException(key + " is not a valid search filter name");
				
				String filedName = names[1];
				OperatorEnum operator = OperatorEnum.valueOf(names[0]);
				
				SearchFilter filter = new SearchFilter(filedName, operator, value);
				filters.add(filter);
			}
		}
		
		return filters;
	}
}