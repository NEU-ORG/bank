package com.neusoft.po;

import java.util.HashSet;
import java.util.Set;

/**
 * Group entity. @author MyEclipse Persistence Tools
 */

public class Group implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set companies = new HashSet(0);

	// Constructors

	/** default constructor */
	public Group() {
	}

	/** minimal constructor */
	public Group(String name) {
		this.name = name;
	}

	/** full constructor */
	public Group(String name, Set companies) {
		this.name = name;
		this.companies = companies;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getCompanies() {
		return this.companies;
	}

	public void setCompanies(Set companies) {
		this.companies = companies;
	}

}