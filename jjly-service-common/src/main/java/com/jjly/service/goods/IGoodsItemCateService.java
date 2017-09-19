package com.jjly.service.goods;

import com.jjly.model.goods.ItemCate;

import java.util.List;

/**
 * <p>//TODO(描述该类的功能) </p >
 *
 * @author Helen
 * @version V1.0
 * @Package com.jjly.service.goods
 * @e-mail 717922789@qq.com
 * @date 2017/9/19
 */
public interface IGoodsItemCateService {

    List<ItemCate> getItemCateList(ItemCate itemCate);
}
