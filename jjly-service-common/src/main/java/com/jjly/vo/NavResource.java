package com.jjly.vo;

import java.util.List;

import com.google.common.collect.Lists;

import com.jjly.model.CmsResource;

/**
 * 
 * <p>
 * 导航资源
 * </p>
 * 
 * @Package com.yun.main.entity.resource
 * @author 黄乡南
 * @e-mail 823798218@qq.com
 * @date 2016-7-16 下午2:24:58
 * @version V1.0
 */
public class NavResource {
	
	public Long id;
	

	/**
	 * 菜单标识名
	 */
	private String code;// 菜单标识名
	/**
	 * 菜单名称
	 */
	private String name;// 菜单名称
	/**
	 * 请求地址
	 */
	private String url;// 请求地址
	/**
	 * 图标地址
	 */
	private String iconUrl;// 图标地址

	private Boolean isMenu;

	private Integer level;
	
	private Integer sort;

	private Boolean isHaveParent;
	
	private Boolean isHaveChild;
	
	private Long parentResourceId;

	/**
	 * 子级菜单列表
	 */
	private List<NavResource> sub;// 子级菜单


	public static List<NavResource> getHeadResources(List<NavResource> resources) {
		List<NavResource> navResources = Lists.newArrayList();
		for (NavResource resource : resources) {
			if(resource.getLevel()==0){//等级未0的就是1级菜单
				navResources.add(resource);
			}
		}
		return navResources;
	}
	/**
	 * 
	 * <p>
	 *  说明：
	 * </p>
	 * <p>
	 *  链接：
	 * </p>
	 * @param resources
	 * @param topResourceId
	 * @return
	 * @author 黄乡南
	 */
	public static List<NavResource> getLeftResources(List<NavResource> resources,Long topResourceId) {
		List<NavResource> navResources = Lists.newArrayList();
		for (NavResource resource : resources) {
			if(resource.getLevel()==1&&topResourceId.equals(resource.getParentResourceId())){//Level为1的就是2级菜单
				List<NavResource> subNavRes = Lists.newArrayList();
				for (NavResource navResource1 : resources) {
					if(resource.getId().equals(navResource1.getParentResourceId())){
						subNavRes.add(navResource1);
					}
				}
				resource.setSub(subNavRes);
				navResources.add(resource);
			}
		}
		return navResources;
	}
	public static List<NavResource> covResourceToNavRes(List<CmsResource> resources) {
		List<NavResource> navResources = Lists.newArrayList();
		
		for (CmsResource resource : resources) {
			navResources.add(covResourceToNavRes(resource));
		}
		return navResources;
	}

	/**
	 * 
	 * <p>
	 *  说明：将查询出来的用户的所有资源按资源的层次进行存放
	 * </p>
	 * @param resources 用户的所有资源
	 * @return
	 * @author 黄乡南
	 */
	private static List<CmsResource> initResourcesLv(List<CmsResource> resources) {
		List<CmsResource> list = Lists.newArrayList();
		for (CmsResource resource : resources) {
			for (CmsResource resource2 : resources) {
				if(resource2.getParentResource()!=null&&resource.getId().equals(resource2.getParentResource().getId())){
					list.add(resource2);
				}
			}
			resource.setResources(list);
			list=Lists.newArrayList();
		}
		return resources;
	}
	public static NavResource covResourceToNavRes(CmsResource resource) {
		NavResource navResource = new NavResource(
				resource.getId(),
				resource.getPid(),
				resource.getCode(),
				resource.getName(),
				resource.getUrl(),
				resource.getIcon().getIconUrl(),
				resource.getIsMenu(),
				resource.getLevel(), 
				resource.getSort(),
				resource.getIsHaveParent(),
				resource.getIsHaveChild(), covResourceToNavRes(resource.getResources()));
		return navResource;
	}

	public NavResource(Long id, Long pid, String code, String name, String url, String iconUrl,
					   Boolean isMenu, Integer level, Integer sort,
					   Boolean isHaveParent, Boolean isHaveChild, List<NavResource> sub) {
		super();
		this.id = id;
		this.parentResourceId = pid;
		this.code = code;
		this.name = name;
		this.url = url;
		this.iconUrl = iconUrl;
		this.isMenu = isMenu;
		this.level = level;
		this.sort = sort;
		this.isHaveParent = isHaveParent;
		this.isHaveChild = isHaveChild;
		this.sub = sub;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String resourceName) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public Boolean getMenu() {
		return isMenu;
	}

	public void setMenu(Boolean menu) {
		isMenu = menu;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Boolean getHaveParent() {
		return isHaveParent;
	}

	public void setHaveParent(Boolean haveParent) {
		isHaveParent = haveParent;
	}

	public Boolean getHaveChild() {
		return isHaveChild;
	}

	public void setHaveChild(Boolean haveChild) {
		isHaveChild = haveChild;
	}

	public Long getParentResourceId() {
		return parentResourceId;
	}

	public void setParentResourceId(Long parentResourceId) {
		this.parentResourceId = parentResourceId;
	}

	public List<NavResource> getSub() {
		return sub;
	}

	public void setSub(List<NavResource> sub) {
		this.sub = sub;
	}
}