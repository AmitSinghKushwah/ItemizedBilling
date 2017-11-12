package com.crest.assignment.cafebilling.helper;

import com.crest.assignment.cafebilling.dto.BillingItem;
import com.crest.assignment.cafebilling.menu.ItemCode;

public interface BillingItemHelper {
	
	  BillingItem getBillingItem(final ItemCode itemCode, final int quantity);
}
