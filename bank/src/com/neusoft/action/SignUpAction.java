package com.neusoft.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import antlr.collections.List;

import com.neusoft.dao.UserDAO;
import com.neusoft.po.User;

public class SignUpAction {
	public String execute(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDAO userDao = (UserDAO) ctx.getBean("UserDAO");
		User user = (User) userDao.findByProperty("idNumber", idNumber).get(0);
		user.setUserName(userName);
		user.setPassword(password);
		userDao.attachDirty(user);
		return "success";
	}
	private String realName;
	private String idNumber;
	private String cardNumber;
	private String userName;
	private String password;
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
