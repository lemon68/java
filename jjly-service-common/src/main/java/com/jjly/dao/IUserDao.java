package com.jjly.dao;

import com.jjly.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by helen
 */

@Repository
public interface IUserDao {

    List<User> selectAllUser();
}
