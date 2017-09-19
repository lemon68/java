package com.jjly.model.goods;

import org.apache.ibatis.type.Alias;
import org.jjly.framework.orm.LongBaseEntity;

import java.math.BigInteger;

/**
 * <p>//TODO(商品分类Model) </p >
 *
 * @author Helen
 * @version V1.0
 * @Package com.jjly.model.goods
 * @e-mail 717922789@qq.com
 * @date 2017/9/19
 */

@Alias("itemCate")
public class ItemCate extends LongBaseEntity {

    private String name; //分类名称
    private Long pid;  //父节点
    private String img;  //图片
    private Boolean isRecommend; //是否推荐
    private Boolean isDisplay;  //是否显示
    private Integer sort;  //排序


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Boolean getRecommend() {
        return isRecommend;
    }

    public void setRecommend(Boolean recommend) {
        isRecommend = recommend;
    }

    public Boolean getDisplay() {
        return isDisplay;
    }

    public void setDisplay(Boolean display) {
        isDisplay = display;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
