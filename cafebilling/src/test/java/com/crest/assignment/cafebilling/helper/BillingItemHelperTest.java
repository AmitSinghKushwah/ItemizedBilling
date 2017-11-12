package com.crest.assignment.cafebilling.helper;

import junit.framework.Assert;

import org.junit.Test;

import com.crest.assignment.cafebilling.dto.BillingItem;
import com.crest.assignment.cafebilling.dto.Discount;
import com.crest.assignment.cafebilling.menu.ItemCode;

public class BillingItemHelperTest {
	
	private BillingItemHelperImpl billingItemHelper = new BillingItemHelperImpl();
	
	@Test
	public void testGetBillingItemWhenNoIndividualProductDiscount(){
		BillingItem billingItem = billingItemHelper.getBillingItem(ItemCode.COC, 4);
		
		Assert.assertEquals(ItemCode.COC, billingItem.getItemCode());
		Assert.assertEquals(4, billingItem.getQuantity());
		Assert.assertEquals(0.0, billingItem.getRebate());
		Assert.assertEquals(60.0, billingItem.getAmount());
		
	}
	
	@Test
	public void testGetBillingItemWhenIndividualProductDiscountIsConfigured(){
		billingItemHelper.putProductDiscounts(ItemCode.COC, new Discount(3, 30));
		
		BillingItem billingItem = billingItemHelper.getBillingItem(ItemCode.COC, 4);
		
		Assert.assertEquals(ItemCode.COC, billingItem.getItemCode());
		Assert.assertEquals(4, billingItem.getQuantity());
		Assert.assertEquals(18.0, billingItem.getRebate());
		Assert.assertEquals(60.0, billingItem.getAmount());
		
	}

}
