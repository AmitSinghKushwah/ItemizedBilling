package com.crest.assignment.cafebilling;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import com.crest.assignment.cafebilling.discount.strategy.BillingServiceImpl;
import com.crest.assignment.cafebilling.dto.Bill;
import com.crest.assignment.cafebilling.dto.Discount;
import com.crest.assignment.cafebilling.helper.BillingItemHelper;
import com.crest.assignment.cafebilling.helper.BillingItemHelperImpl;
import com.crest.assignment.cafebilling.menu.ItemCode;

// Main class just for demo, refer individual test classes for wider coverage.
public class Main {
	
	private static BillScanner billScanner;
	
	
	public static void main(String[] args) {
		configureIndividualProductDiscount();
		
		// Tea Masala - 3 , Coffee Latte - 2 , Cold Drink Sprite - 5
		// Coffee Latte has individual doscount also		
		billScanner.scan(ItemCode.TEM, 3);
		billScanner.scan(ItemCode.COL, 2);
		billScanner.scan(ItemCode.CDS, 5);
		Bill bill = billScanner.generateBill();
		System.out.println(bill.toString());
						
	}
	
	
	private static void configureIndividualProductDiscount()
	{
		
			// Let us configure some individual product discounts
			Map<ItemCode, Discount> productDiscounts = new HashMap<ItemCode, Discount>();
			// Give a discount of 25% on Coffee Latte for 2 or more quantity
			productDiscounts.put(ItemCode.COL, new Discount(2, 25));
			BillingItemHelper 	billingItemHelper = new BillingItemHelperImpl(productDiscounts);
			
			// Now create BillScanner
			billScanner = new BillScanner(new BillingServiceImpl(), billingItemHelper);
		
	}

}
