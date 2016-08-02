package com.neusoft.action;

import com.neusoft.dao.ConstantDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BenefitAction extends ActionSupport {
	public String benefitList(){
		return "success";
	}
	
	public ConstantDAO getConstantDao() {
		return constantDao;
	}

	public void setConstantDao(ConstantDAO constantDao) {
		this.constantDao = constantDao;
	}

	private ConstantDAO constantDao;
}
