package com.jjly.model;

import org.apache.ibatis.type.Alias;
import org.jjly.framework.orm.LongBaseEntity;

import java.util.List;

/**
 * <p>系统后台资源菜单VO</p>
 *
 * @author Steven
 * @version V1.0
 * @Package com.jjly.vo
 * @e-mail 47121494@qq.com
 * @date 2017/9/15 11:03
 */
@Alias("cmsResource")
public class CmsResource extends LongBaseEntity{
    private String code;
    private String name;
    private String url;
    private Integer sort;
    private Integer level;
    private Long pid;
    private Long  iconId;
    private Boolean isMenu;
    private CmsResource parentResource;
    private List<CmsResource> resources;
    private Boolean isHaveParent;
    private Boolean isHaveChild;
    private CmsIcon icon;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getIconId() {
        return iconId;
    }

    public void setIconId(Long iconId) {
        this.iconId = iconId;
    }

    public Boolean getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Boolean menu) {
        isMenu = menu;
    }

    public CmsResource getParentResource() {
        return parentResource;
    }

    public void setParentResource(CmsResource parentResource) {
        this.parentResource = parentResource;
    }

    public List<CmsResource> getResources() {
        return resources;
    }

    public void setResources(List<CmsResource> resources) {
        this.resources = resources;
    }

    public Boolean getIsHaveParent() {
        return isHaveParent;
    }

    public void setIsHaveParent(Boolean isHaveParent) {
        this.isHaveParent = isHaveParent;
    }

    public Boolean getIsHaveChild() {
        return isHaveChild;
    }

    public void setIsHaveChild(Boolean idHaveChild) {
        isHaveChild = isHaveChild;
    }

    public CmsIcon getIcon() {
        return icon;
    }

    public void setIcon(CmsIcon icon) {
        this.icon = icon;
    }
}
