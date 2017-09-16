package com.jjly.enums;

/**
 * <p>用户状态枚举类 </p>
 *
 * @author Steven
 * @version V1.0
 * @Package com.jjly.enums
 * @e-mail 47121494@qq.com
 * @date 2017/9/15 10:25
 */
public enum  UserStatusEnum {
    regular(1,"正常"),lock(2,"已锁"),audit(3,"审核中"),del(4,"已删除");
    private UserStatusEnum(int code,String msg){
        this.code=code;
        this.msg=msg;
    }
    private int code;
    private String msg;
    private UserStatusEnum[] userStatusEnums=UserStatusEnum.values();
    public UserStatusEnum createInstance(int code){
        for(UserStatusEnum userStatusEnum: userStatusEnums){
            if(userStatusEnum.getCode()==code){
                return  userStatusEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
