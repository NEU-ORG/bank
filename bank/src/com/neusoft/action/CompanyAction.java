package com.neusoft.action;

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
	private int targetAccountID;
	private Date beginTime;
	private Date endTime;
	private String flag;
	private Double amount;
	private String targetAccountNumber;
	
	public String transfer(){
		Set companyAccounts = companyManager.getAccountInfo((String) ActionContext
				.getContext().getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("companyAccounts", companyAccounts);
		if(flag!=null){
			companyManager.transfer(accountID, targetAccountNumber, amount);
		}
		return "transfer";
	}
	
	public String internalTransfer(){
		Set companyAccounts = companyManager.getAccountInfo((String) ActionContext
				.getContext().getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("companyAccounts", companyAccounts);
		if(flag!=null){
			companyManager.internalTransfer(accountID, targetAccountID, amount);
		}
		return "internalTransfer";
	}
	
	public String reportLoss() {// 卡片挂失
		Set companyAccounts = companyManager.getAccountInfo((String) ActionContext
				.getContext().getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("companyAccounts", companyAccounts);
		if(flag!=null){
			companyManager.reportLoss(accountID);
		}
		return "reportLoss";
	}
	
	public String changeTPassword(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		Set companyAccounts = companyManager.getAccountInfo((String) ActionContext
				.getContext().getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("companyAccounts", companyAccounts);
		
		if(companyManager.checkOutTPassword(accountID, password)){
			if(session.get("passwordError")!=null)
			{
				session.remove("passwordError");
			}
			companyManager.changeTPassword(accountID, newPassword);
		}else{
			session.put("passwordError","密码不正确！！");
		}
		return "changeTPassword";
	}
	
	public String transferDetail(){//get account,set date.
		Set companyAccounts = companyManager.getAccountInfo((String) ActionContext
				.getContext().getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("companyAccounts", companyAccounts);
		
		if(flag!=null){
			Set transactionDetails = companyManager.getTransferDetail(accountID,beginTime,endTime);
			request.put("transactionDetails", transactionDetails);
		}
		return "transferDetail";
	}
	
	public String transactionDetail(){//get account,set date.
		Set companyAccounts = companyManager.getAccountInfo((String) ActionContext
				.getContext().getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("companyAccounts", companyAccounts);
		
		if(flag!=null){
			Set transactionDetails = companyManager.getTransactionDetail(accountID,beginTime,endTime);
			request.put("transactionDetails", transactionDetails);
		}
		return "transactionDetail";
	}
	
	public String account_info() {
		Set companyAccounts = companyManager.getAccountInfo((String) ActionContext
				.getContext().getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("companyAccounts", companyAccounts);
		return "account_info";
	}
	
	public String signIn(){
		String result;
		Map<String,Object> session = ActionContext.getContext().getSession();
		if(companyManager.checkOutLogin(operatorName, password)){
			if(!(session.get("loginError")==null))
			{
				session.remove("loginError");
			}
				session.put("loginInfo",operatorName);
				result = "loginSuccess";
		}else{
			session.put("loginError","用户名或密码不正确！！");
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
}
