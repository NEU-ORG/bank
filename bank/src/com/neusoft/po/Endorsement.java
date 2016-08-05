package com.neusoft.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Endorsement entity. @author MyEclipse Persistence Tools
 */

public class Endorsement implements java.io.Serializable {

	// Fields

	private Integer id;
	private Endorsement endorsementByBackId;
	private Endorsement endorsementByFrontId;
	private CompanyAccount companyAccount;
	private Draft draft;
	private String type;
	private Timestamp time;
	private String exchangeble;
	private Set endorsementsForFrontId = new HashSet(0);
	private Set endorsementsForBackId = new HashSet(0);

	// Constructors

	/** default constructor */
	public Endorsement() {
	}

	/** minimal constructor */
	public Endorsement(CompanyAccount companyAccount, Draft draft, String type) {
		this.companyAccount = companyAccount;
		this.draft = draft;
		this.type = type;
	}

	/** full constructor */
	public Endorsement(Endorsement endorsementByBackId,
			Endorsement endorsementByFrontId, CompanyAccount companyAccount,
			Draft draft, String type, Timestamp time, String exchangeble,
			Set endorsementsForFrontId, Set endorsementsForBackId) {
		this.endorsementByBackId = endorsementByBackId;
		this.endorsementByFrontId = endorsementByFrontId;
		this.companyAccount = companyAccount;
		this.draft = draft;
		this.type = type;
		this.time = time;
		this.exchangeble = exchangeble;
		this.endorsementsForFrontId = endorsementsForFrontId;
		this.endorsementsForBackId = endorsementsForBackId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Endorsement getEndorsementByBackId() {
		return this.endorsementByBackId;
	}

	public void setEndorsementByBackId(Endorsement endorsementByBackId) {
		this.endorsementByBackId = endorsementByBackId;
	}

	public Endorsement getEndorsementByFrontId() {
		return this.endorsementByFrontId;
	}

	public void setEndorsementByFrontId(Endorsement endorsementByFrontId) {
		this.endorsementByFrontId = endorsementByFrontId;
	}

	public CompanyAccount getCompanyAccount() {
		return this.companyAccount;
	}

	public void setCompanyAccount(CompanyAccount companyAccount) {
		this.companyAccount = companyAccount;
	}

	public Draft getDraft() {
		return this.draft;
	}

	public void setDraft(Draft draft) {
		this.draft = draft;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getExchangeble() {
		return this.exchangeble;
	}

	public void setExchangeble(String exchangeble) {
		this.exchangeble = exchangeble;
	}

	public Set getEndorsementsForFrontId() {
		return this.endorsementsForFrontId;
	}

	public void setEndorsementsForFrontId(Set endorsementsForFrontId) {
		this.endorsementsForFrontId = endorsementsForFrontId;
	}

	public Set getEndorsementsForBackId() {
		return this.endorsementsForBackId;
	}

	public void setEndorsementsForBackId(Set endorsementsForBackId) {
		this.endorsementsForBackId = endorsementsForBackId;
	}

}