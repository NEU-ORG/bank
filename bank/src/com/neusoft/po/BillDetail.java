package com.neusoft.po;

import java.sql.Timestamp;

/**
 * BillDetail entity. @author MyEclipse Persistence Tools
 */

public class BillDetail implements java.io.Serializable {

	// Fields

	private Integer id;
	private CreditCard creditCard;
	private Timestamp transactionTime;
	private String type;
	private String message;
	private String currency;
	private Double amountPaid;
	private Double amountReceived;
	private Double balance;

	// Constructors

	/** default constructor */
	public BillDetail() {
	}

	/** minimal constructor */
	public BillDetail(CreditCard creditCard, String currency,
			Double amountPaid, Double amountReceived, Double balance) {
		this.creditCard = creditCard;
		this.currency = currency;
		this.amountPaid = amountPaid;
		this.amountReceived = amountReceived;
		this.balance = balance;
	}

	/** full constructor */
	public BillDetail(CreditCard creditCard, Timestamp transactionTime,
			String type, String message, String currency, Double amountPaid,
			Double amountReceived, Double balance) {
		this.creditCard = creditCard;
		this.transactionTime = transactionTime;
		this.type = type;
		this.message = message;
		this.currency = currency;
		this.amountPaid = amountPaid;
		this.amountReceived = amountReceived;
		this.balance = balance;
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

	public Timestamp getTransactionTime() {
		return this.transactionTime;
	}

	public void setTransactionTime(Timestamp transactionTime) {
		this.transactionTime = transactionTime;
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

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
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

}