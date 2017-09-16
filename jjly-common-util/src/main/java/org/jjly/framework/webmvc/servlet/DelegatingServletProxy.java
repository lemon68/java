package org.jjly.framework.webmvc.servlet;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class DelegatingServletProxy extends GenericServlet
{
  private static final long serialVersionUID = -2430785308415168690L;
  private String targetBean;
  private Servlet proxy;

  public void service(ServletRequest req, ServletResponse res)
    throws ServletException, IOException
  {
    this.proxy.service(req, res);
  }

  public void init() throws ServletException {
    this.targetBean = getServletName();
    getServletBean();
    this.proxy.init(getServletConfig());
  }

  private void getServletBean() {
    WebApplicationContext wac = 
      WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
    this.proxy = ((Servlet)wac.getBean(this.targetBean));
  }
}