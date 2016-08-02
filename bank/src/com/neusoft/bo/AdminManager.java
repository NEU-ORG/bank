package com.neusoft.bo;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.action.UserAdmin;
import com.neusoft.dao.AccountDAO;
import com.neusoft.dao.AdminDAO;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.Account;
import com.neusoft.po.Admin;
import com.neusoft.po.User;
import com.opensymphony.xwork2.ActionContext;

public class AdminManager {
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
	
	
	
	public boolean checkOutLogin(String name, String password) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		AdminDAO adminDao = (AdminDAO)ctx.getBean("AdminDAO");
		/*UserDAO userDao = (UserDAO) ctx.getBean("UserDAO");
		AccountDAO accountDao = (AccountDAO) ctx.getBean("AccountDAO");
		System.out.println("222" + userName);
		System.out.println("111" + password);*/
		if (!adminDao.findByProperty("name", name).isEmpty()) {
			Admin admin = (Admin) adminDao.findByProperty("name", name)
					.get(0);
			
			/*System.out.println("333" + admin.getName());
			System.out.println("444" + admin.getPassword());*/
			if (admin.getPassword().equals(password)) {
				return true;
			} else
				return false;
		} else
			return false;
	}
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
}
