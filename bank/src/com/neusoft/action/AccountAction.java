package com.neusoft.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.dao.AccountDAO;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.Account;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport {

	private List<Account> accountList;
	private String accountNumber;
	private String transactionPassword;
	private String retransactionPassword;

	private ApplicationContext ctx;
	private AccountDAO accountDAO;

	public void init() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		accountDAO = (AccountDAO) ctx.getBean("AccountDAO");
	}

	public void destroy() {
	}

	public String info() {
		return "info";
	}
	
	public String payment_win() {
		return "payment_win";
	}

	public String list() {
		try {
			init();
			accountList = accountDAO.findAll();

			Map request = (Map) ActionContext.getContext().get("request");
			request.put("accountList", accountList);

			System.out.println("n=" + accountList.size());
			// Iterator Iter = accountList.iterator();
			// while (Iter.hasNext()) {
			// Account t = (Account) Iter.next();
			// System.out.println("account:\nid:"+t.getId()+
			// "\nname:"+t.getName()+
			// "\nuser_id:"+t.getUser().getId()+
			// "\naccount_number:"+t.getAccountNumber()+
			// "\nstatus:"+t.getStatus()+
			// "\nbalance:"+t.getBalance());
			// }
			destroy();
		} catch (RuntimeException re) {
			System.out.println("list failed");
			throw re;
			// return "error";
		}
		return "list";
	}

	public String create_win() {
		return "create_win";
	}

	public String create() {
		try {
			init();
			UserDAO userDao = (UserDAO) ctx.getBean("UserDAO");

			Account newAccount = new Account();
			newAccount.setAccountNumber(accountNumber);
			newAccount.setTransactionPassword(transactionPassword);
			newAccount.setUser(userDao.findById(2));
			newAccount.setWithdrawalPassword("123456");
			newAccount.setCurrency("RMB");
			newAccount.setStatus("normal");
			newAccount.setIsSigned(true);
			newAccount.setType("huo");
			// Timestamp t = new Timestamp(new Date().getTime());
			// System.out.println("t:"+t);
			// newAccount.setCreateDate(t);
			newAccount.setCreateBank("renminbank");
			newAccount.setBalance(0.00);
			newAccount.setAvailableBalance(0.00);

			System.out.println("account:\nid:" + newAccount.getId() + "\nname:"
					+ newAccount.getName() + "\nuser_id:"
					+ newAccount.getUser().getId() + "\naccount_number:"
					+ newAccount.getAccountNumber() + "\nstatus:"
					+ newAccount.getStatus() + "\nbalance:"
					+ newAccount.getBalance());

			accountDAO.attachDirty(newAccount);

		} catch (RuntimeException re) {
			System.out.println("error");
			throw re;
			// return "error";
		}
		return "create";
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getTransactionPassword() {
		return transactionPassword;
	}
	
	public String getRetransactionPassword() {
		return retransactionPassword;
	}

	public void setRetransactionPassword(String retransactionPassword) {
		this.retransactionPassword = retransactionPassword;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}
}
