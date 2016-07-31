package com.neusoft.po;

import java.util.HashSet;
import java.util.Set;

/**
 * Bank entity. @author MyEclipse Persistence Tools
 */

public class Bank implements java.io.Serializable {

	// Fields

	private Integer id;
	private Address address;
	private String name;
	private String type;
	private Set companyaccounts = new HashSet(0);
	private Set accounts = new HashSet(0);
	private Set creditCards = new HashSet(0);
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Bank() {
	}

	/** minimal constructor */
	public Bank(Address address, String name, String type) {
		this.address = address;
		this.name = name;
		this.type = type;
	}

	/** full constructor */
	public Bank(Address address, String name, String type, Set companyaccounts,
			Set accounts, Set creditCards, Set users) {
		this.address = address;
		this.name = name;
		this.type = type;
		this.companyaccounts = companyaccounts;
		this.accounts = accounts;
		this.creditCards = creditCards;
		this.users = users;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set getCompanyaccounts() {
		return this.companyaccounts;
	}

	public void setCompanyaccounts(Set companyaccounts) {
		this.companyaccounts = companyaccounts;
	}

	public Set getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Set accounts) {
		this.accounts = accounts;
	}

	public Set getCreditCards() {
		return this.creditCards;
	}

	public void setCreditCards(Set creditCards) {
		this.creditCards = creditCards;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}