package com.jjly.enums;

/**
 * <p>性别枚举类</p>
 *
 * @author Steven
 * @version V1.0
 * @Package com.jjly.enums
 * @e-mail 47121494@qq.com
 * @date 2017/9/15 10:11
 */
 public enum  GenderTypeEnum {
    man(1,"男"),woman(2,"女");
    private GenderTypeEnum(int code,String msg){
        this.code=code;
        this.msg=msg;
    }
    private Integer code;
    private String msg;
    private static GenderTypeEnum[] genderTypeEnumses=GenderTypeEnum.values();

    public static GenderTypeEnum createInstance(int code){
        for(GenderTypeEnum genderTypeEnum:genderTypeEnumses){
            if(genderTypeEnum.getCode().equals(code)){
                return genderTypeEnum;
            }
        }
        return null;
    }


    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
