package com.neusoft.bo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.dao.AccountDAO;
import com.neusoft.dao.TransactionDetailDAO;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.Account;
import com.neusoft.po.TransactionDetail;
import com.neusoft.po.User;
import com.opensymphony.xwork2.ActionSupport;

public class AccountManager extends ActionSupport{
	private AccountDAO accountDAO;
	private UserDAO userDAO;
	private TransactionDetailDAO transDAO;
	private ApplicationContext ctx;
	
	//0：成功；-1：无账户；-2：无目标账户
	//1：金额不足
	public int transfer(int aid, String tanum, double pay) {
		Account a = accountDAO.findById(aid);
		if(a.equals(null)) {
			System.out.println("a null");
			return -1;
		}
		List<Account> talist = accountDAO.findByProperty("accountNumber", tanum);
		if(talist.size() != 1) {
			System.out.println("ta null");
			return -2;
		}
		Account ta = talist.get(0);
		double ab = a.getBalance();
		double aab = a.getAvailableBalance();
		double tab = ta.getBalance();
		double taab = ta.getAvailableBalance();
		if(aab < pay) {
			System.out.println("no");
			return 1;
		}
		a.setAvailableBalance(aab-pay);
		a.setBalance(ab-pay);
		ta.setBalance(tab+pay);
		ta.setAvailableBalance(taab+pay);
		accountDAO.attachDirty(a);
		accountDAO.attachDirty(ta);
		TransactionDetail td1 = new TransactionDetail();
		TransactionDetail td2 = new TransactionDetail();
		td1.setAccountByAccountId(a);
		td1.setAccountByTargetAccount(ta);
		td2.setAccountByAccountId(ta);
		td2.setAccountByTargetAccount(a);
		td1.setAmountPaid(pay);
		td1.setAmountReceived(0.00);
		td2.setAmountPaid(0.00);
		td2.setAmountReceived(pay);
		td1.setBalance(a.getBalance());
		td2.setBalance(ta.getBalance());
		td1.setType("转账");
		td2.setType("收款");
		td1.setCurrency("CNY");
		td2.setCurrency("CNY");
//		System.out.println("a1");
//		TransactionDetail tdtest = transDAO.findById(1);
//		tdtest.setMessage("cunkuan");
//		transDAO.save(tdtest);
		transDAO.save(td1);
		transDAO.save(td2);
		return 0;
	}
	
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

	public TransactionDetailDAO getTransDAO() {
		return transDAO;
	}

	public void setTransDAO(TransactionDetailDAO transDAO) {
		this.transDAO = transDAO;
	}
}
