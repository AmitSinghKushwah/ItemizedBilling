package com.crest.assignment.cafebilling.dto;

import java.io.Serializable;

public class Slab implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private double lowerBound;
	
	private double upperBound;
	
	private double discountPercent;

	public Slab(double lowerBound, double upperBound, double discountPercent) {
		super();
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.discountPercent = discountPercent;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public double getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(double lowerBound) {
		this.lowerBound = lowerBound;
	}

	public double getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(double upperBound) {
		this.upperBound = upperBound;
	}

}
