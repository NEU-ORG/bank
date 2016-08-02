package com.neusoft.po;

import java.util.HashSet;
import java.util.Set;

/**
 * Address entity. @author MyEclipse Persistence Tools
 */

public class Address implements java.io.Serializable {

	// Fields

	private Integer id;
	private Address address;
	private String codeValue;
	private String codeName;
	private String type;
	private Set addresses = new HashSet(0);
	private Set companies = new HashSet(0);
	private Set banks = new HashSet(0);
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Address() {
	}

	/** minimal constructor */
	public Address(String codeValue, String codeName, String type) {
		this.codeValue = codeValue;
		this.codeName = codeName;
		this.type = type;
	}

	/** full constructor */
	public Address(Address address, String codeValue, String codeName,
			String type, Set addresses, Set companies, Set banks, Set users) {
		this.address = address;
		this.codeValue = codeValue;
		this.codeName = codeName;
		this.type = type;
		this.addresses = addresses;
		this.companies = companies;
		this.banks = banks;
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

	public String getCodeValue() {
		return this.codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	public String getCodeName() {
		return this.codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set addresses) {
		this.addresses = addresses;
	}

	public Set getCompanies() {
		return this.companies;
	}

	public void setCompanies(Set companies) {
		this.companies = companies;
	}

	public Set getBanks() {
		return this.banks;
	}

	public void setBanks(Set banks) {
		this.banks = banks;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}