package com.neusoft.po;

import java.util.Date;

/**
 * BillDetail entity. @author MyEclipse Persistence Tools
 */

public class BillDetail implements java.io.Serializable {

	// Fields

	private Integer id;
	private CreditCard creditCard;
	private Date recordDate;
	private Date transactionTime;
	private String type;
	private String location;
	private String currency;
	private long amountPaid;
	private long amountReceived;
	private long balance;
	private String summary;

	// Constructors

	/** default constructor */
	public BillDetail() {
	}

	/** minimal constructor */
	public BillDetail(CreditCard creditCard, Date recordDate,
			Date transactionTime, String currency, long amountPaid,
			long amountReceived, long balance) {
		this.creditCard = creditCard;
		this.recordDate = recordDate;
		this.transactionTime = transactionTime;
		this.currency = currency;
		this.amountPaid = amountPaid;
		this.amountReceived = amountReceived;
		this.balance = balance;
	}

	/** full constructor */
	public BillDetail(CreditCard creditCard, Date recordDate,
			Date transactionTime, String type, String location,
			String currency, long amountPaid, long amountReceived,
			long balance, String summary) {
		this.creditCard = creditCard;
		this.recordDate = recordDate;
		this.transactionTime = transactionTime;
		this.type = type;
		this.location = location;
		this.currency = currency;
		this.amountPaid = amountPaid;
		this.amountReceived = amountReceived;
		this.balance = balance;
		this.summary = summary;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CreditCard getCreditCard() {
		return this.creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
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

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
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

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}