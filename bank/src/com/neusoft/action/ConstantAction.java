package com.neusoft.action;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.bo.AdminManager;
import com.neusoft.dao.AccountDAO;
import com.neusoft.dao.AdminDAO;
import com.neusoft.dao.ConstantDAO;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.Constant;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ConstantAction extends ActionSupport{
	public String execute(){
		Map request = (Map) ActionContext.getContext().get("request");
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminDAO adminDAO = (AdminDAO) ctx.getBean("AdminDAO");
		AccountDAO accountDao = (AccountDAO) ctx.getBean("AccountDAO");
		ConstantDAO constantDao = (ConstantDAO) ctx.getBean("ConstantDAO");
		if(adminManager.checkOutLogin(name, password))
		{
			Constant constant = (Constant)constantDao.findByProperty("text", "»îÆÚ").get(0);
			constant.setValue(value);
			constantDao.attachDirty(constant);
		}
		return "success";
	}
	private double value;
	private String text;
	private int id;	
	private String name;
	private String password;
	private AdminManager adminManager;

}
