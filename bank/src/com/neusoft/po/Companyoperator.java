package com.neusoft.po;

import java.util.HashSet;
import java.util.Set;

/**
 * Companyoperator entity. @author MyEclipse Persistence Tools
 */

public class Companyoperator implements java.io.Serializable {

	// Fields

	private Integer id;
	private Company company;
	private String managerName;
	private String password;
	private String idNumber;
	private Set companytransactiondetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Companyoperator() {
	}

	/** minimal constructor */
	public Companyoperator(Company company, String managerName,
			String password, String idNumber) {
		this.company = company;
		this.managerName = managerName;
		this.password = password;
		this.idNumber = idNumber;
	}

	/** full constructor */
	public Companyoperator(Company company, String managerName,
			String password, String idNumber, Set companytransactiondetails) {
		this.company = company;
		this.managerName = managerName;
		this.password = password;
		this.idNumber = idNumber;
		this.companytransactiondetails = companytransactiondetails;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Set getCompanytransactiondetails() {
		return this.companytransactiondetails;
	}

	public void setCompanytransactiondetails(Set companytransactiondetails) {
		this.companytransactiondetails = companytransactiondetails;
	}

}