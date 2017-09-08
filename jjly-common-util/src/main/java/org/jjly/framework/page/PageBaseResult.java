package org.jjly.framework.page;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;

/**
 * 分页实体
 * @author 黄乡南
 * 
 *
 * @param <T>
 */
public class PageBaseResult<T> implements Serializable{
	
	/**
	 * 默认分页大小
	 */
	public static final int defPageSize=20;
	/**
	 * 默认当前页面
	 */
	public static final int defCurrentPage=0;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long totalRows;

	private int totalPages;

	private int currentPage=defCurrentPage;

	private int pageSize = defPageSize;

	@JsonProperty("datas")
	private T t;

	public PageBaseResult() {
		super();
	}

	public long getTotalRows() {
		return this.totalRows;
	}

	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public T getT() {
		return this.t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public int getStartRow() {
		return this.pageSize * (this.currentPage - 1);
	}

	
	public static <T> PageBaseResult<List<T>> newEmptyPageResult(){
		PageBaseResult<List<T>> pageResult = new PageBaseResult<List<T>>();
		List<T> list = Lists.newArrayList();
		pageResult.setT(list);
		return pageResult;
	}
}
