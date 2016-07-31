package com.neusoft.po;

import java.sql.Timestamp;

/**
 * Companytransactiondetail entity. @author MyEclipse Persistence Tools
 */

public class Companytransactiondetail implements java.io.Serializable {

	// Fields

	private Integer id;
	private Companyaccount companyaccountByTargetAccount;
	private Companyaccount companyaccountByAccountId;
	private Companyoperator companyoperator;
	private Timestamp transactionTime;
	private Double amountPaid;
	private Double amountReceived;
	private Double balance;
	private String currency;
	private String type;
	private String message;

	// Constructors

	/** default constructor */
	public Companytransactiondetail() {
	}

	/** minimal constructor */
	public Companytransactiondetail(Companyaccount companyaccountByAccountId,
			Double amountPaid, Double amountReceived, Double balance,
			String currency) {
		this.companyaccountByAccountId = companyaccountByAccountId;
		this.amountPaid = amountPaid;
		this.amountReceived = amountReceived;
		this.balance = balance;
		this.currency = currency;
	}

	/** full constructor */
	public Companytransactiondetail(
			Companyaccount companyaccountByTargetAccount,
			Companyaccount companyaccountByAccountId,
			Companyoperator companyoperator, Timestamp transactionTime,
			Double amountPaid, Double amountReceived, Double balance,
			String currency, String type, String message) {
		this.companyaccountByTargetAccount = companyaccountByTargetAccount;
		this.companyaccountByAccountId = companyaccountByAccountId;
		this.companyoperator = companyoperator;
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

	public Companyaccount getCompanyaccountByTargetAccount() {
		return this.companyaccountByTargetAccount;
	}

	public void setCompanyaccountByTargetAccount(
			Companyaccount companyaccountByTargetAccount) {
		this.companyaccountByTargetAccount = companyaccountByTargetAccount;
	}

	public Companyaccount getCompanyaccountByAccountId() {
		return this.companyaccountByAccountId;
	}

	public void setCompanyaccountByAccountId(
			Companyaccount companyaccountByAccountId) {
		this.companyaccountByAccountId = companyaccountByAccountId;
	}

	public Companyoperator getCompanyoperator() {
		return this.companyoperator;
	}

	public void setCompanyoperator(Companyoperator companyoperator) {
		this.companyoperator = companyoperator;
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