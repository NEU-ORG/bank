package com.neusoft.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Draft entity. @author MyEclipse Persistence Tools
 */

public class Draft implements java.io.Serializable {

	// Fields

	private Integer id;
	private CompanyAccount companyAccountByDrawerAccountId;
	private CompanyAccount companyAccountByPayeeAccountId;
	private CompanyAccount companyAccountByAcceptorAccountId;
	private String type;
	private Timestamp createDate;
	private Timestamp dueDate;
	private String status;
	private String number;
	private String boodsmanName;
	private Double amount;
	private String exchangeble;
	private Set endorsements = new HashSet(0);

	// Constructors

	/** default constructor */
	public Draft() {
	}

	/** minimal constructor */
	public Draft(CompanyAccount companyAccountByDrawerAccountId,
			CompanyAccount companyAccountByPayeeAccountId,
			CompanyAccount companyAccountByAcceptorAccountId, String type,
			Timestamp dueDate, String status, String boodsmanName,
			Double amount, String exchangeble) {
		this.companyAccountByDrawerAccountId = companyAccountByDrawerAccountId;
		this.companyAccountByPayeeAccountId = companyAccountByPayeeAccountId;
		this.companyAccountByAcceptorAccountId = companyAccountByAcceptorAccountId;
		this.type = type;
		this.dueDate = dueDate;
		this.status = status;
		this.boodsmanName = boodsmanName;
		this.amount = amount;
		this.exchangeble = exchangeble;
	}

	/** full constructor */
	public Draft(CompanyAccount companyAccountByDrawerAccountId,
			CompanyAccount companyAccountByPayeeAccountId,
			CompanyAccount companyAccountByAcceptorAccountId, String type,
			Timestamp createDate, Timestamp dueDate, String status,
			String number, String boodsmanName, Double amount,
			String exchangeble, Set endorsements) {
		this.companyAccountByDrawerAccountId = companyAccountByDrawerAccountId;
		this.companyAccountByPayeeAccountId = companyAccountByPayeeAccountId;
		this.companyAccountByAcceptorAccountId = companyAccountByAcceptorAccountId;
		this.type = type;
		this.createDate = createDate;
		this.dueDate = dueDate;
		this.status = status;
		this.number = number;
		this.boodsmanName = boodsmanName;
		this.amount = amount;
		this.exchangeble = exchangeble;
		this.endorsements = endorsements;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CompanyAccount getCompanyAccountByDrawerAccountId() {
		return this.companyAccountByDrawerAccountId;
	}

	public void setCompanyAccountByDrawerAccountId(
			CompanyAccount companyAccountByDrawerAccountId) {
		this.companyAccountByDrawerAccountId = companyAccountByDrawerAccountId;
	}

	public CompanyAccount getCompanyAccountByPayeeAccountId() {
		return this.companyAccountByPayeeAccountId;
	}

	public void setCompanyAccountByPayeeAccountId(
			CompanyAccount companyAccountByPayeeAccountId) {
		this.companyAccountByPayeeAccountId = companyAccountByPayeeAccountId;
	}

	public CompanyAccount getCompanyAccountByAcceptorAccountId() {
		return this.companyAccountByAcceptorAccountId;
	}

	public void setCompanyAccountByAcceptorAccountId(
			CompanyAccount companyAccountByAcceptorAccountId) {
		this.companyAccountByAcceptorAccountId = companyAccountByAcceptorAccountId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBoodsmanName() {
		return this.boodsmanName;
	}

	public void setBoodsmanName(String boodsmanName) {
		this.boodsmanName = boodsmanName;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getExchangeble() {
		return this.exchangeble;
	}

	public void setExchangeble(String exchangeble) {
		this.exchangeble = exchangeble;
	}

	public Set getEndorsements() {
		return this.endorsements;
	}

	public void setEndorsements(Set endorsements) {
		this.endorsements = endorsements;
	}

}