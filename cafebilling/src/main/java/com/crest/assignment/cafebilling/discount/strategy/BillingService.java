package com.crest.assignment.cafebilling.discount.strategy;

import java.util.List;

import com.crest.assignment.cafebilling.dto.Bill;
import com.crest.assignment.cafebilling.dto.BillingItem;

public interface BillingService  {
	
	Bill generateBill(List<BillingItem> items);

}
