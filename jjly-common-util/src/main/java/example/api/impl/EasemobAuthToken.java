package example.api.impl;

import example.api.AuthTokenAPI;
import example.comm.TokenUtil;


public class EasemobAuthToken implements AuthTokenAPI{

	@Override
	public Object getAuthToken(){
		return TokenUtil.getAccessToken();
	}
}
