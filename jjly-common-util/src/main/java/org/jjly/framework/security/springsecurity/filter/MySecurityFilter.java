package org.jjly.framework.security.springsecurity.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class MySecurityFilter extends AbstractSecurityInterceptor
  implements Filter
{
  private FilterInvocationSecurityMetadataSource securityMetadataSource;
  private boolean observeOncePerRequest = true;

  public void init(FilterConfig arg0)
    throws ServletException
  {
  }

  public void destroy()
  {
  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException
  {
    FilterInvocation fi = new FilterInvocation(request, response, chain);
    invoke(fi);
  }

  public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
    return this.securityMetadataSource;
  }

  public SecurityMetadataSource obtainSecurityMetadataSource() {
    return this.securityMetadataSource;
  }

  public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource newSource) {
    this.securityMetadataSource = newSource;
  }

  public Class<?> getSecureObjectClass() {
    return FilterInvocation.class;
  }

  public void invoke(FilterInvocation fi) throws IOException, ServletException
  {
    InterceptorStatusToken token = super.beforeInvocation(fi);

    fi.getChain().doFilter(fi.getRequest(), fi.getResponse());

    super.afterInvocation(token, null);
  }

  public boolean isObserveOncePerRequest()
  {
    return this.observeOncePerRequest;
  }

  public void setObserveOncePerRequest(boolean observeOncePerRequest) {
    this.observeOncePerRequest = observeOncePerRequest;
  }
}