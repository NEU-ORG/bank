package com.neusoft.action;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.bo.AdminManager;
import com.neusoft.dao.AccountDAO;
import com.neusoft.dao.AdminDAO;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.Account;
import com.neusoft.po.Admin;
import com.neusoft.po.User;
import com.opensymphony.xwork2.ActionContext;

public class UserAdminAction {
	public String signUp(){
		Map request = (Map) ActionContext.getContext().get("request");
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminDAO adminDao = (AdminDAO) ctx.getBean("AdminDAO");
		if(adminManager.checkOutLogin(name, password))
		{
			return "success_admin";
		}
		else
		{
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("FailLogin", "µÇÂ½Ê§°Ü");
			return "error2";
		}
	}
	
	//public String 
	
	private AdminManager adminManager;
	private String name;
	private String password;
	public AdminManager getAdminManager() {
		return adminManager;
	}
	public void setAdminManager(AdminManager adminManager) {
		this.adminManager = adminManager;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	



}
