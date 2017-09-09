package org.jjly.framework.page;

import java.util.List;

import org.springframework.data.domain.Page;
import org.jjly.framework.mybatis.paginator.domain.PageList;
import org.springframework.util.CollectionUtils;

/**
 * <p>分页工具 </p>
 * @Package org.jjly.framework.page
 * @author Steven
 * @e-mail 471214943@qq.com
 * @date 2017/9/9 11:31
 * @version V1.0
 */
public class PageUtils {

	/**
	 * <p>
	 *  说明：Page<T>-->PageResult<List<T>> 将jpa的page转换成pageResult
	 * </p>
	 * <p>
	 *  链接：
	 * </p>
	 * @param page
   * @param currentPage 设置的当前页页码
   * @param pageSize 设置分页大小
	 * @return org.jjly.framework.page.PageResult<java.util.List<T>>
	 * @auth Steven
	 */
	public static <T> PageResult<List<T>> returnPage(Page<T> page,
			int currentPage, int pageSize) {
		PageResult<List<T>> pageResult = new PageResult<List<T>>();
		pageResult.setCurrentPage(currentPage);
		pageResult.setPageSize(pageSize);
		pageResult.setTotalRows(page.getTotalElements());
		pageResult.setTotalPages(page.getTotalPages());
		pageResult.setT(page.getContent());
		return pageResult;
	}

	/**
	 * <p>
	 *  说明：PageList<T>-->PageResult<List<T>> 将jpa的page转换成PageResult<List<T>>，
	 * </p>
	 * <p>
	 *  链接：
	 * </p>
	 *  * @param PageList<T>
	 *  * @return org.jjly.framework.page.PageResult<java.util.List<T>>
	 * @auth Steven
	 */
	public static <T> PageResult<List<T>> returnPage(PageList<T> page) {
		PageResult<List<T>> pageResult = new PageResult<List<T>>();
		pageResult.setCurrentPage(page.getPaginator().getPage()-1);
		pageResult.setPageSize(page.getPaginator().getLimit());
		pageResult.setTotalRows(page.getPaginator().getTotalCount());
		pageResult.setTotalPages(page.getPaginator().getTotalPages());
		pageResult.setT(page);

		return pageResult;
	}

	/**
	 * <p>
	 *  说明：Page<T>-->PageResult<List<T>> 将jpa的page转换成PageResult<List<T>>，
	 * </p>
	 * <p>
	 *  链接：
	 * </p>
	 *  * @param page
	 *  * @return org.jjly.framework.page.PageResult<java.util.List<T>>
	 * @auth Steven
	 */
	public static <T> PageResult<List<T>> returnPage(Page<T> page) {
		if (page == null || CollectionUtils.isEmpty(page.getContent())) {
			return PageResult.newEmptyPageResult();
		}
		PageResult<List<T>> pageResult = new PageResult<List<T>>();
		pageResult.setT(page.getContent());
		pageResult.setCurrentPage(page.getNumber());
		pageResult.setPageSize(page.getSize());
		pageResult.setTotalPages(page.getTotalPages());
		pageResult.setTotalRows(page.getTotalElements());
		return pageResult;
	}
	/**
	 * <p>
	 *  说明：生成PageResult<List<T>>，
	 * </p>
	 * <p>
	 *  链接：
	 * </p>
	 * @param content
   * @param totalElements 总数量
   * @param totalPages 总页数
   * @param currentPage 当前页
   * @param pageSize 每页记录数
	 * @return org.jjly.framework.page.PageResult<java.util.List<T>>
	 * @auth Steven
	 */
	public static <T> PageResult<List<T>> returnPage(List<T> content,
			Long totalElements, int totalPages, int currentPage, int pageSize) {
		PageResult<List<T>> pageResult = new PageResult<List<T>>();
		pageResult.setCurrentPage(currentPage);
		pageResult.setPageSize(pageSize);
		pageResult.setTotalRows(totalElements);
		pageResult.setTotalPages(totalPages);
		pageResult.setT(content);
		return pageResult;
	}
}
