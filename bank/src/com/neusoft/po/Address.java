package com.neusoft.po;

import java.util.HashSet;
import java.util.Set;

/**
 * Address entity. @author MyEclipse Persistence Tools
 */

public class Address implements java.io.Serializable {

	// Fields

	private String codeValue;
	private String codeName;
	private String type;
	private String parentNode;
	private Set users = new HashSet(0);
	private Set companies = new HashSet(0);
	private Set banks = new HashSet(0);

	// Constructors

	/** default constructor */
	public Address() {
	}

	/** minimal constructor */
	public Address(String codeName, String type, String parentNode) {
		this.codeName = codeName;
		this.type = type;
		this.parentNode = parentNode;
	}

	/** full constructor */
	public Address(String codeName, String type, String parentNode, Set users,
			Set companies, Set banks) {
		this.codeName = codeName;
		this.type = type;
		this.parentNode = parentNode;
		this.users = users;
		this.companies = companies;
		this.banks = banks;
	}

	// Property accessors

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

	public String getParentNode() {
		return this.parentNode;
	}

	public void setParentNode(String parentNode) {
		this.parentNode = parentNode;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
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

}