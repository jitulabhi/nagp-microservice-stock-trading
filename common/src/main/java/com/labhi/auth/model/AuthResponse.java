package com.labhi.auth.model;

public class AuthResponse {
	 private String accessToken ;
	 private String loginId;

	    public AuthResponse(String accessToken, String loginId) {
	        this.accessToken = accessToken;
	        this.loginId = loginId;
	    }

	    public AuthResponse() {
	    }

	    public String getAccessToken() {
	        return accessToken;
	    }

	    public void setAccessToken(String accessToken) {
	        this.accessToken = accessToken;
	    }

		public String getLoginId() {
			return loginId;
		}

		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
	    
	    

}
