package com.neusoft.action;

import org.apache.struts2.ServletActionContext;

import com.neusoft.bo.GroupManager;
import com.opensymphony.xwork2.ActionSupport;

public class GroupAction extends ActionSupport {
	private String jsonResult;
	private GroupManager groupManager;
	
	public String query_win() {
		return "query_win";
	}
	
	public String transfer_win() {
		return "transfer_win";
	}
	
	public String transfer() {
		String aid = ServletActionContext.getRequest().getParameter("accountId");
		String taid = ServletActionContext.getRequest().getParameter("targetAccountId");
		String pay = ServletActionContext.getRequest().getParameter("pay");
		String pwd = ServletActionContext.getRequest().getParameter("pwd");
		boolean b = (aid == null || aid.isEmpty() || 
					 taid == null || taid.isEmpty() || 
					 pay == null || pay.isEmpty() || 
					 pwd == null || pwd.isEmpty());
		if(b) {
			jsonResult = "请输入数据！";
			return SUCCESS;
		}
		Integer id = Integer.parseInt(aid);
		int t1 = groupManager.judgeTransPwd(id, pwd);
		System.out.println("t1:"+t1);
		if(t1 != 0)
			jsonResult = "密码不正确！";
		else {
			Integer tid = Integer.parseInt(taid);
			Double p = Double.parseDouble(pay);
			int t2 = groupManager.transfer(id, tid, p);
			System.out.println("t2:"+t2);
			if(t2 == -1) {
				System.out.println("account error");
				return "error";
			}
			if(t2 == 1)
				jsonResult = "账户余额不足！";
			else
				jsonResult = "转账成功！";
		}
		return SUCCESS;
	}

	public String getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	public GroupManager getGroupManager() {
		return groupManager;
	}

	public void setGroupManager(GroupManager groupManager) {
		this.groupManager = groupManager;
	}
}
