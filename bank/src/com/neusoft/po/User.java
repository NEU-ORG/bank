package com.neusoft.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private Address address;
	private Bank bank;
	private String userName;
	private String password;
	private String phoneNumber;
	private String realName;
	private String idNumber;
	private Timestamp createDate;
	private String isSigned;
	private String email;
	private String postCode;
	private Set creditcardApplyeds = new HashSet(0);
	private Set payeeLists = new HashSet(0);
	private Set creditCards = new HashSet(0);
	private Set accounts = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Bank bank, String phoneNumber, String realName,
			String idNumber, String isSigned) {
		this.bank = bank;
		this.phoneNumber = phoneNumber;
		this.realName = realName;
		this.idNumber = idNumber;
		this.isSigned = isSigned;
	}

	/** full constructor */
	public User(Address address, Bank bank, String userName, String password,
			String phoneNumber, String realName, String idNumber,
			Timestamp createDate, String isSigned, String email,
			String postCode, Set creditcardApplyeds, Set payeeLists,
			Set creditCards, Set accounts) {
		this.address = address;
		this.bank = bank;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.realName = realName;
		this.idNumber = idNumber;
		this.createDate = createDate;
		this.isSigned = isSigned;
		this.email = email;
		this.postCode = postCode;
		this.creditcardApplyeds = creditcardApplyeds;
		this.payeeLists = payeeLists;
		this.creditCards = creditCards;
		this.accounts = accounts;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Bank getBank() {
		return this.bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getIsSigned() {
		return this.isSigned;
	}

	public void setIsSigned(String isSigned) {
		this.isSigned = isSigned;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Set getCreditcardApplyeds() {
		return this.creditcardApplyeds;
	}

	public void setCreditcardApplyeds(Set creditcardApplyeds) {
		this.creditcardApplyeds = creditcardApplyeds;
	}

	public Set getPayeeLists() {
		return this.payeeLists;
	}

	public void setPayeeLists(Set payeeLists) {
		this.payeeLists = payeeLists;
	}

	public Set getCreditCards() {
		return this.creditCards;
	}

	public void setCreditCards(Set creditCards) {
		this.creditCards = creditCards;
	}

	public Set getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Set accounts) {
		this.accounts = accounts;
	}

}