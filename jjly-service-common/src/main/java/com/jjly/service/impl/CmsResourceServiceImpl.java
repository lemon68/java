package com.jjly.service.impl;

import com.jjly.dao.ICmsResourceDao;
import com.jjly.model.CmsResource;
import com.jjly.service.ICmsResourceService;
import org.jjly.framework.orm.mybatis.MyBatisBaseService;
import org.jjly.framework.orm.mybatis.MyBatisBaseServiceImpl;
import org.jjly.framework.orm.mybatis.MybatisBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>//TODO(描述该类的功能) </p>
 *
 * @author Steven
 * @version V1.0
 * @Package com.jjly.service.impl
 * @e-mail 47121494@qq.com
 * @date 2017/9/15 11:11
 */
@Service
public class CmsResourceServiceImpl extends MyBatisBaseServiceImpl<CmsResource,Long> implements ICmsResourceService{

    @Autowired
    private ICmsResourceDao dao;
    @Override
    public MybatisBaseDao<CmsResource, Long> getBaseDAO() {
        return dao;
    }
}
