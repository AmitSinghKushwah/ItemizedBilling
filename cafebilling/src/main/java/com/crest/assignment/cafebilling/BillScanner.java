package com.crest.assignment.cafebilling;

import java.util.ArrayList;
import java.util.List;

import com.crest.assignment.cafebilling.discount.strategy.BillingService;
import com.crest.assignment.cafebilling.dto.Bill;
import com.crest.assignment.cafebilling.dto.BillingItem;
import com.crest.assignment.cafebilling.helper.BillingItemHelper;
import com.crest.assignment.cafebilling.menu.ItemCode;


public class BillScanner {
	
	private List<BillingItem> items = new ArrayList<BillingItem>();
	
	private final BillingService billingService;
	
	private final BillingItemHelper billingItemHelper;
	
	// Trying to make them configurable using constructor or injection frameowrk can be used
	public BillScanner(BillingService billingService, BillingItemHelper billingItemHelper){
		this.billingService = billingService;
		this.billingItemHelper = billingItemHelper;
	}
	
	
	public void scan(final ItemCode itemCode, final int quantity){
		
		// Like the most available billing systems, as user scan item, 
		// item entry should be visible on screen with product level discount applied.
		BillingItem  billingItem = billingItemHelper.getBillingItem(itemCode, quantity);
		items.add(billingItem);
	}
	
	
	public Bill generateBill()
	{	
		// Fail fast if no items scanned and user asks for bill generation
		if(items.size() == 0){
			throw new RuntimeException("Scan atleast one item...");
		}
		final Bill bill = billingService.generateBill(items);
		items.clear();
		return bill;
	}

}
