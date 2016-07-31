package com.neusoft.po;

import java.sql.Timestamp;

/**
 * Applycreditcard entity. @author MyEclipse Persistence Tools
 */

public class Applycreditcard implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String creditCardNumber;
	private Timestamp applyDate;

	// Constructors

	/** default constructor */
	public Applycreditcard() {
	}

	/** minimal constructor */
	public Applycreditcard(User user, String creditCardNumber) {
		this.user = user;
		this.creditCardNumber = creditCardNumber;
	}

	/** full constructor */
	public Applycreditcard(User user, String creditCardNumber,
			Timestamp applyDate) {
		this.user = user;
		this.creditCardNumber = creditCardNumber;
		this.applyDate = applyDate;
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

	public String getCreditCardNumber() {
		return this.creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public Timestamp getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(Timestamp applyDate) {
		this.applyDate = applyDate;
	}

}