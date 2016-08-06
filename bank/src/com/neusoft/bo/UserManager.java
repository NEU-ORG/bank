package com.neusoft.bo;

import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.dao.AccountDAO;
import com.neusoft.dao.AddressDAO;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.Account;
import com.neusoft.po.Address;
import com.neusoft.po.CreditCard;
import com.neusoft.po.User;
import com.opensymphony.xwork2.ActionContext;

public class UserManager {
	UserDAO userDao;
	AccountDAO accountDao;
	AddressDAO addressDao;

	public void changePassword(String userName, String newPassword) {
		List users = userDao.findByProperty("userName", userName);
		if (!users.isEmpty()) {
			User user = (User) users.get(0);
			user.setPassword(newPassword);
			userDao.attachDirty(user);
		}

	}

	public void changeUserName(String oldName, String userName) {
		List users = userDao.findByProperty("userName", oldName);
		if (!users.isEmpty()) {
			User user = (User) users.get(0);
			user.setUserName(userName);
			userDao.attachDirty(user);
		}
	}

	public User getUserInfo(String userName) {
		List users = userDao.findByProperty("userName", userName);
		if (!users.isEmpty()) {
			return (User) users.get(0);
		}
		return null;
	}

	public User changeUserInfo(String userName, String email, String address,
			String postCode) {
		List users = userDao.findByProperty("userName", userName);
		if (!users.isEmpty()) {
			User user = (User) users.get(0);
			if (address != null) {
				List addresses = addressDao.findByProperty("codeName", address);
				if (!addresses.isEmpty()) {
					user.setAddress((Address) addresses.get(0));
				}
			}
			if (email != null && !email.isEmpty()) {
				user.setEmail(email);
			}
			if (postCode != null && !postCode.isEmpty()) {
				user.setPostCode(postCode);
			}
			userDao.attachDirty(user);
			return user;
		}
		return null;
	}

	public boolean checkOutRegister(String realName, String idNumber,
			String cardNumber, String userName, String password) {

		List accounts = accountDao.findByProperty("accountNumber", cardNumber);

		if (accounts.isEmpty()) {
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("errorMessage", "未找到该账号！！！");
			return false;
		}
		Account account = (Account) accounts.get(0);// 得到对应的ID

		if (!(account.getUser().getRealName().equals(realName) && account
				.getUser().getIdNumber().equals(idNumber))) {
			return false;
		}
		account.getUser().setUserName(userName);
		account.getUser().setPassword(password);
		userDao.attachDirty(account.getUser());
		return true;
	}

	public boolean checkOutLogin(String userName, String password) {
		if (!userDao.findByProperty("userName", userName).isEmpty()) {
			User user = (User) userDao.findByProperty("userName", userName)
					.get(0);
			if (user.getPassword().equals(password)) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public AccountDAO getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDAO accountDao) {
		this.accountDao = accountDao;
	}

	public AddressDAO getAddressDao() {
		return addressDao;
	}

	public void setAddressDao(AddressDAO addressDao) {
		this.addressDao = addressDao;
	}

}
