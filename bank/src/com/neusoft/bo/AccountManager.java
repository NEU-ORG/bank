package com.neusoft.bo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.dao.AccountDAO;
import com.neusoft.po.Account;
import com.opensymphony.xwork2.ActionSupport;

public class AccountManager extends ActionSupport{
	private AccountDAO accountDAO;
	private ApplicationContext ctx;
	
	public int judgeTransPwd(Integer aid, String password) {
		Account account = accountDAO.findById(aid);
		if(account.equals(null)) {
			System.out.println("null");
			return -1;
		}
		System.out.println("1:"+password);
		String pwd = account.getTransactionPassword();
		if(!pwd.equals(password))
			return -2;
		return 0;
	}
	
	//0-成功
	//-1-无账户
	public int changeTransPwd(Integer aid, String password) {
		Account account = accountDAO.findById(aid);
		if(account.equals(null)) {
			System.out.println("null");
			return -1;
		}
		account.setTransactionPassword(password);
		accountDAO.attachDirty(account);
		return 0;
	}
	
	//0-成功
	//-1-无账户
	//1-已锁定
	public int lock(Integer aid) {
		Account account = accountDAO.findById(aid);
		if(account.equals(null)) {
			System.out.println("null");
			return -1;
		}
		if(account.getStatus().equals("lock")) {
			System.out.println("已是锁定状态");
			return 1;
		}
		account.setStatus("lock");
		accountDAO.attachDirty(account);
		return 0;
	}

	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
}
