package com.neusoft.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.dao.ConstantDAO;
import com.neusoft.po.Constant;
import com.opensymphony.xwork2.ActionSupport;

public class BenefitAction extends ActionSupport {
	public String benefitList(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ConstantDAO constantDao = (ConstantDAO) ctx.getBean("ConstantDAO");
		if(!constantDao.findByProperty("存款利率",type).isEmpty())
		{
			Constant constant = (Constant) constantDao.findByProperty("存款利率", type);
			
			
			
		}
		return "success";
	}
	
	public ConstantDAO getConstantDao() {
		return constantDao;
	}

	public void setConstantDao(ConstantDAO constantDao) {
		this.constantDao = constantDao;
	}

	private ConstantDAO constantDao;
	private String type;
}
