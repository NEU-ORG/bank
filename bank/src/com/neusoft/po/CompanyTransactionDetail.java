package com.neusoft.po;

import java.sql.Timestamp;

/**
 * CompanyTransactionDetail entity. @author MyEclipse Persistence Tools
 */

public class CompanyTransactionDetail implements java.io.Serializable {

	// Fields

	private Integer id;
	private CompanyAccount companyAccountByTargetAccount;
	private CompanyOperator companyOperator;
	private CompanyAccount companyAccountByAccountId;
	private Timestamp transactionTime;
	private Double amountPaid;
	private Double amountReceived;
	private Double balance;
	private String currency;
	private String type;
	private String message;

	// Constructors

	/** default constructor */
	public CompanyTransactionDetail() {
	}

	/** minimal constructor */
	public CompanyTransactionDetail(CompanyAccount companyAccountByAccountId,
			Double amountPaid, Double amountReceived, Double balance,
			String currency) {
		this.companyAccountByAccountId = companyAccountByAccountId;
		this.amountPaid = amountPaid;
		this.amountReceived = amountReceived;
		this.balance = balance;
		this.currency = currency;
	}

	/** full constructor */
	public CompanyTransactionDetail(
			CompanyAccount companyAccountByTargetAccount,
			CompanyOperator companyOperator,
			CompanyAccount companyAccountByAccountId,
			Timestamp transactionTime, Double amountPaid,
			Double amountReceived, Double balance, String currency,
			String type, String message) {
		this.companyAccountByTargetAccount = companyAccountByTargetAccount;
		this.companyOperator = companyOperator;
		this.companyAccountByAccountId = companyAccountByAccountId;
		this.transactionTime = transactionTime;
		this.amountPaid = amountPaid;
		this.amountReceived = amountReceived;
		this.balance = balance;
		this.currency = currency;
		this.type = type;
		this.message = message;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CompanyAccount getCompanyAccountByTargetAccount() {
		return this.companyAccountByTargetAccount;
	}

	public void setCompanyAccountByTargetAccount(
			CompanyAccount companyAccountByTargetAccount) {
		this.companyAccountByTargetAccount = companyAccountByTargetAccount;
	}

	public CompanyOperator getCompanyOperator() {
		return this.companyOperator;
	}

	public void setCompanyOperator(CompanyOperator companyOperator) {
		this.companyOperator = companyOperator;
	}

	public CompanyAccount getCompanyAccountByAccountId() {
		return this.companyAccountByAccountId;
	}

	public void setCompanyAccountByAccountId(
			CompanyAccount companyAccountByAccountId) {
		this.companyAccountByAccountId = companyAccountByAccountId;
	}

	public Timestamp getTransactionTime() {
		return this.transactionTime;
	}

	public void setTransactionTime(Timestamp transactionTime) {
		this.transactionTime = transactionTime;
	}

	public Double getAmountPaid() {
		return this.amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Double getAmountReceived() {
		return this.amountReceived;
	}

	public void setAmountReceived(Double amountReceived) {
		this.amountReceived = amountReceived;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}