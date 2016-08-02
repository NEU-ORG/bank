package com.neusoft.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * CompanyAccount entity. @author MyEclipse Persistence Tools
 */

public class CompanyAccount implements java.io.Serializable {

	// Fields

	private Integer id;
	private Company company;
	private Bank bank;
	private String name;
	private String accountNumber;
	private String transactionPassword;
	private String currency;
	private Timestamp createDate;
	private String isSigned;
	private String status;
	private String type;
	private Double balance;
	private Double availableBalance;
	private Set companyTransactionDetailsForAccountId = new HashSet(0);
	private Set companyTransactionDetailsForTargetAccount = new HashSet(0);

	// Constructors

	/** default constructor */
	public CompanyAccount() {
	}

	/** minimal constructor */
	public CompanyAccount(Company company, Bank bank, String accountNumber,
			String transactionPassword, String currency, Timestamp createDate,
			String isSigned, String status, String type, Double balance,
			Double availableBalance) {
		this.company = company;
		this.bank = bank;
		this.accountNumber = accountNumber;
		this.transactionPassword = transactionPassword;
		this.currency = currency;
		this.createDate = createDate;
		this.isSigned = isSigned;
		this.status = status;
		this.type = type;
		this.balance = balance;
		this.availableBalance = availableBalance;
	}

	/** full constructor */
	public CompanyAccount(Company company, Bank bank, String name,
			String accountNumber, String transactionPassword, String currency,
			Timestamp createDate, String isSigned, String status, String type,
			Double balance, Double availableBalance,
			Set companyTransactionDetailsForAccountId,
			Set companyTransactionDetailsForTargetAccount) {
		this.company = company;
		this.bank = bank;
		this.name = name;
		this.accountNumber = accountNumber;
		this.transactionPassword = transactionPassword;
		this.currency = currency;
		this.createDate = createDate;
		this.isSigned = isSigned;
		this.status = status;
		this.type = type;
		this.balance = balance;
		this.availableBalance = availableBalance;
		this.companyTransactionDetailsForAccountId = companyTransactionDetailsForAccountId;
		this.companyTransactionDetailsForTargetAccount = companyTransactionDetailsForTargetAccount;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
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

	public Set getCompanyTransactionDetailsForAccountId() {
		return this.companyTransactionDetailsForAccountId;
	}

	public void setCompanyTransactionDetailsForAccountId(
			Set companyTransactionDetailsForAccountId) {
		this.companyTransactionDetailsForAccountId = companyTransactionDetailsForAccountId;
	}

	public Set getCompanyTransactionDetailsForTargetAccount() {
		return this.companyTransactionDetailsForTargetAccount;
	}

	public void setCompanyTransactionDetailsForTargetAccount(
			Set companyTransactionDetailsForTargetAccount) {
		this.companyTransactionDetailsForTargetAccount = companyTransactionDetailsForTargetAccount;
	}

}