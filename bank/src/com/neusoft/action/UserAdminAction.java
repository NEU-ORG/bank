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
import com.neusoft.po.Constant;
import com.neusoft.po.User;
import com.opensymphony.xwork2.ActionContext;

public class UserAdminAction {
	private AdminManager adminManager;
	private String name;
	private String password;
	private double value;
	private String text;
	private int id;
	public String signUp(){
		/*Map request = (Map) ActionContext.getContext().get("request");*/
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(adminManager.checkOutLogin(name, password))
		{
			session.put("loginInfo", name);
			return "success_admin";
		}
		else
		{
			//Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("FailLogin", "µÇÂ½Ê§°Ü");
			return "error2";
		}
	}
	public String benefitShow()
	{
		return "benefitShow";
	}
	//public String 
/*	public String setCurrent()
	{
		adminManager.currentBenefitSet(value);
		return "";
	}*/
	public String changeBenefit()
	{
		Map<String, Object> request = (Map)ActionContext.getContext().get("request");
		request.put("benefits", adminManager.getBenefitList());
		return "admin_changeBenefit";
	}
	public String benefitSet()
	{
		System.out.println("text"+text);
		//adminManager.scheduledBenefitSet(value, text);
		return "admin_changeBenefit";
		
	}
	
	public AdminManager getAdminManager() {
		return adminManager;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
