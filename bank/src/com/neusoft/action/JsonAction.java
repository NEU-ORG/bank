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
import com.neusoft.dao.CompanyAccountDAO;
import com.neusoft.dao.CompanyDAO;
import com.neusoft.dao.CompanyOperatorDAO;
import com.neusoft.dao.CompanyTransactionDetailDAO;
import com.neusoft.dao.ConstantDAO;
import com.neusoft.dao.PayeeListDAO;
import com.neusoft.dao.TransactionDetailDAO;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.Account;
import com.neusoft.po.Address;
import com.neusoft.po.Company;
import com.neusoft.po.CompanyAccount;
import com.neusoft.po.CompanyOperator;
import com.neusoft.po.CompanyTransactionDetail;
import com.neusoft.po.Constant;
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
	
	public String QueryPayeeList() {
		String userName = ServletActionContext.getRequest().getParameter("userName");
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
				PayeeListDAO payeeListDAO = (PayeeListDAO) ctx.getBean("PayeeListDAO");
				List<Account> pl = payeeListDAO.findByProperty("user", user);
				Map<String,Object> map = new HashMap<String,Object>();
				JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
				if(pl.size() == 0) {
					map.put("status", false);
					map.put("result", null);
				} else {
					map.put("status", true);
					map.put("result", pl);
					jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
					jsonConfig.setExcludes(new String[]{"users","address","creditCards","accounts",
														"applycreditcards","payeeLists","companyaccounts",
														"user","accounts","transactionDetailsForAccountId",
														"transactionDetailsForTargetAccount",
														"companyAccounts","companies","companyOperators"});
					jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
				}
				jsonResult = JSONObject.fromObject(map,jsonConfig);
			}
		}
		return SUCCESS;
	}
	
	public String QueryCompanyMsg() {
		String operatorName = ServletActionContext.getRequest().getParameter("operatorName");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		CompanyOperatorDAO operatorDAO = (CompanyOperatorDAO) ctx.getBean("CompanyOperatorDAO");
		List<CompanyOperator> ol = operatorDAO.findByProperty("managerName", operatorName);
		if(ol.size() != 1) {
			System.out.println("o null error");
			return "error";
		}
		Company company = ol.get(0).getCompany();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status", true);
		map.put("result", company);
		JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
		jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
		jsonConfig.setExcludes(new String[]{"user","accounts","banks","companies","users",
											"companyTransactionDetailsForAccountId",
											"companyTransactionDetailsForTargetAccount",
											"companyTransactionDetails","address","company",
											"creditCards","companyOperators"});
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		jsonResult = JSONObject.fromObject(map,jsonConfig);
		return SUCCESS;
	}
	
	public String QueryComTransDetails() {
		String companyAccountId = ServletActionContext.getRequest().getParameter("companyAccountId");
		String btime = ServletActionContext.getRequest().getParameter("btime");
		String etime = ServletActionContext.getRequest().getParameter("etime");
		Integer caid = Integer.parseInt(companyAccountId);
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		CompanyAccountDAO caDAO = (CompanyAccountDAO) ctx.getBean("CompanyAccountDAO");
		CompanyAccount ca = caDAO.findById(caid);
		if(ca.equals(null)) {
			System.out.println("null");
			return "error";
		}
		CompanyTransactionDetailDAO ctdDAO = (CompanyTransactionDetailDAO) ctx.getBean("CompanyTransactionDetailDAO");
		List<CompanyTransactionDetail> l = ctdDAO.findByProperty("companyAccountByAccountId", ca);
		Long bt,et,time;
		if(btime == null || btime.isEmpty())
			bt = 0L;
		else
			bt = Long.parseLong(btime);
		if(etime == null || etime.isEmpty())
			et = Long.MAX_VALUE;
		else
			et = Long.parseLong(etime);
		if(bt > et) {
			System.out.println("bt>et");
			return "error";
		}
		for(int i=0;i<l.size();i++) {
			time = l.get(i).getTransactionTime().getTime();
			if(bt>time || time>et)
				l.remove(i);
		}
		Map<String,Object> map = new HashMap<String,Object>();
		JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
		if(l.size() == 0) {
			map.put("status", false);
			map.put("result", null);
		} else {
			map.put("status", true);
			map.put("result", l);
			jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
			jsonConfig.setExcludes(new String[]{"user","accounts","banks","companies","users",
												"companyTransactionDetailsForAccountId",
												"companyTransactionDetailsForTargetAccount",
												"companyTransactionDetails","address","company",
												"creditCards","companyAccounts"});
			jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		}
		jsonResult = JSONObject.fromObject(map,jsonConfig);
		return SUCCESS;
	}
	
	public String QueryConstant() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ConstantDAO constantDAO = (ConstantDAO) ctx.getBean("ConstantDAO");
		List<Constant> l = constantDAO.findAll();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status", true);
		map.put("result", l);
		JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
		jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
		jsonConfig.setExcludes(new String[]{""});
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		jsonResult = JSONObject.fromObject(map,jsonConfig);
		
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
		jsonConfig.setExcludes(new String[]{"companies","banks","addresses","users",
											"companyAccounts","companies","companyOperators"});
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		jsonResult = JSONObject.fromObject(map,jsonConfig);
		
		return "success";
	}
	
	public String QueryTransactionDetail() {
		String accountId = ServletActionContext.getRequest().getParameter("accountId");
		String btime = ServletActionContext.getRequest().getParameter("btime");
		String etime = ServletActionContext.getRequest().getParameter("etime");
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
			Long bt,et,time;
			if(btime == null || btime.isEmpty())
				bt = 0L;
			else
				bt = Long.parseLong(btime);
			if(etime == null || etime.isEmpty())
				et = Long.MAX_VALUE;
			else
				et = Long.parseLong(etime);
			if(bt > et) {
				System.out.println("bt>et");
				return "error";
			}
			for(int i=0;i<l.size();i++) {
				time = l.get(i).getTransactionTime().getTime();
				if(bt>time || time>et)
					l.remove(i);
			}
			Map<String,Object> map = new HashMap<String,Object>();
			JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
			if(l.size() == 0) {
				map.put("status", false);
				map.put("result", null);
			} else {
				map.put("status", true);
				map.put("result", l);
				jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
				jsonConfig.setExcludes(new String[]{"bank","users","address",
													"creditCards","accounts","applycreditcards",
													"payeeLists","companyaccounts","user",
													"accounts","transactionDetailsForAccountId",
													"transactionDetailsForTargetAccount",
													"companyAccounts","companies","companyOperators"});
				
				jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			}
			jsonResult = JSONObject.fromObject(map,jsonConfig);
		}
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
				JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
				if(la.size() == 0) {
					map.put("status", false);
					map.put("result", null);
				} else {
					map.put("status", true);
					map.put("result", la);
					jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
					jsonConfig.setExcludes(new String[]{"users","address","creditCards","accounts",
														"applycreditcards","payeeLists","companyaccounts",
														"user","accounts","transactionDetailsForAccountId",
														"transactionDetailsForTargetAccount",
														"companyAccounts","companies","companyOperators"});
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
		jsonConfig.setExcludes(new String[]{"users","address","creditCards","accounts","applycreditcards","payeeLists","companyaccounts","transactionDetails","companyAccounts","companies","companyOperators"});
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
