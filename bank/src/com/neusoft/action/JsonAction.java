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
import com.neusoft.dao.AddressDAO;
import com.neusoft.dao.TransactionDetailDAO;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.Account;
import com.neusoft.po.Address;
import com.neusoft.po.TransactionDetail;
import com.neusoft.po.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class JsonAction extends ActionSupport{
	
	private JSONObject jsonResult;
	public Integer userId;
	
	public String execute() {
		return "success";
	}
	
	public String QueryAddress() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		AddressDAO addressDAO = (AddressDAO) ctx.getBean("AddressDAO");
		List<Address> l = addressDAO.findAll();
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status", true);
		map.put("result", l);
		JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
		jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
		jsonConfig.setExcludes(new String[]{"companies","banks","addresses","users"});
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		jsonResult = JSONObject.fromObject(map,jsonConfig);
		
		return "success";
	}
	
	public String getTransactionDetail() {
		String accountId = ServletActionContext.getRequest().getParameter("accountId");
		//System.out.println("accountId:"+accountId);
		if(accountId == null||accountId.isEmpty()) {
			return "error";
		} else {
			Integer id = Integer.parseInt(accountId);
			//System.out.println(id+1);
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			AccountDAO accountDAO = (AccountDAO) ctx.getBean("AccountDAO");
			Account a = accountDAO.findById(id);
			if(a.equals(null)) {
				System.out.println("null");
				return "error";
			}
			TransactionDetailDAO tdDAO = (TransactionDetailDAO) ctx.getBean("TransactionDetailDAO");
			List<TransactionDetail> l = tdDAO.findByProperty("accountByAccountId", a);
			Map<String,Object> map = new HashMap<String,Object>();
			JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
			if(l.size() == 0) {
				map.put("status", false);
				map.put("result", null);
			} else {
				map.put("status", true);
				map.put("result", l);
				jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
				jsonConfig.setExcludes(new String[]{"accountByAccountId"});
				jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			}
			jsonResult = JSONObject.fromObject(map,jsonConfig);
		}
		return "success";
	}
	
	public String getUserAccounts() {
		String userName = ServletActionContext.getRequest().getParameter("userName");
		System.out.println("userName:"+userName);
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
				JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
				if(la.size() == 0) {
					map.put("status", false);
					map.put("result", null);
				} else {
					map.put("status", true);
					map.put("result", la);
					jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
					jsonConfig.setExcludes(new String[]{"users","address","creditCards","accounts","applycreditcards","payeeLists","companyaccounts","user","accounts","transactionDetailsForAccountId","transactionDetailsForTargetAccount"});
					jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
				}
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
		JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
		jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
		jsonConfig.setExcludes(new String[]{"users","address","creditCards","accounts","applycreditcards","payeeLists","companyaccounts","transactionDetails"});
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
		JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
		jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
		jsonConfig.setExcludes(new String[]{"users","accounts","address","creditCards","accounts","applycreditcards","payeeLists","companyaccounts","transactionDetails"});
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
