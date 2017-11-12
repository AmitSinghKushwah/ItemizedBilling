package com.crest.assignment.cafebilling.dto;

import java.io.Serializable;

public class Discount implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private int quantity;
	
	private int percentDiscount;

	public Discount(int quantity, int percentDiscount) {
		super();
		this.quantity = quantity;
		this.percentDiscount = percentDiscount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPercentDiscount() {
		return percentDiscount;
	}

	public void setPercentDiscount(int percentDiscount) {
		this.percentDiscount = percentDiscount;
	}

}
