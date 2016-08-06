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
import com.neusoft.bo.LogManager;
import com.neusoft.dao.AccountDAO;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.Account;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport {
	private AccountManager accountManager;
	private String jsonResult;
	private LogManager logManager;

	public String getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	public String info() {
		return "info";
	}
	
	public String test() {
		String val = ServletActionContext.getRequest().getParameter("val");
		System.out.println("val:"+val);
		jsonResult = "4567";
		return SUCCESS;
	}
	
	public void addlogmsg(String type, String message) {
		Map<String,Object> session = ActionContext.getContext().getSession();
		String operator = (String) session.get("loginInfo");
		logManager.addLog(operator, type, message);
	}
	
	public String paydetail_win() {
		return "paydetail_win";
	}
	
	public String payment_win() {
		return "payment_win";
	}
	
	public String payment() {
		String aid = ServletActionContext.getRequest().getParameter("accountId");
		String tanum = ServletActionContext.getRequest().getParameter("targetAccountNumber");
		String pay = ServletActionContext.getRequest().getParameter("pay");
		String pwd = ServletActionContext.getRequest().getParameter("pwd");
		boolean b = (aid == null || aid.isEmpty() || 
					 tanum == null || tanum.isEmpty() || 
					 pay == null || pay.isEmpty() || 
					 pwd == null || pwd.isEmpty());
		if(b) {
			jsonResult = "请输入数据！";
			return SUCCESS;
		}
		Integer id = Integer.parseInt(aid);
		int t1 = accountManager.judgeTransPwd(id, pwd);
		System.out.println("t1:"+t1);
		if(t1 != 0)
			jsonResult = "密码不正确！";
		else {
			Double p = Double.parseDouble(pay);
			int t2 = accountManager.payment(id, tanum, p);
			System.out.println("t2:"+t2);
			if(t2 == -1) {
				System.out.println("account error");
				return "error";
			}
			else if(t2 == 1)
				jsonResult = "账户余额不足！";
			else {
				jsonResult = "缴费成功！";
				this.addlogmsg("交易", "缴费"+tanum);
			}
		}
		
		return SUCCESS;
	}
	
	public String paylist_win() {
		return "paylist_win";
	}
	
	public String delete_win() {
		return "delete_win";
	}
	
	public String delete() {
		String tspwd = ServletActionContext.getRequest().getParameter("pwd");
		String accountId = ServletActionContext.getRequest().getParameter("accountId");
		if(accountId == null||accountId.isEmpty()) {
			System.out.println("account empty");
			return "error";
		} else {
			Map<String,Object> session = ActionContext.getContext().getSession();
			Integer id = Integer.parseInt(accountId);
			int temp1 = accountManager.judgeTransPwd(id, tspwd);
			System.out.println("t1:"+temp1);
			if(temp1 != 0)
				jsonResult = "密码不正确！";
			else {
				int temp2 = accountManager.delete(id);
				System.out.println("t2:"+temp2);
				if(temp2 == -1) {
					System.out.println("account error");
					return "error";
				} else if(temp2 == 1)
					jsonResult = "银行卡已经删除！";
				if(temp2 == 0) {
					jsonResult = "银行卡删除成功！";
					this.addlogmsg("信息修改", "删除银行卡"+accountId);
				}
			}
		}
		
		return SUCCESS;
	}
	
	public String transferdetail_win() {
		return "transferdetail_win";
	}
	
	public String db_transfer_win() {
		return "db_transfer_win";
	}
	
	public String db_transfer() {
		String aid = ServletActionContext.getRequest().getParameter("accountId");
		String tanum = ServletActionContext.getRequest().getParameter("targetAccountNumber");
		String pay = ServletActionContext.getRequest().getParameter("pay");
		String pwd = ServletActionContext.getRequest().getParameter("pwd");
		boolean b = (aid == null || aid.isEmpty() || 
					 tanum == null || tanum.isEmpty() || 
					 pay == null || pay.isEmpty() || 
					 pwd == null || pwd.isEmpty());
		if(b) {
			jsonResult = "请输入数据！";
			return SUCCESS;
		}
		Integer id = Integer.parseInt(aid);
		int t1 = accountManager.judgeTransPwd(id, pwd);
		System.out.println("t1:"+t1);
		if(t1 != 0)
			jsonResult = "密码不正确！";
		else {
			Double p = Double.parseDouble(pay);
			int t2 = accountManager.db_transfer(id, tanum, p);
			System.out.println("t2:"+t2);
			if(t2 == -1) {
				System.out.println("account error");
				return "error";
			}
			if(t2 == -2)
				jsonResult = "目标账户不存在！";
			else if(t2 == -4)
				jsonResult = "账户不能相同";
			else if(t2 == 1)
				jsonResult = "账户余额不足！";
			else {
				jsonResult = "转账成功！";
				this.addlogmsg("交易", "跨行转账"+aid);
			}
		}
		
		return SUCCESS;
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
		if(b) {
			jsonResult = "请输入数据！";
			return SUCCESS;
		}
		Integer id = Integer.parseInt(aid);
		int t1 = accountManager.judgeTransPwd(id, pwd);
		System.out.println("t1:"+t1);
		if(t1 != 0)
			jsonResult = "密码不正确！";
		else {
			Double p = Double.parseDouble(pay);
			int t2 = accountManager.transfer(id, tanum, p);
			System.out.println("t2:"+t2);
			if(t2 == -1) {
				System.out.println("account error");
				return "error";
			}
			if(t2 == -2)
				jsonResult = "目标账户不存在！";
			else if(t2 == -3)
				jsonResult = "银行不同，请跨行转账！";
			else if(t2 == -4)
				jsonResult = "账户不能相同";
			else if(t2 == 1)
				jsonResult = "账户余额不足！";
			else {
				jsonResult = "转账成功！";
				this.addlogmsg("交易", "转账"+aid);
			}
		}
		
		return SUCCESS;
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
	
	public String changepwd() {
		String tspwd = ServletActionContext.getRequest().getParameter("pwd");
		String oldpwd = ServletActionContext.getRequest().getParameter("oldpwd");
		String accountId = ServletActionContext.getRequest().getParameter("accountId");
		if(accountId == null||accountId.isEmpty()) {
			System.out.println("account empty");
			return "error";
		} else {
			Integer id = Integer.parseInt(accountId);
			int temp = accountManager.judgeTransPwd(id, oldpwd);
			System.out.println("t1:"+temp);
			if(temp != 0)
				jsonResult = "密码不正确！";
			else {
				temp = accountManager.changeTransPwd(id, tspwd);
				System.out.println("t2:"+temp);
				if(temp == 0) {
					jsonResult = "修改成功！";
					this.addlogmsg("信息修改", "修改密码");
				}
			}
		}
		return SUCCESS;
	}
	
	public String lockwin() {
		return "lockwin";
	}
	
	public String lock() {
		String tspwd = ServletActionContext.getRequest().getParameter("pwd");
		String accountId = ServletActionContext.getRequest().getParameter("accountId");
		if(accountId == null||accountId.isEmpty()) {
			System.out.println("account empty");
			return "error";
		} else {
			Map<String,Object> session = ActionContext.getContext().getSession();
			Integer id = Integer.parseInt(accountId);
			int temp1 = accountManager.judgeTransPwd(id, tspwd);
			System.out.println("t1:"+temp1);
			if(temp1 != 0)
				jsonResult = "密码不正确！";
			else {
				int temp2 = accountManager.lock(id);
				System.out.println("t2:"+temp2);
				if(temp2 == -1) {
					System.out.println("account error");
					return "error";
				} else if(temp2 == 1)
					jsonResult = "账户已经锁定！";
				if(temp2 == 0) {
					jsonResult = "修改成功！";
					this.addlogmsg("信息修改", "挂失"+accountId);
				}
			}
		}
		
		return SUCCESS;
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
		if(tspwd == null || tspwd.isEmpty() || accountNumber == null || accountNumber.isEmpty()) {
			jsonResult = "请输入数据！";
			return SUCCESS;
		}
		int temp = accountManager.AddAccount(userName,accountNumber,tspwd);
		System.out.println("t1:"+temp);
		if(temp == -1) {
			System.out.println("user error");
			return "error";
		} 
		if(temp == -2 || temp == -3)
			jsonResult = "银行卡不存在！";
		else if(temp == 1)
			jsonResult = "银行卡已添加！";
		else if(temp == 0) {
			jsonResult = "添加成功！";
			this.addlogmsg("信息修改", "添加银行卡");
		}
		return SUCCESS;
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

	public LogManager getLogManager() {
		return logManager;
	}

	public void setLogManager(LogManager logManager) {
		this.logManager = logManager;
	}
	
	
}
