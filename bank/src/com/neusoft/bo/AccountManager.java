package com.neusoft.bo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.dao.AccountDAO;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.Account;
import com.neusoft.po.User;
import com.opensymphony.xwork2.ActionSupport;

public class AccountManager extends ActionSupport{
	private AccountDAO accountDAO;
	private UserDAO userDAO;
	private ApplicationContext ctx;
	
	//0：成功；-1：user不存在；-2：银行卡不存在
	//-3：非本人的卡；1：已添加
	public int AddAccount(String userName, String accountNumber, String transPwd) {
		List<User> users = userDAO.findByProperty("userName", userName);
		if(users.size() != 1)
			return -1;
		List<Account> accounts = accountDAO.findByProperty("accountNumber", accountNumber);
		if(accounts.size() != 1)
			return -2;
		if(!accounts.get(0).getUser().getUserName().equals(userName))
			return -3;
		if(!accounts.get(0).getIsSigned().equals("none"))
			return 1;
		accounts.get(0).setTransactionPassword(transPwd);
		accounts.get(0).setIsSigned("unsigned");
		accountDAO.attachDirty(accounts.get(0));
		return 0;
	}
	
	//0-成功；-1-无账户；-2：密码错误
	public int judgeTransPwd(Integer aid, String password) {
		Account account = accountDAO.findById(aid);
		if(account.equals(null)) {
			System.out.println("null");
			return -1;
		}
		//System.out.println("1:"+password);
		String pwd = account.getTransactionPassword();
		if(!pwd.equals(password))
			return -2;
		return 0;
	}
	
	//0-成功；-1-无账户
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
	
	//0-成功；-1-无账户；1-已锁定
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

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
