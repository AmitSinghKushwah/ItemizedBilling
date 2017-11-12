package com.crest.assignment.cafebilling.helper;

import java.util.ArrayList;
import java.util.List;

import com.crest.assignment.cafebilling.dto.Slab;

public class BillingDiscountHelperImpl implements BillingDiscountHelper{
	
	private static List<Slab> slabs = new ArrayList<>();
	
	//This can be externalised for configuration, for now coded here.
	static{
		slabs.add(new Slab(100, 200, 10));
		slabs.add(new Slab(200, -1, 20));
	 }

	@Override
	public double applyDiscount(double amount) {
		
		double discount = 0;
		// fail fast if bill amount is below first slab upper bound
		if(amount <= slabs.get(0).getLowerBound()){
			return discount;
		}
	
		for (Slab slab : slabs) {
			discount = discount +  ((slab.getUpperBound() == -1 || amount < slab.getUpperBound() ? amount : slab.getUpperBound()) * slab.getDiscountPercent())/100;
			amount = amount - slab.getUpperBound();
			if(amount < 0) break;
		}
		return discount;
		
	}

}
