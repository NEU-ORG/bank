package com.neusoft.bo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.dao.AccountDAO;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.Account;
import com.neusoft.po.CreditCard;
import com.neusoft.po.User;

public class UserManager {
	
/*	private String realName;//真实姓名
	private String idNumber;//身份证号
	private String cardNumber;//卡号
	private String userName;//登录名
	private String password;//登陆密码
*/	
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}
	public boolean checkOutRegister(String realName, String idNumber, String cardNumber,
		String userName, String password){
		System.out.println("rn"+realName);
		System.out.println("enen"+cardNumber);
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDAO userDao = (UserDAO) ctx.getBean("UserDAO");
		AccountDAO accountDao = (AccountDAO) ctx.getBean("AccountDAO");
		if(!accountDao.findByProperty("accountNumber",cardNumber).isEmpty())
		{
			Account account = (Account) accountDao.findByProperty("accountNumber",cardNumber).get(0);//得到对应的ID
			System.out.println("123"+account.getAccountNumber());
			System.out.println("here"+account.getUser().getRealName());
			if(account.getUser().getRealName().equals(realName))
				if(account.getUser().getIdNumber().equals(idNumber)){
					
					User user = (User) userDao.findByProperty("idNumber", idNumber).get(0);		
					user.setUserName(userName);
					user.setPassword(password);
					userDao.attachDirty(user);
					return true;
				}
				else {System.out.println("1");return false;}
			else {System.out.println("2");return false;}
		}else {System.out.println("3");return false;}
	}
	
	public boolean checkOutLogin(String userName, String password){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDAO userDao = (UserDAO) ctx.getBean("UserDAO");
		AccountDAO accountDao = (AccountDAO) ctx.getBean("AccountDAO");
		if(!accountDao.findByProperty("userName",userName).isEmpty()){
			CreditCard creditCard = (CreditCard) accountDao.findByProperty("userName",userName).get(0);
			if(password == creditCard.getUser().getPassword()){
				return true;
			}
			
		}
		return false;
	}
}
