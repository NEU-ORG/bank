package com.neusoft.po;

import java.util.Date;

/**
 * TransactionDetail entity. @author MyEclipse Persistence Tools
 */

public class TransactionDetail implements java.io.Serializable {

	// Fields

	private Integer id;
	private Account account;
	private Date recordDate;
	private Date transactionTime;
	private long amountPaid;
	private long amountReceived;
	private long balance;
	private Integer targetAccount;
	private String targetName;
	private String currency;
	private String type;
	private String location;

	// Constructors

	/** default constructor */
	public TransactionDetail() {
	}

	/** minimal constructor */
	public TransactionDetail(Account account, Date recordDate,
			Date transactionTime, long amountPaid, long amountReceived,
			long balance, String currency) {
		this.account = account;
		this.recordDate = recordDate;
		this.transactionTime = transactionTime;
		this.amountPaid = amountPaid;
		this.amountReceived = amountReceived;
		this.balance = balance;
		this.currency = currency;
	}

	/** full constructor */
	public TransactionDetail(Account account, Date recordDate,
			Date transactionTime, long amountPaid, long amountReceived,
			long balance, Integer targetAccount, String targetName,
			String currency, String type, String location) {
		this.account = account;
		this.recordDate = recordDate;
		this.transactionTime = transactionTime;
		this.amountPaid = amountPaid;
		this.amountReceived = amountReceived;
		this.balance = balance;
		this.targetAccount = targetAccount;
		this.targetName = targetName;
		this.currency = currency;
		this.type = type;
		this.location = location;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getRecordDate() {
		return this.recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public Date getTransactionTime() {
		return this.transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}

	public long getAmountPaid() {
		return this.amountPaid;
	}

	public void setAmountPaid(long amountPaid) {
		this.amountPaid = amountPaid;
	}

	public long getAmountReceived() {
		return this.amountReceived;
	}

	public void setAmountReceived(long amountReceived) {
		this.amountReceived = amountReceived;
	}

	public long getBalance() {
		return this.balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public Integer getTargetAccount() {
		return this.targetAccount;
	}

	public void setTargetAccount(Integer targetAccount) {
		this.targetAccount = targetAccount;
	}

	public String getTargetName() {
		return this.targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
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

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}