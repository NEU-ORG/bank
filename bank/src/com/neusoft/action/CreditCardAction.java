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

	public String apply() {// �������ÿ�
		return "apply";
	}

	public String application_progress() {
		return "application_progress";
	}

	public String report_loss() {// ��Ƭ��ʧ
		return "report_loss";
	}

	public String active() {// ��Ƭ����
		return "active";
	}

	public String change_password() {// �����޸�
		return "change_password";
	}

	public String creditLimit() {//
		return "creditLimit";
	}

	public String checedBill() {// �ѳ��˵���ѯ
		return "checedBill";
	}

	public String unchecedBill() {// δ���˵���ѯ
		return "unchecedBill";
	}

	public String score() {// ���ֲ�ѯ
		return "score";
	}
	public String changeSPassword(){
		
		return "change_password";
	}
	public String changeTPassword(){
		
		return "change_password";
	}

}
