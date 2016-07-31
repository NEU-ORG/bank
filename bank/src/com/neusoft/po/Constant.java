package com.neusoft.po;

/**
 * Constant entity. @author MyEclipse Persistence Tools
 */

public class Constant implements java.io.Serializable {

	// Fields

	private ConstantId id;

	// Constructors

	/** default constructor */
	public Constant() {
	}

	/** full constructor */
	public Constant(ConstantId id) {
		this.id = id;
	}

	// Property accessors

	public ConstantId getId() {
		return this.id;
	}

	public void setId(ConstantId id) {
		this.id = id;
	}

}