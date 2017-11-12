package com.crest.assignment.cafebilling.dto;

import com.crest.assignment.cafebilling.menu.ItemCode;

public class BillingItem {
	
	private ItemCode itemCode;
	
	private int quantity;
	
	private double amount;
	
	private double rebate;
	
	
	
	public double getRebate() {
		return rebate;
	}

	public void setRebate(double rebate) {
		this.rebate = rebate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public BillingItem(ItemCode itemCode, int quantity, double rebate, double amount){
	  this.itemCode = itemCode;
	  this.rebate = rebate;
	  this.quantity = quantity;
	  this.amount = amount;
	}
	
	public ItemCode getItemCode() {
		return itemCode;
	}

	public void setItemCode(ItemCode itemCode) {
		this.itemCode = itemCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return   "\n" + itemCode.getDescription() + "     " + "        " + quantity + "                 " + amount;
	}

	

}
