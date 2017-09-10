package com.jjly.client;

import com.jjly.model.User;

import java.util.List;

/**
 * <p>用户逻辑接口</p>
 *
 * @author Steven
 * @version V1.0
 * @Package com.jjly.client
 * @e-mail 47121494@qq.com
 * @date 2017/9/916:39
 */
public interface IUserClient {
    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    public User get(Long id);
    public List<User> findAll();
    public User getByLoginAccount(String s);

}
