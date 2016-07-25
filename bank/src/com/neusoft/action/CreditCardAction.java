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

	public String apply() {// �������ÿ�
		return "info";
	}

	public String application_progress() {
		return "info";
	}

	public String report_loss() {// ��Ƭ��ʧ
		return "info";
	}

	public String active() {// ��Ƭ����
		return "info";
	}

	public String change_password() {// �����޸�
		return "info";
	}

	public String creditLimit() {//
		return "info";
	}

	public String checedBill() {// �ѳ��˵���ѯ
		return "info";
	}

	public String unchecedBill() {// δ���˵���ѯ
		return "info";
	}

	public String score() {// ���ֲ�ѯ
		return "info";
	}
	

}
