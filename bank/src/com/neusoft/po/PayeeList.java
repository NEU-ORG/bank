package com.neusoft.po;

/**
 * PayeeList entity. @author MyEclipse Persistence Tools
 */

public class PayeeList implements java.io.Serializable {

	// Fields

	private Integer id;
	private Account account;
	private User user;
	private String payeeName;

	// Constructors

	/** default constructor */
	public PayeeList() {
	}

	/** full constructor */
	public PayeeList(Account account, User user, String payeeName) {
		this.account = account;
		this.user = user;
		this.payeeName = payeeName;
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPayeeName() {
		return this.payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

}