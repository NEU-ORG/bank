package com.neusoft.action;

public class LoginAction {
	public String execute(){
		if(userName!=null&&userName.equals("admin")){
			return "admin";
		}
		return "success";
	}
	private String userName;
	private String password;
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
