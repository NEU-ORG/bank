package com.neusoft.bo;

import java.util.List;

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

public class UserManager {
	UserDAO userDao;
	AccountDAO accountDao;
	AddressDAO addressDao;
	
	public User getUserInfo(String userName){
		List users = userDao.findByProperty("userName", userName);
		if(!users.isEmpty()){
			return (User) users.get(0);
		}
		return null;
	}
	public User changeUserInfo(String userName,String email,String address,String postCode){
		List users = userDao.findByProperty("userName", userName);
		if(!users.isEmpty()){
			User user = (User) users.get(0);
			if(address!=null){
				List addresses = addressDao.findByProperty("codeValue", address);
				if(!addresses.isEmpty()){
					user.setAddress((Address) addresses.get(0));
				}
			}
			if(email!=null){
				user.setEmail(email);
			}
			if(postCode!=null){
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
		if (!accounts.isEmpty()) {
			Account account = (Account) accounts.get(0);// 得到对应的ID

			if (account.getUser().getRealName().equals(realName)
					&& account.getUser().getIdNumber().equals(idNumber)) {
				account.getUser().setUserName(userName);
				account.getUser().setPassword(password);
				userDao.attachDirty(account.getUser());
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean checkOutLogin(String userName, String password) {
		List users = userDao.findByProperty("userName", userName);
		if (!users.isEmpty()) {
			User user = (User) users.get(0);
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
