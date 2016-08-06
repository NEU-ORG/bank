package com.neusoft.vo;

import java.util.Date;

public class CreditCardBill {
	 
	private String statement_date;
	private String due_date;
	private String currency;
	private double statement_balance;
	private double min_payment;
	private double amount_paid;
	private double amount_received;
	
	
	public CreditCardBill(String statement_date, String due_date, String currency,
			double statement_balance, double min_payment,
			double amount_paid,
			double amount_received) {
		super();
		this.statement_date = statement_date;
		this.due_date = due_date;
		this.currency = currency;
		this.statement_balance = statement_balance;
		this.min_payment = min_payment;
		this.amount_paid = amount_paid;
		this.amount_received = amount_received;
	}
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getStatement_balance() {
		return statement_balance;
	}
	public void setStatement_balance(double statement_balance) {
		this.statement_balance = statement_balance;
	}
	public double getMin_payment() {
		return min_payment;
	}
	public void setMin_payment(double min_payment) {
		this.min_payment = min_payment;
	}
	public double getAmount_paid() {
		return amount_paid;
	}
	public void setAmount_paid(double amount_paid) {
		this.amount_paid = amount_paid;
	}
	public double getAmount_received() {
		return amount_received;
	}
	public void setAmount_received(double amount_received) {
		this.amount_received = amount_received;
	}

	public String getStatement_date() {
		return statement_date;
	}

	public void setStatement_date(String statement_date) {
		this.statement_date = statement_date;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
}
