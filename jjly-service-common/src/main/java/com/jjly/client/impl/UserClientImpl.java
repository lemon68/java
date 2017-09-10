package com.jjly.client.impl;

import com.beust.jcommander.internal.Maps;
import com.jjly.client.IUserClient;
import com.jjly.model.User;
import com.jjly.service.IUserService;
import org.jjly.framework.orm.OperatorEnum;
import org.jjly.framework.orm.QueryBuilder;
import org.jjly.framework.orm.filter.SearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>用户业务逻辑类 </p>
 *
 * @author Steven
 * @version V1.0
 * @Package com.jjly.client.impl
 * @e-mail 47121494@qq.com
 * @date 2017/9/916:37
 */
@Service
public class UserClientImpl implements IUserClient{
    @Autowired
    private IUserService userService;

    @Override
    public User get(Long id) {
        return userService.get(id);
    }

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    public User getByLoginAccount(String s) {
        Map map= Maps.newHashMap();
        map.put(OperatorEnum.EQ.op("loginAccount"),s);
        List<User> users=userService.findByCondition(map);
        return users.get(0);
    }
}
