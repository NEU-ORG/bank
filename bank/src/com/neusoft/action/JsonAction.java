package com.neusoft.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.dao.AccountDAO;
import com.neusoft.po.Account;
import com.neusoft.po.User;
import com.opensymphony.xwork2.ActionSupport;

public class JsonAction extends ActionSupport{
	
	private JSONObject jsonResult;
	
	public String execute() {
		return "success";
	}
	
	public String accountToJson() {
		Map<String,Object> map = new HashMap<String,Object>();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountDAO accountDAO = (AccountDAO) ctx.getBean("AccountDAO");
		
		List<Account> accountlist = accountDAO.findAll();
		System.out.println(accountlist.size());
		map.put("data", accountlist);
		map.put("status", true);
		
		JsonConfig jsonConfig = new JsonConfig();  //���������ļ�
		jsonConfig.setIgnoreDefaultExcludes(false);  //����Ĭ�Ϻ���
		jsonConfig.setExcludes(new String[]{"libs","accounts","transactionDetails"});
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		jsonResult = JSONObject.fromObject(map,jsonConfig);
		
		System.out.println("jo:"+jsonResult);
		
		return "success";
	}

	public JSONObject getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(JSONObject jsonResult) {
		this.jsonResult = jsonResult;
	}
	
}
