package com.jjly.model;

import org.jjly.framework.orm.LongBaseEntity;

/**
 * <p>//TODO(描述该类的功能) </p>
 *
 * @author Steven
 * @version V1.0
 * @Package com.jjly.model
 * @e-mail 47121494@qq.com
 * @date 2017/9/15 16:33
 */
public class CmsIcon extends LongBaseEntity{
    private String name;
    private String iconType;
    private String iconUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconType() {
        return iconType;
    }

    public void setIconType(String iconType) {
        this.iconType = iconType;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
