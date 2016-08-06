package com.neusoft.bo;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.action.UserAdminAction;
import com.neusoft.dao.AccountDAO;
import com.neusoft.dao.AdminDAO;
import com.neusoft.dao.ConstantDAO;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.Account;
import com.neusoft.po.Admin;
import com.neusoft.po.CompanyAccount;
import com.neusoft.po.Constant;
import com.neusoft.po.User;
import com.opensymphony.xwork2.ActionContext;

public class AdminManager {
	private AdminDAO adminDao;
	private String name;
	private String password;
	private ConstantDAO constantDao;
	private String type;
	//private double value;
	private String text;
	
	public void changeTPassword(String name, String password) {
		Admin account = (Admin)adminDao.findByProperty("name", name).get(0);
		account.setPassword(password);
		adminDao.attachDirty(account);
	}

	public boolean checkOutTPassword(String name, String password) {
		Admin account = (Admin)adminDao.findByProperty("name", name).get(0);
		if (account != null
				&& account.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	
	
	
	public List getBenefitList()
	{
		return constantDao.findAll();
	}
	
	public boolean checkOutLogin(String name, String password) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		/*UserDAO userDao = (UserDAO) ctx.getBean("UserDAO");
		AccountDAO accountDao = (AccountDAO) ctx.getBean("AccountDAO");
		System.out.println("222" + userName);
		System.out.println("111" + password);*/
/*		System.out.println("1234"+name);
		System.out.println("1234"+password);*/
		if (!adminDao.findByProperty("name", name).isEmpty()) {
			Admin admin = (Admin) adminDao.findByProperty("name", name)
					.get(0);
			
/*			System.out.println("333" + admin.getName());
			System.out.println("444" + admin.getPassword());*/
			if (admin.getPassword().equals(password)) {
				return true;
			} else
				return false;
		} else
			return false;
	}
/*	public String currentBenefitSet(double value, double text)
	{
		Constant constant = (Constant)constantDao.findByProperty("text", "活期").get(0);
		constant.setValue(value);
		constantDao.attachDirty(constant);
		return "success";
	}*/
	public String scheduledBenefitSet(int benefitID, double value, String text)
	{
		Constant constant = (Constant)constantDao.findByProperty("id", benefitID).get(0);
		constant.setValue(value);
		constantDao.attachDirty(constant);
		return "success";
	}
/*	public String otherBenefitSet(double value, double text, String type)
	{
		Constant constant = (Constant)constantDao.findByProperty("type", type).get(0);
		if(constant.getType().contentEquals(type))
		{
			constant.setValue(value);
			constantDao.attachDirty(constant);
		}
		return "success";
	}*/
/*	public boolean checkOutRegister(String realName, String idNumber,
			String cardNumber, String userName, String password) {
		
		System.out.println("rn"+realName);
		System.out.println("enen"+cardNumber);
		 
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserDAO userDao = (UserDAO) ctx.getBean("UserDAO");
		AccountDAO accountDao = (AccountDAO) ctx.getBean("AccountDAO");
		AdminDAO adminDao = (AdminDAO)ctx.getBean("AdminDAO");
		if (!adminDao.findByProperty("accountNumber", cardNumber).isEmpty()) {
			Account account = (Account) adminDao.findByProperty(
					"accountNumber", cardNumber).get(0);// 得到对应的ID

			System.out.println("123" + account.getAccountNumber());
			System.out.println("here" + account.getUser().getRealName());
			System.out.println("66666" + realName);

			if (account.getUser().getRealName().equals(realName))
				if (account.getUser().getIdNumber().equals(idNumber)) {

					User user = (User) userDao.findByProperty("idNumber",
							idNumber).get(0);
					user.setUserName(userName);
					user.setPassword(password);
					userDao.attachDirty(user);
					return true;
				} else {
					System.out.println("1");
					return false;
				}
			else {
				System.out.println("2");
				return false;
			}
		} else {
			System.out.println("3");
			return false;
		}
	}*/
	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	protected void initDao() {
		// do nothing
	}
	
	
	
/*	public double getValue() {
		return value;
	}



	public void setValue(double value) {
		this.value = value;
	}*/



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



	public ConstantDAO getConstantDao() {
		return constantDao;
	}



	public void setConstantDao(ConstantDAO constantDao) {
		this.constantDao = constantDao;
	}



	public AdminDAO getAdminDao() {
		return adminDao;
	}



	public void setAdminDao(AdminDAO adminDao) {
		this.adminDao = adminDao;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
}
