package com.jjly.dao.goods;

import com.jjly.model.goods.ItemCate;
import org.jjly.framework.orm.mybatis.MybatisBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>//TODO(商品分类管理Dao) </p >
 *
 * @author Helen
 * @version V1.0
 * @Package com.jjly.dao.goods
 * @e-mail 717922789@qq.com
 * @date 2017/9/19
 */

@Repository
public interface IGoodsItemCateDao extends MybatisBaseDao<ItemCate,Long> {

    List<ItemCate> getItemCateList(ItemCate itemCate);
}
