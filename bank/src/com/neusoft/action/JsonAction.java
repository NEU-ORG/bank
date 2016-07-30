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

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.dao.AccountDAO;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.Account;
import com.neusoft.po.User;
import com.opensymphony.xwork2.ActionSupport;

public class JsonAction extends ActionSupport{
	
	private JSONObject jsonResult;
	public Integer userId;
	
	public String execute() {
		return "success";
	}
	
	public String getUserList() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDAO userDAO = (UserDAO) ctx.getBean("UserDAO");
		List<User> userlist = userDAO.findAll();
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("data", userlist);
		map.put("status", true);
		JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
		jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
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
		map.put("data", accountlist);
		map.put("status", true);
		JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
		jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
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
