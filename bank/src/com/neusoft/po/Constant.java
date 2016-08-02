package com.neusoft.po;

/**
 * Constant entity. @author MyEclipse Persistence Tools
 */

public class Constant implements java.io.Serializable {

	// Fields

	private Integer id;
	private String text;
	private Double value;
	private String type;

	// Constructors

	/** default constructor */
	public Constant() {
	}

	/** full constructor */
	public Constant(String text, Double value, String type) {
		this.text = text;
		this.value = value;
		this.type = type;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Double getValue() {
		return this.value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}