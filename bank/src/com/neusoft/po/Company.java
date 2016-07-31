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
	private String companyName;
	private String phoneNumber;
	private Set companyoperators = new HashSet(0);
	private Set companyaccounts = new HashSet(0);

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
	public Company(Address address, String companyName, String phoneNumber,
			Set companyoperators, Set companyaccounts) {
		this.address = address;
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.companyoperators = companyoperators;
		this.companyaccounts = companyaccounts;
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

	public Set getCompanyoperators() {
		return this.companyoperators;
	}

	public void setCompanyoperators(Set companyoperators) {
		this.companyoperators = companyoperators;
	}

	public Set getCompanyaccounts() {
		return this.companyaccounts;
	}

	public void setCompanyaccounts(Set companyaccounts) {
		this.companyaccounts = companyaccounts;
	}

}