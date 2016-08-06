package com.neusoft.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import com.neusoft.bo.CompanyManager;
import com.neusoft.po.CreditCard;
import com.opensymphony.xwork2.ActionContext;

public class CompanyAction {
	private String operatorName;
	private String password;
	private String newPassword;
	private CompanyManager companyManager;
	private int accountID;
	private int draftID;
	private int targetAccountID;
	private String accountNumber;
	private Date beginTime;
	private Date endTime;
	private String flag;
	private Double amount;
	private String targetAccountNumber;
	private String draftType;
	private Timestamp createDate;
	private Timestamp dueDate;
	private String payeeAccount;
	private String acceptorAccount;
	private String exchangeble;
	private String boodsmanName;
	
	public String logout(){
		Map session = ActionContext.getContext().getSession();
		session.remove("loginInfo");
		return "login";
	}
	public String draftZhuisuo(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		Set drafts = companyManager.getDraftByOwner((String)session.get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("drafts", drafts);
		return "draftZhuisuo";
	}
	
	public String draftFukuan(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		Set drafts = companyManager.getDraftByOwner((String)session.get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("drafts", drafts);
		return "draftFukuan";
	}
	
	public String draftTiexian(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		Set drafts = companyManager.getDraftByOwner((String)session.get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("drafts", drafts);
		if(flag!=null){
			companyManager.draftTiexian(draftID, createDate, targetAccountNumber);
		}
		return "draftTiexian";
	}
	
	public String draftZhuanrang(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		Set drafts = companyManager.getDraftByOwner((String)session.get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("drafts", drafts);
		if(flag!=null){
			if(exchangeble==null){
				exchangeble="不可转让";
			}else{
				exchangeble="可以转让";
			}
			companyManager.draftZhuanrang(draftID,createDate,targetAccountNumber,exchangeble);
		}
		return "draftZhuanrang";
	}
	
	public String draftChupiao(){
		Set companyAccounts = companyManager
				.getAccountInfo((String) ActionContext.getContext()
						.getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("companyAccounts", companyAccounts);
		if(flag!=null){
			if(exchangeble==null){
				exchangeble="不可转让";
			}else{
				exchangeble="可以转让";
			}
			companyManager.chupiao(boodsmanName,accountID,draftType,createDate,dueDate,amount,payeeAccount,acceptorAccount, exchangeble);
		}
		return "draftChupiao";
	}

	public String addAccount() {
		if (flag != null) {
			if (companyManager.checkOutTPassword(accountNumber, password)) {
				companyManager.addAccount((String) ActionContext.getContext()
						.getSession().get("loginInfo"), accountNumber);
			}else{
				Map request = (Map) ActionContext.getContext().get("request");
				request.put("errorMessage", "密码错误！！");
			}
		}
		return "addAccount";
	}

	public String deleteAccount() {

		if (flag != null) {
			if (companyManager.checkOutTPassword(accountID, password)) {
				companyManager.deleteAccount((String) ActionContext
						.getContext().getSession().get("loginInfo"), accountID);
			}else{
				Map request = (Map) ActionContext.getContext().get("request");
				request.put("errorMessage", "密码错误！！");
			}
		}
		Set companyAccounts = companyManager
				.getAccountInfo((String) ActionContext.getContext()
						.getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("companyAccounts", companyAccounts);
		return "deleteAccount";
	}

	public String transfer() {
		Set companyAccounts = companyManager
				.getAccountInfo((String) ActionContext.getContext()
						.getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("companyAccounts", companyAccounts);
		if (flag != null) {
			if (companyManager.checkOutTPassword(accountID, password)){
				companyManager.transfer(accountID, targetAccountNumber, amount);
			}else{
				request.put("errorMessage", "密码错误！！");
			}
		}
		return "transfer";
	}

	public String internalTransfer() {
		Set companyAccounts = companyManager
				.getAccountInfo((String) ActionContext.getContext()
						.getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("companyAccounts", companyAccounts);
		if (flag != null) {
			if (companyManager.checkOutTPassword(accountID, password)){
				companyManager.internalTransfer(accountID, targetAccountID, amount);
			}else{
				request.put("errorMessage", "密码错误！！");
			}
		}
		return "internalTransfer";
	}

	public String reportLoss() {// 卡片挂失
		Set companyAccounts = companyManager
				.getAccountInfo((String) ActionContext.getContext()
						.getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("companyAccounts", companyAccounts);
		if (flag != null) {
			companyManager.reportLoss(accountID);
		}
		return "reportLoss";
	}

	public String changeTPassword() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Set companyAccounts = companyManager
				.getAccountInfo((String) ActionContext.getContext()
						.getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("companyAccounts", companyAccounts);
		if(flag!=null){
		if (companyManager.checkOutTPassword(accountID, password)) {
			companyManager.changeTPassword(accountID, newPassword);
		} else {
			request.put("passwordError", "密码不正确！！");
		}}
		return "changeTPassword";
	}

	public String transferDetail() {// get account,set date.
		Set companyAccounts = companyManager
				.getAccountInfo((String) ActionContext.getContext()
						.getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("companyAccounts", companyAccounts);

		if (flag != null) {
			Set transactionDetails = companyManager.getTransferDetail(
					accountID, beginTime, endTime);
			request.put("transactionDetails", transactionDetails);
		}
		return "transferDetail";
	}

	public String transactionDetail() {// get account,set date.
		Set companyAccounts = companyManager
				.getAccountInfo((String) ActionContext.getContext()
						.getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("companyAccounts", companyAccounts);

		if (flag != null) {
			Set transactionDetails = companyManager.getTransactionDetail(
					accountID, beginTime, endTime);
			request.put("transactionDetails", transactionDetails);
		}
		return "transactionDetail";
	}

	public String account_info() {
		Set companyAccounts = companyManager
				.getAccountInfo((String) ActionContext.getContext()
						.getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("companyAccounts", companyAccounts);
		return "account_info";
	}

	public String signIn() {
		String result;
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (companyManager.checkOutLogin(operatorName, password)) {
			if (!(session.get("loginError") == null)) {
				session.remove("loginError");
			}
			session.put("loginInfo", operatorName);
			result = "loginSuccess";
		} else {
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("loginError", "用户名或密码不正确！！");
			result = "sign_in";
		}
		return result;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CompanyManager getCompanyManager() {
		return companyManager;
	}

	public void setCompanyManager(CompanyManager companyManager) {
		this.companyManager = companyManager;
	}

	public Integer getAccountID() {
		return accountID;
	}

	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getTargetAccountID() {
		return targetAccountID;
	}

	public void setTargetAccountID(int targetAccountID) {
		this.targetAccountID = targetAccountID;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTargetAccountNumber() {
		return targetAccountNumber;
	}

	public void setTargetAccountNumber(String targetAccountNumber) {
		this.targetAccountNumber = targetAccountNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPayeeAccount() {
		return payeeAccount;
	}

	public void setPayeeAccount(String payeeAccount) {
		this.payeeAccount = payeeAccount;
	}

	public String getAcceptorAccount() {
		return acceptorAccount;
	}

	public void setAcceptorAccount(String acceptorAccount) {
		this.acceptorAccount = acceptorAccount;
	}



	public String getDraftType() {
		return draftType;
	}

	public void setDraftType(String draftType) {
		this.draftType = draftType;
	}

	public String getBoodsmanName() {
		return boodsmanName;
	}

	public void setBoodsmanName(String boodsmanName) {
		this.boodsmanName = boodsmanName;
	}

	

	public void setCreatedate(Timestamp createdate) {
		this.createDate = createdate;
	}

	public Timestamp getCreatedate() {
		return createDate;
	}


	public String getExchangeble() {
		return exchangeble;
	}

	public void setExchangeble(String exchangeble) {
		this.exchangeble = exchangeble;
	}

	public Timestamp getDueDate() {
		return dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public int getDraftID() {
		return draftID;
	}

	public void setDraftID(int draftID) {
		this.draftID = draftID;
	}
}
