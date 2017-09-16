package org.jjly.framework.security.springsecurity;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jjly.framework.webmvc.springmvc.SpringMVCUtils;


public class AccessDecisionManagerImpl implements AccessDecisionManager{
	@Override
	public boolean isAuthorize(String url) {
		List<String> resourceUrls = getResourceUrls();
		if(CollectionUtils.isNotEmpty(resourceUrls)){
			for (String resourceUrl : resourceUrls) {
				if(StringUtils.isNoneEmpty(resourceUrl)){
					if(url.contains(resourceUrl)){
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	 * 获取权限url
	 * 
	 * @return
	 */
	public static List<String> getResourceUrls() {
		return (List<String>)SpringMVCUtils.getRequest().getSession().getAttribute("resourceUrls");
	}

}
