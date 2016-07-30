package com.neusoft.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.dao.AccountDAO;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.Account;
import com.neusoft.po.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class JsonAction extends ActionSupport{
	
	private JSONObject jsonResult;
	public Integer userId;
	
	public String execute() {
		return "success";
	}
	
	public String getUserAccounts() {
		String userName = ServletActionContext.getRequest().getParameter("userName");
		//System.out.println("userName:"+userName);
		if(userName == null||userName.isEmpty()) {
			return "error";
		} else {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserDAO userDAO = (UserDAO) ctx.getBean("UserDAO");
			List<User> l = userDAO.findByProperty("userName", userName);
			if(l.size() != 1) {
				return "error";
			} else {
				User user = l.get(0);
				AccountDAO accountDAO = (AccountDAO) ctx.getBean("AccountDAO");
				List<Account> la = accountDAO.findByProperty("user", user);
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("status", true);
				map.put("result", la);
				JsonConfig jsonConfig = new JsonConfig();  //���������ļ�
				jsonConfig.setIgnoreDefaultExcludes(false);  //����Ĭ�Ϻ���
				jsonConfig.setExcludes(new String[]{"libs","user","accounts","transactionDetails"});
				jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
				jsonResult = JSONObject.fromObject(map,jsonConfig);
			}
		}
		return "success";
	}
	
	public String getUserList() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDAO userDAO = (UserDAO) ctx.getBean("UserDAO");
		List<User> userlist = userDAO.findAll();
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status", true);
		map.put("result", userlist);
		JsonConfig jsonConfig = new JsonConfig();  //���������ļ�
		jsonConfig.setIgnoreDefaultExcludes(false);  //����Ĭ�Ϻ���
		jsonConfig.setExcludes(new String[]{"libs","transactionDetails"});
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		jsonResult = JSONObject.fromObject(map,jsonConfig);
		
		System.out.println(jsonResult.size());
		
		return "success";
	}
	
	public String accountToJson() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountDAO accountDAO = (AccountDAO) ctx.getBean("AccountDAO");
		
		List<Account> accountlist = accountDAO.findAll();
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status", true);
		map.put("result", accountlist);
		JsonConfig jsonConfig = new JsonConfig();  //���������ļ�
		jsonConfig.setIgnoreDefaultExcludes(false);  //����Ĭ�Ϻ���
		jsonConfig.setExcludes(new String[]{"libs","accounts","transactionDetails"});
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		jsonResult = JSONObject.fromObject(map,jsonConfig);
		
		return "success";
	}

	public JSONObject getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(JSONObject jsonResult) {
		this.jsonResult = jsonResult;
	}
	
}
