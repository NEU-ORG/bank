package com.neusoft.po;

import java.util.HashSet;
import java.util.Set;

/**
 * CreditCard entity. @author MyEclipse Persistence Tools
 */

public class CreditCard implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Bank bank;
	private String cardNumber;
	private String name;
	private String type;
	private String currency;
	private Double creditLimit;
	private String queryPassword;
	private String transactionPassword;
	private Double balance;
	private Integer statementDate;
	private String status;
	private Integer dueDate;
	private Double score;
	private String isSigned;
	private Set billDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public CreditCard() {
	}

	/** minimal constructor */
	public CreditCard(User user, Bank bank, String cardNumber, String type,
			String currency, Double creditLimit, String queryPassword,
			String transactionPassword, Double balance, Integer statementDate,
			String status, Integer dueDate, Double score, String isSigned) {
		this.user = user;
		this.bank = bank;
		this.cardNumber = cardNumber;
		this.type = type;
		this.currency = currency;
		this.creditLimit = creditLimit;
		this.queryPassword = queryPassword;
		this.transactionPassword = transactionPassword;
		this.balance = balance;
		this.statementDate = statementDate;
		this.status = status;
		this.dueDate = dueDate;
		this.score = score;
		this.isSigned = isSigned;
	}

	/** full constructor */
	public CreditCard(User user, Bank bank, String cardNumber, String name,
			String type, String currency, Double creditLimit,
			String queryPassword, String transactionPassword, Double balance,
			Integer statementDate, String status, Integer dueDate,
			Double score, String isSigned, Set billDetails) {
		this.user = user;
		this.bank = bank;
		this.cardNumber = cardNumber;
		this.name = name;
		this.type = type;
		this.currency = currency;
		this.creditLimit = creditLimit;
		this.queryPassword = queryPassword;
		this.transactionPassword = transactionPassword;
		this.balance = balance;
		this.statementDate = statementDate;
		this.status = status;
		this.dueDate = dueDate;
		this.score = score;
		this.isSigned = isSigned;
		this.billDetails = billDetails;
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

	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getCreditLimit() {
		return this.creditLimit;
	}

	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getQueryPassword() {
		return this.queryPassword;
	}

	public void setQueryPassword(String queryPassword) {
		this.queryPassword = queryPassword;
	}

	public String getTransactionPassword() {
		return this.transactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getStatementDate() {
		return this.statementDate;
	}

	public void setStatementDate(Integer statementDate) {
		this.statementDate = statementDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Integer dueDate) {
		this.dueDate = dueDate;
	}

	public Double getScore() {
		return this.score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getIsSigned() {
		return this.isSigned;
	}

	public void setIsSigned(String isSigned) {
		this.isSigned = isSigned;
	}

	public Set getBillDetails() {
		return this.billDetails;
	}

	public void setBillDetails(Set billDetails) {
		this.billDetails = billDetails;
	}

}