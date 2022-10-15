package com.satishlabs.util;

import org.springframework.stereotype.Component;

import com.satishlabs.entity.Invoice;

@Component
public class InvoiceUtil {

	public Invoice CalculateFinalAmountIncludingGST(Invoice inv) {
		var amount = inv.getAmount();
		var gst = 0.2;
		var fianlAmount = amount+(amount*gst);
		inv.setFinalAmount(fianlAmount);
		return inv;
	}
	
}
