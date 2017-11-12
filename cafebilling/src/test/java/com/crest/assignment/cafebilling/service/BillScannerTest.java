package com.crest.assignment.cafebilling.service;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.crest.assignment.cafebilling.BillScanner;
import com.crest.assignment.cafebilling.discount.strategy.BillingServiceImpl;
import com.crest.assignment.cafebilling.dto.Bill;
import com.crest.assignment.cafebilling.dto.Discount;
import com.crest.assignment.cafebilling.helper.BillingItemHelper;
import com.crest.assignment.cafebilling.helper.BillingItemHelperImpl;
import com.crest.assignment.cafebilling.menu.ItemCode;


public class BillScannerTest {
	
	BillScanner billScanner = new BillScanner(new BillingServiceImpl(), new BillingItemHelperImpl());
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	
	@Test
	public void testGenerateBillWhenNoItemsScanned(){
	 	expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Scan atleast one item...");
		billScanner.generateBill();
	}
	
	@Test
	public void testGenerateBillWhenDifferentOrdersArePlacedWithOnlyBillAmountDiscountApplicable(){
		
		// Tea Ice - 1 , Coffee Mocha - 1,  No Discount Bill < 100
		billScanner.scan(ItemCode.TEI, 1);
		billScanner.scan(ItemCode.COM, 1);
		Bill bill = billScanner.generateBill();
		Assert.assertEquals(55.0, bill.getAmount());
		Assert.assertEquals(0.0, bill.getFinalBillDiscount());
		
		// Tea Ice - 1 , Coffee Mocha - 1 , Cold Drink Coke - 1,  No Discount Bill < 100
				billScanner.scan(ItemCode.TEI, 1);
				billScanner.scan(ItemCode.COM, 1);
				billScanner.scan(ItemCode.CDC, 1);
			    bill = billScanner.generateBill();
				Assert.assertEquals(75.0, bill.getAmount());
				Assert.assertEquals(0.0, bill.getFinalBillDiscount());
				
		// Tea Masala - 3 , Coffee Latte - 2 , Cold Drink Sprite - 5 Discounted Bill
				billScanner.scan(ItemCode.TEM, 3);
				billScanner.scan(ItemCode.COL, 2);
				billScanner.scan(ItemCode.CDS, 5);
			    bill = billScanner.generateBill();
				
				Assert.assertEquals(165.0, bill.getAmount());
				Assert.assertEquals(16.5, bill.getFinalBillDiscount());
			
		// Tea Masala - 10 , Coffee Latte - 10 , Cold Drink Sprite - 5 Discounted Bill
				billScanner.scan(ItemCode.TEM, 10);
				billScanner.scan(ItemCode.COL, 10);
				billScanner.scan(ItemCode.CDS, 5);
			    bill = billScanner.generateBill();
				
				Assert.assertEquals(475.0, bill.getAmount());
				Assert.assertEquals(75.0, bill.getFinalBillDiscount());
				
	}
	
	
	// **************************  Tests With Both Individual Product Discounts And Bill Amount Discount  ***********************
	@Test
	public void testGenerateBillWhenDifferentOrdersArePlacedWhenBothIndividualProdDoscountAndBillAmountDiscountApplicable(){
		
		configureIndividualProductDiscount();
		
		// Tea Ice - 1 , Coffee Mocha - 1 
		billScanner.scan(ItemCode.TEI, 1);
		billScanner.scan(ItemCode.COM, 1);
		Bill bill = billScanner.generateBill();
		Assert.assertEquals(55.0, bill.getAmount());
		Assert.assertEquals(0.0, bill.getFinalBillDiscount());
		
		// Tea Ice - 1 , Coffee Mocha - 1 , Cold Drink Coke - 1
				billScanner.scan(ItemCode.TEI, 2);
				billScanner.scan(ItemCode.COM, 1);
				billScanner.scan(ItemCode.CDC, 1);
			    bill = billScanner.generateBill();
				Assert.assertEquals(90.0, bill.getAmount());
				Assert.assertEquals(0.0, bill.getFinalBillDiscount());
				
		// Tea Masala - 3 , Coffee Latte - 2 , Cold Drink Sprite - 5
		// Coffee Latte has individual doscount also		
				billScanner.scan(ItemCode.TEM, 3);
				billScanner.scan(ItemCode.COL, 2);
				billScanner.scan(ItemCode.CDS, 5);
			    bill = billScanner.generateBill();
				
				Assert.assertEquals(150.0, bill.getAmount());
				Assert.assertEquals(15.0, bill.getFinalBillDiscount());
	}
	
	private void configureIndividualProductDiscount()
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
