package com.neusoft.action;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.dao.AccountDAO;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.Account;
import com.neusoft.po.User;

public class CreateAccountAction {
	public String execute(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDAO userDao = (UserDAO) ctx.getBean("UserDAO");
		AccountDAO accountDao = (AccountDAO) ctx.getBean("AccountDAO");
		User user = new User("unsigned","unsigned",phoneNumber,
				realName,idNumber, null, "unsigned");
		Account account = new Account(user,accountNumber,withdrawalPassword,
				"", currency, bankName,
				new Date(), false, "normal", "saving account",
				0, 0);
		user.getAccounts().add(account);
		userDao.save(user);
		accountDao.save(account);
		return "success";
	}
	
	private String realName;
	private String idNumber;
	private String phoneNumber;
	private String accountType;
	private String accountNumber;
	private String bankName;
	private String withdrawalPassword;
	private String currency;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getWithdrawalPassword() {
		return withdrawalPassword;
	}
	public void setWithdrawalPassword(String withdrawalPassword) {
		this.withdrawalPassword = withdrawalPassword;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
