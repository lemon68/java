package com.jjly.model;

import org.apache.ibatis.type.Alias;

/**
 * Created by helen
 */
@Alias(value = "user")
public class User {
    private String id;
    private String loginAccount; //用户名
    private String loginPassword;//登录密码
    private String payPassword;//账号密码

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }
}
