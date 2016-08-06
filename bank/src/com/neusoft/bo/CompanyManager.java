package com.neusoft.bo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.dao.AccountDAO;
import com.neusoft.dao.CompanyAccountDAO;
import com.neusoft.dao.CompanyOperatorDAO;
import com.neusoft.dao.DraftDAO;
import com.neusoft.dao.EndorsementDAO;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.Account;
import com.neusoft.po.CompanyAccount;
import com.neusoft.po.CompanyOperator;
import com.neusoft.po.CompanyTransactionDetail;
import com.neusoft.po.CreditCard;
import com.neusoft.po.Draft;
import com.neusoft.po.Endorsement;
import com.neusoft.po.User;
import com.opensymphony.xwork2.ActionContext;

public class CompanyManager {
	private CompanyOperatorDAO operatorDao;
	private CompanyAccountDAO accountDao;
	private DraftDAO draftDao;
	private EndorsementDAO endorsementDao;
	
	public void draftTiexian(Integer draftID,Timestamp time,String accountNumber){
		Draft draft = draftDao.findById(draftID);
		List accounts = accountDao.findByProperty("accountNumber", accountNumber);
		if(accounts.isEmpty())
			return;
		CompanyAccount account = (CompanyAccount) accounts.get(0);
		Endorsement endorsement = new Endorsement(null,
				null,account,
				draft, "贴现", time,null,
				null, null);
		draft.setStatus("贴现待签收");
		draftDao.attachDirty(draft);
		endorsementDao.save(endorsement);	
	}
	
	public void draftZhuanrang(Integer draftID,Timestamp time,String accountNumber,String exchangeble){
		Draft draft = draftDao.findById(draftID);
		List accounts = accountDao.findByProperty("accountNumber", accountNumber);
		if(accounts.isEmpty())
			return;
		CompanyAccount account = (CompanyAccount) accounts.get(0);
		Endorsement endorsement = new Endorsement(null,
				null,account,
				draft, "转让", time,exchangeble,
				null, null);
		draft.setStatus("背书转让待签收");
		draftDao.attachDirty(draft);
		endorsementDao.save(endorsement);		
	}
	
	public Set getDraftByOwner(String operatorName){
		List operatorList = operatorDao.findByProperty("managerName", operatorName);
		if(operatorList.isEmpty())
			return null;
		CompanyOperator operator = (CompanyOperator) operatorList.get(0);
		Set draftsSet = new HashSet();
		for(Object account: operator.getCompany().getCompanyAccounts()){
			draftsSet.addAll(((CompanyAccount)account).getDraftsForPayeeAccountId());
		}
		return draftsSet;
	}
	
	public void chupiao(String boodsmanName,Integer drawerAccountId,String type,Timestamp createdate,Timestamp duoDate,Double amount,String payeeAccountNumber,String acceptorAccountNumber,String exchangeble){
		List list2 = accountDao.findByProperty("accountNumber", payeeAccountNumber);
		List list3 = accountDao.findByProperty("accountNumber", acceptorAccountNumber);
		if(!list2.isEmpty()&&!list3.isEmpty()){
			CompanyAccount drawerAccount =accountDao.findById(drawerAccountId);
			CompanyAccount payeeAccount =(CompanyAccount) list2.get(0);
			CompanyAccount acceptorAccount =(CompanyAccount) list3.get(0);
			Draft newDraft = new Draft(drawerAccount,
					payeeAccount,
					acceptorAccount,type,
					createdate, duoDate, "出票已登记",
					null,boodsmanName, amount,
					exchangeble, null);
			draftDao.save(newDraft);
		}
	}
	
	//0：成功；-1：operator不存在；-2：银行卡不存在
	//-3：非本人的卡；1：已删除
	public int deleteAccount(String operatorName, Integer accountID){
		List operatorsList = operatorDao.findByProperty("managerName",
				operatorName);	
		if(operatorsList.isEmpty())
			return -1;
		CompanyAccount account = accountDao.findById(accountID);
		if(account==null)
			return -2;
		CompanyOperator operator = (CompanyOperator) operatorsList.get(0);
		if(!operator.getCompany().getId().equals(account.getCompany().getId()))
			return -3;
		if(account.getIsSigned().equals("none"))
			return 1;
	
		account.setIsSigned("none");
		accountDao.attachDirty(account);
		return 0;
	}
	
	//0：成功；-1：operator不存在；-2：银行卡不存在
	//-3：非本人的卡；1：已添加
	public int addAccount(String operatorName, String accountNumber) {
		List operatorsList = operatorDao.findByProperty("managerName",
				operatorName);
		List accounts = accountDao.findByProperty("accountNumber", accountNumber);
		if(operatorsList.isEmpty())
			return -1;
		if(accounts.isEmpty())
			return -2;
		CompanyOperator operator = (CompanyOperator) operatorsList.get(0);
		CompanyAccount account = (CompanyAccount) accounts.get(0);
		if(!operator.getCompany().getId().equals(account.getCompany().getId()))
			return -3;
		if(!account.getIsSigned().equals("none"))
			return 1;
	
		account.setIsSigned("unsigned");
		accountDao.attachDirty(account);
		return 0;
	}

	public void transfer(Integer accountID, String targetAccountNumber,
			Double amount) {
		List operatorsList = operatorDao.findByProperty("managerName",
				ActionContext.getContext().getSession().get("loginInfo"));
		CompanyOperator operator = (CompanyOperator) operatorsList.get(0);
		CompanyAccount account = accountDao.findById(accountID);
		List tempsList = accountDao.findByProperty("accountNumber",
				targetAccountNumber);
		if (tempsList.isEmpty() || account == null) {
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("errorMessage", "账号不存在！！！！");
			return;
		}
			CompanyAccount targetAccount = (CompanyAccount) tempsList.get(0);
			if (account.getStatus().equals("normal")
					&& targetAccount.getStatus().equals("normal")) {
				Double temp = account.getBalance();
				if (temp < amount) {
					Map request = (Map) ActionContext.getContext().get("request");
					request.put("errorMessage", "余额不足！！！！");
					return;
				}
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

	public void internalTransfer(Integer accountID, Integer targetAccountID,
			Double amount) {// can not be same ID
		List operatorsList = operatorDao.findByProperty("managerName",
				ActionContext.getContext().getSession().get("loginInfo"));
		CompanyOperator operator=null;
		if(operatorsList.isEmpty()){
			
			return;
		}
		operator = (CompanyOperator) operatorsList.get(0);
		CompanyAccount account = accountDao.findById(accountID);
		CompanyAccount targetAccount = accountDao.findById(targetAccountID);
		if (account == null || targetAccount == null
				|| !account.getStatus().equals("normal")
				|| !targetAccount.getStatus().equals("normal")) {
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("errorMessage","账号已锁定！！！");
			return;
			
		}
			Double temp = account.getBalance();
			if (amount!=null&&temp < amount) {
				Map request = (Map) ActionContext.getContext().get("request");
				request.put("errorMessage","余额不足！！！");
				return;
			}
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
	
			// balance is not enough.
	}

	public void reportLoss(Integer accountID) {
		CompanyAccount account = accountDao.findById(accountID);
		if (account != null) {
			account.setStatus("lock");
			accountDao.attachDirty(account);
		}
	}
	
	public Set getTransferDetail(Integer accountID, Date begin, Date end) {
		if(begin==null||end==null){
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("errorMessage", "请选择时间！！！！");
			return null;
		}

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
		if(begin==null||end==null){
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("errorMessage", "请选择时间！！！！");
			return null;
		}

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
	public boolean checkOutTPassword(String accountNumber, String password) {
		List accounts = accountDao.findByProperty("accountNumber", accountNumber);
		if(accounts.isEmpty())
			return false;
		CompanyAccount account = (CompanyAccount) accounts.get(0);
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

	public DraftDAO getDraftDao() {
		return draftDao;
	}

	public void setDraftDao(DraftDAO draftDao) {
		this.draftDao = draftDao;
	}

	public EndorsementDAO getEndorsementDao() {
		return endorsementDao;
	}

	public void setEndorsementDao(EndorsementDAO endorsementDao) {
		this.endorsementDao = endorsementDao;
	}

}
