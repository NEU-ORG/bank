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
		return "info";
	}

	public String apply() {// 申请信用卡
		return "apply";
	}

	public String application_progress() {
		return "application_progress";
	}

	public String report_loss() {// 卡片挂失
		return "report_loss";
	}

	public String active() {// 卡片激活
		return "active";
	}

	public String change_password() {// 密码修改
		return "change_password";
	}

	public String creditLimit() {//
		return "creditLimit";
	}

	public String checedBill() {// 已出账单查询
		return "checedBill";
	}

	public String unchecedBill() {// 未出账单查询
		return "unchecedBill";
	}

	public String score() {// 积分查询
		return "score";
	}
	public String changeSPassword(){
		
		return "change_password";
	}
	public String changeTPassword(){
		
		return "change_password";
	}

}
