package com.neusoft.action;

import java.util.List;

import net.sf.json.JSONObject;

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
	
	public String transdetail_win() {
		return "transdetail_win";
	}
	
	public String cashsweep_win() {
		return "cashsweep_win";
	}
	
	public String cashsweep() {
		String aid = ServletActionContext.getRequest().getParameter("accountId");
		JSONObject json = JSONObject.fromObject(ServletActionContext.getRequest().getParameter("checklist"));
		String pwd = ServletActionContext.getRequest().getParameter("pwd");
		List l = json.getJSONArray("list");
		System.out.println((int)l.get(0)+1);
		System.out.println("pwd:"+pwd);
		boolean b = (aid == null || aid.isEmpty() || 
				 pwd == null || pwd.isEmpty() || l.size() == 0);
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
			for(int i=0;i<l.size();i++) {
				int t2 = groupManager.transferall((int)l.get(i), id);
				System.out.println("t2:"+t2);
			}
			jsonResult = "资金归集成功！";
		}
		return SUCCESS;
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
			else if(t2 == -4)
				jsonResult = "账户不能相同";
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
