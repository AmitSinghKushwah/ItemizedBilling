package com.crest.assignment.cafebilling.helper;

import java.util.HashMap;
import java.util.Map;

import com.crest.assignment.cafebilling.dto.BillingItem;
import com.crest.assignment.cafebilling.dto.Discount;
import com.crest.assignment.cafebilling.menu.ItemCode;

public class BillingItemHelperImpl implements BillingItemHelper{

    // configurable discount
	private  Map<ItemCode, Discount> productDiscounts = new HashMap<ItemCode, Discount>();
	
    public BillingItemHelperImpl(){
	
	}
    
    public BillingItemHelperImpl(Map<ItemCode, Discount> productDiscounts){
		this.productDiscounts = productDiscounts;
	}

    @Override
    public BillingItem getBillingItem(final ItemCode itemCode, final int quantity) {
		
    	double  rebate = 0;
		double amount = (quantity * itemCode.getPrice());
		
		
		final Discount discount = productDiscounts.get(itemCode);
		if(discount != null && quantity >= discount.getQuantity() ){
				
			  rebate = (amount * discount.getPercentDiscount()) / 100;	
			}
		
		return new BillingItem(itemCode, quantity, rebate, amount);
			
		}
		
	 
	public  Discount getProductDiscount(ItemCode itemCode) {
		return productDiscounts.get(itemCode);
	}


	public  void setProductDiscounts(Map<ItemCode, Discount> productDiscounts) {
		this.productDiscounts = productDiscounts;
	}
	
	public  void putProductDiscounts(ItemCode itemCode, Discount discount) {
		this.productDiscounts.put(itemCode, discount);
	}
	
	
}
