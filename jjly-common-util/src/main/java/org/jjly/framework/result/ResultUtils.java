package org.jjly.framework.result;

import org.jjly.framework.result.domain.Result;
import org.jjly.framework.result.enums.ResultCodeEnum;


/**
 * 
 * @Discription 通用接口返回值工具类
 * @Email  zsq.471214943@163.com
 * @Project framework
 * @Author  Steven
 * @Date  2015年3月4日
 */

public class ResultUtils
{
	public ResultUtils() {}

	/**
	 * <p>
	 *  说明：返回resultCode=0，参考：
	 * </p>
	 * <p>
	 *  链接：{@link Result} resultCode=0，resultMsg=msg,resultObj=null,sessionId=null
	 * </p>
	 *  * @param msg 错误提示信息
	 *  * @return  result
	 * @auth Steven
	 */
	public static Result returnError(String msg){
		return   returnError(msg,ResultCodeEnum.Error.getCode());
	}

	/**
	 * 
	 * <p>
	 *  说明：返回自定义返回码和自定义提示信息，resultCode=0}
	 * </p>
	 * @param msg 提示信息
	 * @param code 自定义错误返回码，code尽量在10000以上，10000以内的错误返回码为系统保留
	 * @return {@link Result} resultCode=0，resultMsg=msg,resultObj=null,sessionId=null
	 * @author Steven
	 */
	public static Result returnError(String msg, Integer code)
	{
		Result result = new Result();
		result.setResultCode(code);
		result.setResultMsg(msg);
		return result;
	}

	/**
	 * 
	 * <p>
	 *  说明：返回业务处理成功后的提示信息。resultCode=1，参考：{@link ResultCodeEnum}的Success枚举
	 * </p>
	 * @param msg 成功提示信息
	 * @return {@link Result} resultCode=1，resultMsg=msg,resultObj=null,sessionId=null
	 * @author Steven
	 */
	public static Result returnSuccess(String msg)
	{
		 return returnSuccess(msg,null,null);
	}

	/**
	 * 
	 * <p>
	 *  说明：业务逻辑处理成功后，返回提示信息和数据，ResultCode=1
	 * </p>
	 * @param msg 提示信息
	 * @param object 业务数据
	 * @return
	 * @author Steven
	 */
	public static <T>  Result<T>  returnSuccess(String msg, T object)
	{
		return returnSuccess(msg,object,null);
	}

	
	/**
	 * 
	 * <p>
	 *  说明：业务逻辑处理成功后，返回提示信息和数据，ResultCode=1
	 * </p>
	 * @param msg 提示消息
	 * @param object 数据
	 * @param sessionId 当前登录用户的sessionId
	 * @return {@link Result<T> >
	 * @author Steven
	 */
	public static <T> Result<T> returnSuccess(String msg, T object, String sessionId)
	{
		Result<T> result = new Result<T> ();
		result.setResultCode(ResultCodeEnum.Success.getCode());
		result.setResultObj(object);
		result.setResultMsg(msg);
		result.setSessionId(sessionId);
		return result;
	}
}
