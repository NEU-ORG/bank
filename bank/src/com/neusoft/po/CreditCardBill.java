package com.neusoft.po;

import java.util.Date;

/**
 * CreditCardBill entity. @author MyEclipse Persistence Tools
 */

public class CreditCardBill implements java.io.Serializable {

	// Fields

	private Integer id;
	private CreditCard creditCard;
	private Date statementDate;
	private double dueDate;
	private String currency;
	private long statementBalance;
	private long minPayment;
	private long lastStatementBalance;
	private long amountPayment;
	private long amountReceived;

	// Constructors

	/** default constructor */
	public CreditCardBill() {
	}

	/** full constructor */
	public CreditCardBill(CreditCard creditCard, Date statementDate,
			double dueDate, String currency, long statementBalance,
			long minPayment, long lastStatementBalance, long amountPayment,
			long amountReceived) {
		this.creditCard = creditCard;
		this.statementDate = statementDate;
		this.dueDate = dueDate;
		this.currency = currency;
		this.statementBalance = statementBalance;
		this.minPayment = minPayment;
		this.lastStatementBalance = lastStatementBalance;
		this.amountPayment = amountPayment;
		this.amountReceived = amountReceived;
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

	public Date getStatementDate() {
		return this.statementDate;
	}

	public void setStatementDate(Date statementDate) {
		this.statementDate = statementDate;
	}

	public double getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(double dueDate) {
		this.dueDate = dueDate;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public long getStatementBalance() {
		return this.statementBalance;
	}

	public void setStatementBalance(long statementBalance) {
		this.statementBalance = statementBalance;
	}

	public long getMinPayment() {
		return this.minPayment;
	}

	public void setMinPayment(long minPayment) {
		this.minPayment = minPayment;
	}

	public long getLastStatementBalance() {
		return this.lastStatementBalance;
	}

	public void setLastStatementBalance(long lastStatementBalance) {
		this.lastStatementBalance = lastStatementBalance;
	}

	public long getAmountPayment() {
		return this.amountPayment;
	}

	public void setAmountPayment(long amountPayment) {
		this.amountPayment = amountPayment;
	}

	public long getAmountReceived() {
		return this.amountReceived;
	}

	public void setAmountReceived(long amountReceived) {
		this.amountReceived = amountReceived;
	}

}