package com.neusoft.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.bo.AccountManager;
import com.neusoft.dao.AccountDAO;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.Account;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport {
	private AccountManager accountManager;

	public String info() {
		return "info";
	}
	
	public String transfer_win() {
		return "transfer_win";
	}
	
	public String transfer() {
		String aid = ServletActionContext.getRequest().getParameter("accountId");
		String tanum = ServletActionContext.getRequest().getParameter("targetAccountNumber");
		String pay = ServletActionContext.getRequest().getParameter("pay");
		String pwd = ServletActionContext.getRequest().getParameter("pwd");
		boolean b = (aid == null || aid.isEmpty() || 
					 tanum == null || tanum.isEmpty() || 
					 pay == null || pay.isEmpty() || 
					 pwd == null || pwd.isEmpty());
		if(b) return "transfer_win";
		Integer id = Integer.parseInt(aid);
		int t1 = accountManager.judgeTransPwd(id, pwd);
		System.out.println("t1:"+t1);
		if(t1 != 0)
			return "transfer_win";
		Double p = Double.parseDouble(pay);
		int t2 = accountManager.transfer(id, tanum, p);
		System.out.println("t2:"+t2);
		if(t2 != 0)
			return "transfer_win";
		return "transfer";
	}
	
	public String transdetail_win() {
		String aid = ServletActionContext.getRequest().getParameter("accountId");
		String display = ServletActionContext.getRequest().getParameter("display");
		Map<String,Object> session = ActionContext.getContext().getSession();
		session.put("aid", aid);
		session.put("display", display);
		return "transdetail_win";
	}
	
	public String changepwd_win() {
		return "changepwd_win";
	}
	
	public String changepwd() throws IOException {
		String tspwd = ServletActionContext.getRequest().getParameter("pwd");
		String oldpwd = ServletActionContext.getRequest().getParameter("oldpwd");
		String accountId = ServletActionContext.getRequest().getParameter("accountId");
		if(accountId == null||accountId.isEmpty()) {
			return "error";
		} else {
			Map<String,Object> session = ActionContext.getContext().getSession();
			Integer id = Integer.parseInt(accountId);
			int temp = accountManager.judgeTransPwd(id, oldpwd);
			System.out.println("t1:"+temp);
			ServletActionContext.getResponse().getWriter().write("temp");
			if(temp != 0)
				session.put("passwordError","·账户或密码不正确！");
			else {
				if(session.get("passwordError")!=null)
				{
					session.remove("passwordError");
				}
				temp = accountManager.changeTransPwd(id, tspwd);
				System.out.println("t2:"+temp);
				if(temp == 0) {
					session.put("passwordError","修改成功！");
				}
			}
		}
		return "changepwd";
	}
	
	public String lockwin() {
		return "lockwin";
	}
	
	public String lock() {
		String tspwd = ServletActionContext.getRequest().getParameter("pwd");
		String accountId = ServletActionContext.getRequest().getParameter("accountId");
		if(accountId == null||accountId.isEmpty()) {
			return "error";
		} else {
			Map<String,Object> session = ActionContext.getContext().getSession();
			Integer id = Integer.parseInt(accountId);
			int temp1 = accountManager.judgeTransPwd(id, tspwd);
			if(temp1 != 0)
				session.put("passwordError","·密码不正确！");
			else {
				if(session.get("passwordError")!=null)
				{
					session.remove("passwordError");
				}
				int temp2 = accountManager.lock(id);
				//System.out.println("t:"+temp2);
				if(temp2 == -1)
					return "error";
				else if(temp2 == 1)
					session.put("passwordError","账户已经锁定！");
				if(temp2 == 0) {
					session.put("passwordError","修改成功！");
				}
			}
		}
		return "lock";
	}

	public String create_win() {
		return "create_win";
	}

	public String addaccount() {
		System.out.println("t");
		String tspwd = ServletActionContext.getRequest().getParameter("pwd");
		String accountNumber = ServletActionContext.getRequest().getParameter("accountNumber");
		Map<String,Object> session = ActionContext.getContext().getSession();
		String userName = (String) session.get("loginInfo");
		if(tspwd == null || tspwd.isEmpty() || accountNumber == null || accountNumber.isEmpty())
			return "create_win";
		int temp = accountManager.AddAccount(userName,accountNumber,tspwd);
		System.out.println("t1:"+temp);
		return "create";
	}

	public String list() {
//		try {
//			init();
//			accountList = accountDAO.findAll();
//
//			Map request = (Map) ActionContext.getContext().get("request");
//			request.put("accountList", accountList);
//
//			System.out.println("n=" + accountList.size());
//			// Iterator Iter = accountList.iterator();
//			// while (Iter.hasNext()) {
//			// Account t = (Account) Iter.next();
//			// System.out.println("account:\nid:"+t.getId()+
//			// "\nname:"+t.getName()+
//			// "\nuser_id:"+t.getUser().getId()+
//			// "\naccount_number:"+t.getAccountNumber()+
//			// "\nstatus:"+t.getStatus()+
//			// "\nbalance:"+t.getBalance());
//			// }
//			destroy();
//		} catch (RuntimeException re) {
//			System.out.println("list failed");
//			throw re;
//			// return "error";
//		}
		return "list";
	}

	public AccountManager getAccountManager() {
		return accountManager;
	}

	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}
	
	
}
