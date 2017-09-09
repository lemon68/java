package org.jjly.framework.result.domain;

import org.jjly.framework.result.enums.ResultCodeEnum;

import java.io.Serializable;

/**
 * <p>接口返回值</p>
 * @Package org.jjly.framework.result.domain
 * @author Steven
 * @e-mail 471214943@qq.com
 * @date 2017/9/9 11:29
 * @version V1.0
 */
public class Result<T> implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer resultCode;
	private String resultMsg;
	private T resultObj;
	private String sessionId;
	public Result() {}

	public Integer getResultCode()
	{
		return resultCode;
	}

	public void setResultCode(Integer code)
	{
		this.resultCode = code;
	}

	public String getResultMsg()
	{
		return resultMsg;
	}

	public void setResultMsg(String msg)
	{
		this.resultMsg = msg;
	}

	public T getResultObj()
	{
		return resultObj;
	}

	public void setResultObj(T content)
	{
		this.resultObj = content;
	}

	public String getSessionId()
	{
		return sessionId;
	}

	public void setSessionId(String sessionId)
	{
		this.sessionId = sessionId;
	}
	
	public boolean isSuccess(){
		return resultCode == ResultCodeEnum.Success.getCode();
	}
}
