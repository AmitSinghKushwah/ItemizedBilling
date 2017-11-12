package com.crest.assignment.cafebilling.discount.strategy;

import java.util.List;

import com.crest.assignment.cafebilling.dto.Bill;
import com.crest.assignment.cafebilling.dto.BillingItem;
import com.crest.assignment.cafebilling.helper.BillingDiscountHelper;
import com.crest.assignment.cafebilling.helper.BillingDiscountHelperImpl;

public class BillingServiceImpl implements BillingService {
	
	// This can be injected/configured also
	private BillingDiscountHelper billingDiscountHelper = new BillingDiscountHelperImpl();

	
	@Override
	public Bill generateBill(List<BillingItem> items) {
		
		final Bill bill = new Bill();
		double amount = 0;
		
		for (BillingItem billingItem : items) {
			bill.addItems(billingItem);
			amount = amount + (billingItem.getAmount() - billingItem.getRebate());
		}
		bill.setAmount(amount);
		bill.setFinalBillDiscount(billingDiscountHelper.applyDiscount(amount));
		
		return bill;
		
	}
	
	

	

	

}
