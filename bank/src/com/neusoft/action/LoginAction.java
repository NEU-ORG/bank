package com.neusoft.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.bo.UserManager;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.User;
import com.opensymphony.xwork2.ActionContext;


public class LoginAction implements SessionAware{
	public String execute() {
		String result;
		if(userName!=null&&userName.equals("admin")&&password.equals("admin")){
			session.put("loginInfo",userName);
			result = "admin";
			
		}else if(userName!=null&&userManager.checkOutLogin(userName, password)){
			System.out.println("444");
			Map<String,Object> session = ActionContext.getContext().getSession();
			if(!(session.get("loginError")==null))
			{
				session.remove("loginError");
			}
				session.put("loginInfo",userName);
				result = "success";
		}else{
			session.put("loginError","用户名或密码不正确！！");
			result = "error";
		}
		return result;
		
	}
	
	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
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
	private UserManager userManager;
	private Map<String, Object> session;
	public Map<String, Object> getSession() {
		return session;
	}
}
