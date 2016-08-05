package com.neusoft.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Bank bank;
	private String name;
	private String accountNumber;
	private String withdrawalPassword;
	private String transactionPassword;
	private String currency;
	private Timestamp createDate;
	private String isSigned;
	private String status;
	private String type;
	private Double balance;
	private Double availableBalance;
	private Set payeeLists = new HashSet(0);
	private Set payments = new HashSet(0);
	private Set transactionDetailsForAccountId = new HashSet(0);
	private Set transactionDetailsForTargetAccount = new HashSet(0);

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** minimal constructor */
	public Account(User user, Bank bank, String accountNumber,
			String withdrawalPassword, String transactionPassword,
			String currency, String isSigned, String status, String type,
			Double balance, Double availableBalance) {
		this.user = user;
		this.bank = bank;
		this.accountNumber = accountNumber;
		this.withdrawalPassword = withdrawalPassword;
		this.transactionPassword = transactionPassword;
		this.currency = currency;
		this.isSigned = isSigned;
		this.status = status;
		this.type = type;
		this.balance = balance;
		this.availableBalance = availableBalance;
	}

	/** full constructor */
	public Account(User user, Bank bank, String name, String accountNumber,
			String withdrawalPassword, String transactionPassword,
			String currency, Timestamp createDate, String isSigned,
			String status, String type, Double balance,
			Double availableBalance, Set payeeLists, Set payments,
			Set transactionDetailsForAccountId,
			Set transactionDetailsForTargetAccount) {
		this.user = user;
		this.bank = bank;
		this.name = name;
		this.accountNumber = accountNumber;
		this.withdrawalPassword = withdrawalPassword;
		this.transactionPassword = transactionPassword;
		this.currency = currency;
		this.createDate = createDate;
		this.isSigned = isSigned;
		this.status = status;
		this.type = type;
		this.balance = balance;
		this.availableBalance = availableBalance;
		this.payeeLists = payeeLists;
		this.payments = payments;
		this.transactionDetailsForAccountId = transactionDetailsForAccountId;
		this.transactionDetailsForTargetAccount = transactionDetailsForTargetAccount;
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

	public Bank getBank() {
		return this.bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
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

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getIsSigned() {
		return this.isSigned;
	}

	public void setIsSigned(String isSigned) {
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

	public Set getPayeeLists() {
		return this.payeeLists;
	}

	public void setPayeeLists(Set payeeLists) {
		this.payeeLists = payeeLists;
	}

	public Set getPayments() {
		return this.payments;
	}

	public void setPayments(Set payments) {
		this.payments = payments;
	}

	public Set getTransactionDetailsForAccountId() {
		return this.transactionDetailsForAccountId;
	}

	public void setTransactionDetailsForAccountId(
			Set transactionDetailsForAccountId) {
		this.transactionDetailsForAccountId = transactionDetailsForAccountId;
	}

	public Set getTransactionDetailsForTargetAccount() {
		return this.transactionDetailsForTargetAccount;
	}

	public void setTransactionDetailsForTargetAccount(
			Set transactionDetailsForTargetAccount) {
		this.transactionDetailsForTargetAccount = transactionDetailsForTargetAccount;
	}

}