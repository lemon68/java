package im.huanxin.api.impl;

import im.huanxin.api.AuthTokenAPI;
import im.huanxin.comm.TokenUtil;


public class EasemobAuthToken implements AuthTokenAPI{

	@Override
	public Object getAuthToken(){
		return TokenUtil.getAccessToken();
	}
}
