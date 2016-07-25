package com.neusoft.action;

import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class LoginAction implements SessionAware{
	public String execute() {
//		for(Map.Entry<String, Object> entry: session.entrySet()){
//			System.out.println("->"+entry.getKey()+entry.getValue());
//		}
		String result;
		if(userName!=null&&userName.equals("admin")&&password.equals("admin")){
			session.put("loginInfo",userName);
			result = "admin";
			
		}else if(userName!=null&&userName.equals(password)){
			session.put("loginInfo",userName);
			result = "success";
		}else{
			session.put("loginError","用户名或密码不正确！！");
			result = "error";
		}
		return result;
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
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	private String userName;
	private String password;
	private Map<String, Object> session;
	public Map<String, Object> getSession() {
		return session;
	}
}
