package com.neusoft.po;

import java.util.HashSet;
import java.util.Set;

/**
 * Company entity. @author MyEclipse Persistence Tools
 */

public class Company implements java.io.Serializable {

	// Fields

	private Integer id;
	private Address address;
	private Bank bank;
	private Group group;
	private String companyName;
	private String phoneNumber;
	private Set companyAccounts = new HashSet(0);
	private Set companyOperators = new HashSet(0);

	// Constructors

	/** default constructor */
	public Company() {
	}

	/** minimal constructor */
	public Company(Address address, String companyName, String phoneNumber) {
		this.address = address;
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
	}

	/** full constructor */
	public Company(Address address, Bank bank, Group group, String companyName,
			String phoneNumber, Set companyAccounts, Set companyOperators) {
		this.address = address;
		this.bank = bank;
		this.group = group;
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.companyAccounts = companyAccounts;
		this.companyOperators = companyOperators;
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

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set getCompanyAccounts() {
		return this.companyAccounts;
	}

	public void setCompanyAccounts(Set companyAccounts) {
		this.companyAccounts = companyAccounts;
	}

	public Set getCompanyOperators() {
		return this.companyOperators;
	}

	public void setCompanyOperators(Set companyOperators) {
		this.companyOperators = companyOperators;
	}

}