package org.jjly.framework.page;

import java.util.List;

import org.jjly.framework.mybatis.paginator.domain.PageList;

import com.google.common.collect.Lists;
/**
 * <p>分页实体 </p>
 * @Package org.jjly.framework.page
 * @author Steven
 * @e-mail 471214943@qq.com
 * @date 2017/9/9 11:30
 * @version V1.0
 */
public class PageResult<T> extends PageBaseResult<T>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PageResult() {
		super();
	}
	public PageResult(PageList<?> list) {
		this.setCurrentPage(list.getPaginator().getPage()-1);
		this.setPageSize(list.getPaginator().getLimit());
		this.setTotalRows(list.getPaginator().getTotalCount());
		this.setTotalPages(list.getPaginator().getTotalPages());
		this.setT((T)list);
	}
	public PageResult(PageList<?> list,int pageNo,int pageSize) {
		this.setCurrentPage(pageNo);
		this.setPageSize(pageSize);
		this.setTotalRows(list.getPaginator().getTotalCount());
		this.setTotalPages(list.getPaginator().getTotalPages());
		this.setT((T) list);
	}
	
	public static <T> PageResult<List<T>> newEmptyPageResult(){
		PageResult<List<T>> pageResult = new PageResult<List<T>>();
		List<T> list = Lists.newArrayList();
		pageResult.setT(list);
		pageResult.setPageSize(20);
		pageResult.setTotalPages(0);
		pageResult.setTotalRows(0l);
		return pageResult;
	}
}
