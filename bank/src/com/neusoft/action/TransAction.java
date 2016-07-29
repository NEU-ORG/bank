package com.neusoft.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.dao.AccountDAO;
import com.neusoft.dao.TransactionDetailDAO;
import com.opensymphony.xwork2.ActionSupport;

public class TransAction extends ActionSupport {
	private ApplicationContext ctx;
	private AccountDAO accountDAO;
	private TransactionDetailDAO transactionDetailDAO;

	public void init() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		accountDAO = (AccountDAO) ctx.getBean("AccountDAO");
	}

	public void destroy() {
	}
}
