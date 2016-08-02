package com.neusoft.action;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.dao.AccountDAO;
import com.neusoft.dao.AdminDAO;
import com.neusoft.dao.ConstantDAO;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.Constant;
import com.neusoft.po.ConstantId;
import com.opensymphony.xwork2.ActionContext;

public class ConstantAction {
	public String execute(){
		Map request = (Map) ActionContext.getContext().get("request");
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminDAO adminDAO = (AdminDAO) ctx.getBean("AdminDAO");
		AccountDAO accountDao = (AccountDAO) ctx.getBean("AccountDAO");
		ConstantDAO constantDao = (ConstantDAO) ctx.getBean("ConstantDAO");
		if(true)
		{
			
		}
		ConstantId benefit_current = (ConstantId)constantDao.findByProperty("text", "»îÆÚ").get(0);
		Double temp = benefit_current.getValue();
/*		benefit_current.setValue(value);
		user.setPassword(password);
		userDao.attachDirty(user);
		return true;*/
		return "success";
	}
	private int value;
	private String text;
	private int id;	

}
