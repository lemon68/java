package org.jjly.framework.result.enums;


/**
 * 
 * @Discription 通用接口返回值枚举
 * @Email  zsq.471214943@163.com
 * @Project framework
 * @Author  Steven
 * @Date  2017年09月09日
 */

public enum ResultCodeEnum {
	Success(1, "操作成功"), Error(0, "操作失败"),NoLogin(1100,"尚未登录"),NoAccess(1200, "无访问权限"), FormRepeatSumbit(1300, "表单重复提交");

	private int id;

	private String msg;

	private ResultCodeEnum(int id, String name) {
		this.id = id;
		this.msg = name;
	}

	public int getCode() {
		return id;
	}

	public String getMsg() {
		return msg;
	}

}