package com.neusoft.po;

/**
 * ConstantId entity. @author MyEclipse Persistence Tools
 */

public class ConstantId implements java.io.Serializable {

	// Fields

	private String text;
	private Double value;

	// Constructors

	/** default constructor */
	public ConstantId() {
	}

	/** full constructor */
	public ConstantId(String text, Double value) {
		this.text = text;
		this.value = value;
	}

	// Property accessors

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ConstantId))
			return false;
		ConstantId castOther = (ConstantId) other;

		return ((this.getText() == castOther.getText()) || (this.getText() != null
				&& castOther.getText() != null && this.getText().equals(
				castOther.getText())))
				&& ((this.getValue() == castOther.getValue()) || (this
						.getValue() != null && castOther.getValue() != null && this
						.getValue().equals(castOther.getValue())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getText() == null ? 0 : this.getText().hashCode());
		result = 37 * result
				+ (getValue() == null ? 0 : this.getValue().hashCode());
		return result;
	}

}