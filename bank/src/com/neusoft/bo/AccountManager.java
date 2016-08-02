package com.neusoft.bo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.dao.AccountDAO;
import com.neusoft.po.Account;
import com.opensymphony.xwork2.ActionSupport;

public class AccountManager extends ActionSupport{
	private AccountDAO accountDAO;
	private ApplicationContext ctx;
	
	private void init() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		accountDAO = (AccountDAO) ctx.getBean("AccountDAO");
	}
	
	//0-�ɹ�
	//-1-���˻�
	public int changeTransPwd(Integer aid, String password) {
		init();
		Account account = accountDAO.findById(aid);
		if(account.equals(null)) {
			System.out.println("null");
			return -1;
		}
		account.setTransactionPassword(password);
		accountDAO.attachDirty(account);
		return 0;
	}
	
	//0-�ɹ�
	//-1-���˻�
	//1-������
	public int lock(Integer aid) {
		init();
		Account account = accountDAO.findById(aid);
		if(account.equals(null)) {
			System.out.println("null");
			return -1;
		}
		if(account.getStatus().equals("lock")) {
			System.out.println("��������״̬");
			return 1;
		}
		account.setStatus("lock");
		accountDAO.attachDirty(account);
		return 0;
	}
}
