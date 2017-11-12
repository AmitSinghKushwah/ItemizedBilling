package com.crest.assignment.cafebilling.helper;


import junit.framework.Assert;

import org.junit.Test;

public class BillingDiscountHelperTest {

	private BillingDiscountHelper billDiscountHelper = new BillingDiscountHelperImpl();
	
	
	@Test
	public void testApplyDiscountWhenAmountIsBelow200(){
		Assert.assertEquals(0.0, billDiscountHelper.applyDiscount(100));
	}
	
	@Test
	public void testApplyDiscountWhenAmountIs100(){
		Assert.assertEquals(0.0, billDiscountHelper.applyDiscount(100));
	}
	

	@Test
	public void testApplyDiscountWhenAmountIsAbove100(){
		Assert.assertEquals(15.0, billDiscountHelper.applyDiscount(150));
	}
	
	@Test
	public void testApplyDiscountWhenAmountMarginallyAbove200(){
		Assert.assertEquals(22.0, billDiscountHelper.applyDiscount(210));
	}
	
	@Test
	public void testApplyDiscountWhenAmountSufficientlyAbove200(){
		Assert.assertEquals(60.0, billDiscountHelper.applyDiscount(400));
		Assert.assertEquals(180.0, billDiscountHelper.applyDiscount(1000));
	}
}
