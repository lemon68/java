package com.jjly.dao;

import com.jjly.model.User;
import org.jjly.framework.orm.mybatis.MybatisBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by helen
 */

@Repository
public interface IUserDao extends MybatisBaseDao<User,Long> {
    List<User> selectAllUser();
}
