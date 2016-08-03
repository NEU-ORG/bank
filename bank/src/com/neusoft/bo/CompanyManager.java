package com.neusoft.bo;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.dao.AccountDAO;
import com.neusoft.dao.CompanyAccountDAO;
import com.neusoft.dao.CompanyOperatorDAO;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.CompanyAccount;
import com.neusoft.po.CompanyOperator;
import com.neusoft.po.CompanyTransactionDetail;
import com.neusoft.po.CreditCard;
import com.neusoft.po.User;

public class CompanyManager {
	private CompanyOperatorDAO operatorDao;
	private CompanyAccountDAO accountDao;
	
	public void reportLoss(Integer accountID){
		CompanyAccount account = accountDao.findById(accountID);
		if (account != null) {
			account.setStatus("lock");
			accountDao.attachDirty(account);
		}
	}
	
	public Set getTransactionDetail(Integer accountID,Date begin,Date end){
	
		CompanyAccount account = accountDao.findById(accountID);
		Set<CompanyTransactionDetail> out = account.getCompanyTransactionDetailsForAccountId();
		Set<CompanyTransactionDetail> details = new HashSet<CompanyTransactionDetail>();
		for(CompanyTransactionDetail detail : out){
			if(detail.getTransactionTime().after(begin)&&detail.getTransactionTime().before(end)){
				details.add(detail);
			}
		}
		return details;
	}
	
	public Set getAccountInfo(String operatorName) {
		List operators = operatorDao.findByProperty("managerName", operatorName);
		if(!operators.isEmpty()){
			CompanyOperator operator = (CompanyOperator) operators.get(0);
			return operator.getCompany().getCompanyAccounts();
		}
		return null;
	}

	public boolean checkOutLogin(String operatorName, String password) {
		List operators = operatorDao
				.findByProperty("managerName", operatorName);
		if (!operators.isEmpty()) {
			CompanyOperator operator = (CompanyOperator) operators.get(0);
			if (operator.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	public void changeTPassword(Integer accountID,String password){
		CompanyAccount account = accountDao.findById(accountID);
		account.setTransactionPassword(password);
		accountDao.attachDirty(account);
	}
	public boolean checkOutTPassword(Integer accountID,String password){
		CompanyAccount account = accountDao.findById(accountID);
		if(account!=null&&account.getTransactionPassword().equals(password)){
			return true;
		}
		return false;
	}

	public CompanyOperatorDAO getOperatorDao() {
		return operatorDao;
	}

	public void setOperatorDao(CompanyOperatorDAO operatorDao) {
		this.operatorDao = operatorDao;
	}

	public CompanyAccountDAO getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(CompanyAccountDAO accountDao) {
		this.accountDao = accountDao;
	}

	
}
