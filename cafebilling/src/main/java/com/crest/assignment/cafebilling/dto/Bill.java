package com.crest.assignment.cafebilling.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bill implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private List<BillingItem> items = new ArrayList<BillingItem>();
	
	private double amount;
	
	private double finalBillDiscount;
	
	
	public List<BillingItem> getItems() {
		return items;
	}

	public void setItems(List<BillingItem> items) {
		this.items = items;
	}

	public double getFinalBillDiscount() {
		return finalBillDiscount;
	}

	public void setFinalBillDiscount(double finalBillDiscount) {
		this.finalBillDiscount = finalBillDiscount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void addItems(BillingItem item) {
		this.items.add(item);
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "------------Bill-------------- \n"
				+ "ITEMS :           COUNT               AMOUNT \n" 
				+ items 
				+ "\n   DISCOUNT     =" + finalBillDiscount
				+ "\n , TOTAL PAYABLE=" + amount + "]";
	}
	
	

}
