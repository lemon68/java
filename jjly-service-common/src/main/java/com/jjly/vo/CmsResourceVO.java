package com.jjly.vo;

import org.jjly.framework.orm.LongBaseEntity;

/**
 * <p>系统后台资源菜单VO</p>
 *
 * @author Steven
 * @version V1.0
 * @Package com.jjly.vo
 * @e-mail 47121494@qq.com
 * @date 2017/9/15 11:03
 */
public class CmsResourceVO{
    private String code;
    private String name;
    private String url;
    private Integer sort;
    private Integer level;
    private Long pid;
    private Long  iconId;
    private Boolean isMenu;

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

    public Boolean getMenu() {
        return isMenu;
    }

    public void setMenu(Boolean menu) {
        isMenu = menu;
    }
}
