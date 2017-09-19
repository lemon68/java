package com.jjly.service.impl.goods;

import com.jjly.dao.goods.IGoodsItemCateDao;
import com.jjly.model.goods.ItemCate;
import com.jjly.service.goods.IGoodsItemCateService;
import org.jjly.framework.orm.mybatis.MyBatisBaseServiceImpl;
import org.jjly.framework.orm.mybatis.MybatisBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>//TODO(商品功能分类) </p >
 *
 * @author Helen
 * @version V1.0
 * @Package com.jjly.service.impl.goods
 * @e-mail 717922789@qq.com
 * @date 2017/9/19
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GoodsItemCateServiceImpl   extends MyBatisBaseServiceImpl<ItemCate,Long> implements IGoodsItemCateService {

    @Autowired
    private IGoodsItemCateDao iGoodsItemCateDao;

    @Override
    public List<ItemCate> getItemCateList(ItemCate itemCate) {
        List<ItemCate> resultList = iGoodsItemCateDao.getItemCateList(itemCate);
        return resultList;
    }

    @Override
    public MybatisBaseDao getBaseDAO() {
        return iGoodsItemCateDao;
    }
}
