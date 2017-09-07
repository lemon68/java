package com.jjly.service.impl;


import com.jjly.dao.IUserDao;
import com.jjly.model.User;
import com.jjly.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by helen
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {
    
    @Autowired
    private IUserDao iUserDao;

    public List<User> getAllUser() {
        return iUserDao.selectAllUser();
    }
}
