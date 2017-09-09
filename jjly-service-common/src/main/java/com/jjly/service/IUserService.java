package com.jjly.service;


import com.jjly.model.User;
import org.jjly.framework.orm.mybatis.MyBatisBaseService;

import java.util.List;

/**
 * Created by helen
 */
public interface IUserService extends MyBatisBaseService<User,Long>{

    List<User> getAllUser();
}
