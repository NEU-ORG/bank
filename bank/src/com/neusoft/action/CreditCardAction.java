package com.neusoft.action;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.dao.UserDAO;
import com.neusoft.po.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CreditCardAction extends ActionSupport{

	public String info() {
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDAO userDao = (UserDAO) ctx.getBean("UserDAO");
		Map<String,Object> session = ActionContext.getContext().getSession();
		String userName = (String) session.get("loginInfo");
		User user = (User) userDao.findByProperty("userName", userName).get(0);
		session.put("creditCards", user.getCreditCards());
		return "info";
	}

	public String apply() {// 申请信用卡
		return "info";
	}

	public String application_progress() {
		return "info";
	}

	public String report_loss() {// 卡片挂失
		return "info";
	}

	public String active() {// 卡片激活
		return "info";
	}

	public String change_password() {// 密码修改
		return "info";
	}

	public String creditLimit() {//
		return "info";
	}

	public String checedBill() {// 已出账单查询
		return "info";
	}

	public String unchecedBill() {// 未出账单查询
		return "info";
	}

	public String score() {// 积分查询
		return "info";
	}
	

}
