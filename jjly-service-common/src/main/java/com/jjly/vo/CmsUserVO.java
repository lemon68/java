package com.jjly.vo;

import com.jjly.enums.GenderTypeEnum;
import com.jjly.enums.UserStatusEnum;
import org.jjly.framework.orm.LongBaseEntity;

/**
 * <p>//TODO(描述该类的功能) </p>
 *
 * @author Steven
 * @version V1.0
 * @Package com.jjly.vo
 * @e-mail 47121494@qq.com
 * @date 2017/9/15 10:00
 */
public class CmsUserVO{
    private String userName;
    private String password;
    private String name;
    private String mobile;
    private String tel;
    private String email;
    private String address;
    private GenderTypeEnum gender;
    private UserStatusEnum userStatus;
    private Long roleId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GenderTypeEnum getGender() {
        return gender;
    }

    public void setGender(GenderTypeEnum gender) {
        this.gender = gender;
    }

    public UserStatusEnum getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatusEnum userStatus) {
        this.userStatus = userStatus;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
