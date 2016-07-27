package com.neusoft.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String name;
	private String accountNumber;
	private String withdrawalPassword;
	private String transactionPassword;
	private String currency;
	private String createBank;
	private Date createDate;
	private boolean isSigned;
	private String status;
	private String type;
	private Double balance;
	private Double availableBalance;
	private Set transactionDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** minimal constructor */
	public Account(User user, String accountNumber, String withdrawalPassword,
			String transactionPassword, String currency, String createBank,
			Date createDate, boolean isSigned, String status, String type,
			Double balance, Double availableBalance) {
		this.user = user;
		this.accountNumber = accountNumber;
		this.withdrawalPassword = withdrawalPassword;
		this.transactionPassword = transactionPassword;
		this.currency = currency;
		this.createBank = createBank;
		this.createDate = createDate;
		this.isSigned = isSigned;
		this.status = status;
		this.type = type;
		this.balance = balance;
		this.availableBalance = availableBalance;
	}

	/** full constructor */
	public Account(User user, String name, String accountNumber,
			String withdrawalPassword, String transactionPassword,
			String currency, String createBank, Date createDate,
			boolean isSigned, String status, String type, Double balance,
			Double availableBalance, Set transactionDetails) {
		this.user = user;
		this.name = name;
		this.accountNumber = accountNumber;
		this.withdrawalPassword = withdrawalPassword;
		this.transactionPassword = transactionPassword;
		this.currency = currency;
		this.createBank = createBank;
		this.createDate = createDate;
		this.isSigned = isSigned;
		this.status = status;
		this.type = type;
		this.balance = balance;
		this.availableBalance = availableBalance;
		this.transactionDetails = transactionDetails;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getWithdrawalPassword() {
		return this.withdrawalPassword;
	}

	public void setWithdrawalPassword(String withdrawalPassword) {
		this.withdrawalPassword = withdrawalPassword;
	}

	public String getTransactionPassword() {
		return this.transactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCreateBank() {
		return this.createBank;
	}

	public void setCreateBank(String createBank) {
		this.createBank = createBank;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean getIsSigned() {
		return this.isSigned;
	}

	public void setIsSigned(boolean isSigned) {
		this.isSigned = isSigned;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getAvailableBalance() {
		return this.availableBalance;
	}

	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public Set getTransactionDetails() {
		return this.transactionDetails;
	}

	public void setTransactionDetails(Set transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

}