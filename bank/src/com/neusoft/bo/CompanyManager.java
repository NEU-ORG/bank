package com.neusoft.bo;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
import com.opensymphony.xwork2.ActionContext;

public class CompanyManager {
	private CompanyOperatorDAO operatorDao;
	private CompanyAccountDAO accountDao;

	public void transfer(Integer accountID, String targetAccountNumber,
			Double amount) {
		List operatorsList = operatorDao.findByProperty("managerName",
				ActionContext.getContext().getSession().get("loginInfo"));
		CompanyOperator operator = (CompanyOperator) operatorsList.get(0);
		CompanyAccount account = accountDao.findById(accountID);
		List tempsList = accountDao.findByProperty("accountNumber",
				targetAccountNumber);
		if (!tempsList.isEmpty() && account != null) {
			CompanyAccount targetAccount = (CompanyAccount) tempsList.get(0);
			if (account.getStatus().equals("normal")
					&& targetAccount.getStatus().equals("normal")) {
				Double temp = account.getBalance();
				if (temp >= amount) {
					account.setBalance(temp - amount);
					targetAccount.setBalance(targetAccount.getBalance()
							+ amount);
					account.setAvailableBalance(account.getBalance());
					targetAccount.setAvailableBalance(targetAccount
							.getBalance());
					Timestamp time = new Timestamp(System.currentTimeMillis());
					CompanyTransactionDetail detail = new CompanyTransactionDetail(
							targetAccount, operator, account, time, amount,
							0.00, account.getBalance(), account.getCurrency(),
							"转账", "企业内部转账");
					account.getCompanyTransactionDetailsForAccountId().add(
							detail);
					CompanyTransactionDetail detail2 = new CompanyTransactionDetail(
							account, null, targetAccount, time, 0.00, amount,
							targetAccount.getBalance(),
							targetAccount.getCurrency(), "转账", "");
					targetAccount.getCompanyTransactionDetailsForAccountId()
							.add(detail2);
					accountDao.attachDirty(account);
					accountDao.attachDirty(targetAccount);
				}
			}
		}
	}

	public void internalTransfer(Integer accountID, Integer targetAccountID,
			Double amount) {// can not be same ID
		List operatorsList = operatorDao.findByProperty("managerName",
				ActionContext.getContext().getSession().get("loginInfo"));
		CompanyOperator operator = (CompanyOperator) operatorsList.get(0);
		CompanyAccount account = accountDao.findById(accountID);
		CompanyAccount targetAccount = accountDao.findById(targetAccountID);
		if (account != null && targetAccount != null
				&& account.getStatus().equals("normal")
				&& targetAccount.getStatus().equals("normal")) {
			Double temp = account.getBalance();
			if (temp >= amount) {
				account.setBalance(temp - amount);
				targetAccount.setBalance(targetAccount.getBalance() + amount);
				account.setAvailableBalance(account.getBalance());
				targetAccount.setAvailableBalance(targetAccount.getBalance());
				Timestamp time = new Timestamp(System.currentTimeMillis());
				CompanyTransactionDetail detail = new CompanyTransactionDetail(
						targetAccount, operator, account, time, amount, 0.00,
						account.getBalance(), account.getCurrency(), "转账",
						"企业内部转账");
				account.getCompanyTransactionDetailsForAccountId().add(detail);
				CompanyTransactionDetail detail2 = new CompanyTransactionDetail(
						account, operator, targetAccount, time, 0.00, amount,
						targetAccount.getBalance(),
						targetAccount.getCurrency(), "转账", "企业内部转账");
				targetAccount.getCompanyTransactionDetailsForAccountId().add(
						detail2);
				accountDao.attachDirty(account);
				accountDao.attachDirty(targetAccount);
			}
			// balance is not enough.
		}
	}

	public void reportLoss(Integer accountID) {
		CompanyAccount account = accountDao.findById(accountID);
		if (account != null) {
			account.setStatus("lock");
			accountDao.attachDirty(account);
		}
	}
	
	public Set getTransferDetail(Integer accountID, Date begin, Date end) {

		CompanyAccount account = accountDao.findById(accountID);
		Set<CompanyTransactionDetail> out = account
				.getCompanyTransactionDetailsForAccountId();
		Set<CompanyTransactionDetail> details = new HashSet<CompanyTransactionDetail>();
		for (CompanyTransactionDetail detail : out) {
			if (detail.getTransactionTime().after(begin)
					&& detail.getTransactionTime().before(end)&&detail.getType().equals("转账")) {
				details.add(detail);
			}
		}
		return details;
	}

	public Set getTransactionDetail(Integer accountID, Date begin, Date end) {

		CompanyAccount account = accountDao.findById(accountID);
		Set<CompanyTransactionDetail> out = account
				.getCompanyTransactionDetailsForAccountId();
		Set<CompanyTransactionDetail> details = new HashSet<CompanyTransactionDetail>();
		for (CompanyTransactionDetail detail : out) {
			if (detail.getTransactionTime().after(begin)
					&& detail.getTransactionTime().before(end)) {
				details.add(detail);
			}
		}
		return details;
	}

	public Set getAccountInfo(String operatorName) {
		List operators = operatorDao
				.findByProperty("managerName", operatorName);
		if (!operators.isEmpty()) {
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

	public void changeTPassword(Integer accountID, String password) {
		CompanyAccount account = accountDao.findById(accountID);
		account.setTransactionPassword(password);
		accountDao.attachDirty(account);
	}

	public boolean checkOutTPassword(Integer accountID, String password) {
		CompanyAccount account = accountDao.findById(accountID);
		if (account != null
				&& account.getTransactionPassword().equals(password)) {
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
