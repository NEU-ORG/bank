package com.neusoft.po;

/**
 * PayeeList entity. @author MyEclipse Persistence Tools
 */

public class PayeeList implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer payeeIdNumber;
	private String payeeName;
	private String payeeAccount;

	// Constructors

	/** default constructor */
	public PayeeList() {
	}

	/** full constructor */
	public PayeeList(Integer payeeIdNumber, String payeeName,
			String payeeAccount) {
		this.payeeIdNumber = payeeIdNumber;
		this.payeeName = payeeName;
		this.payeeAccount = payeeAccount;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPayeeIdNumber() {
		return this.payeeIdNumber;
	}

	public void setPayeeIdNumber(Integer payeeIdNumber) {
		this.payeeIdNumber = payeeIdNumber;
	}

	public String getPayeeName() {
		return this.payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getPayeeAccount() {
		return this.payeeAccount;
	}

	public void setPayeeAccount(String payeeAccount) {
		this.payeeAccount = payeeAccount;
	}

}