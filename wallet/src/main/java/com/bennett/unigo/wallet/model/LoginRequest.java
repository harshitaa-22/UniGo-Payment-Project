package com.bennett.unigo.wallet.model;


public class LoginRequest {


    private String userName;
    private String password;
    
	public LoginRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public LoginRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
    
}
