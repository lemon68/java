package org.jjly.framework.security.springsecurity;

public interface AccessDecisionManager {
	public boolean isAuthorize(String url);
}
