package org.jjly.framework.webmvc.springmvc;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SpringMVCUtils
{
  public static HttpServletRequest getRequest()
  {
    return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
      .getRequest();
  }

  public static HttpSession getSession(boolean b)
  {
    return getRequest().getSession(b);
  }

  public static String getParameter(String name)
  {
    return getRequest().getParameter(name);
  }

  public static void addAttributeHaveFilter(HttpServletRequest request)
  {
    Map<String,String[]> attributeName = request.getParameterMap();
     for (Map.Entry<String,String[]> entry : attributeName.entrySet()) {
      if (StringUtils.indexOf((CharSequence)entry.getKey(), "filter_") == -1){
    	  break;
      }
      request.setAttribute(StringUtils.substringBefore((String)entry.getKey(), "."), 
        ((String[])entry.getValue())[0]);
    }
  }

 /* public static Result returnResult(Integer code, String msg)
  {
    Result result = new Result();
    result.setCode(code);
    result.setMsg(msg);
    return result;
  }

  public static Result returnSuccess(String msg)
  {
    return returnResult(Integer.valueOf(1), msg);
  }

  public static Result returnError(String msg)
  {
    return returnResult(Integer.valueOf(0), msg);
  }

  public static Result returnError(BindingResult bindingResult)
  {
    return returnError(bindingResult.getFieldError().getDefaultMessage());
  }*/
}