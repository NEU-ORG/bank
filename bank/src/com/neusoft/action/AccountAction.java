package com.neusoft.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.dao.AccountDAO;
import com.neusoft.po.Account;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport {

	private List<Account> accountList;
	private ApplicationContext ctx;
	private AccountDAO accountDao;

	public void init() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		accountDao = (AccountDAO) ctx.getBean("AccountDAO");
	}

	public void destroy() {
	}

	public String info() {
		init();
		destroy();
		return "info";
	}

	public String list() {
		try {
			init();
			accountList = accountDao.findAll();
			
			Map request = (Map)ActionContext.getContext().get("request");
			request.put("accountList", accountList);
			
			System.out.println("n="+accountList.size());
			Iterator Iter = accountList.iterator();
			while (Iter.hasNext()) {
				Account t = (Account) Iter.next();
				System.out.println("account:\nid:"+t.getId()+
						"\nname:"+t.getName()+
						"\nuser_id:"+t.getUser().getId()+
						"\naccount_number:"+t.getAccountNumber()+
						"\nstatus:"+t.getStatus()+
						"\nbalance:"+t.getBalance());
			}
			destroy();
		} catch (RuntimeException re) {
			System.out.println("list failed");
			throw re;
			//return "error";	
		}
		return "list";
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
}
