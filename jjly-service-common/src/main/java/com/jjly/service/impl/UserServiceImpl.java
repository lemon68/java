package com.jjly.service.impl;


import java.util.List;

import org.jjly.framework.orm.mybatis.MyBatisBaseServiceImpl;
import org.jjly.framework.orm.mybatis.MybatisBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjly.dao.IUserDao;
import com.jjly.model.User;
import com.jjly.service.IUserService;

/**
 * Created by helen
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl  extends MyBatisBaseServiceImpl<User,Long> implements IUserService{
    
    @Autowired
    private IUserDao iUserDao;

    public List<User> getAllUser() {
        return iUserDao.selectAllUser();
    }

    @Override
    public MybatisBaseDao getBaseDAO() {
        return iUserDao;
    }
}
