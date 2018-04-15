package com.coddicted.tax.calculator.util;

import java.math.BigDecimal;

public class TaxInfo {

	private BigDecimal taxAmount;
	private BigDecimal surcharge;
	private BigDecimal totalPayableAmount;
	
	
	public TaxInfo(BigDecimal taxAmount, BigDecimal surcharge, BigDecimal totalPayableAmount) {
		super();
		this.taxAmount = taxAmount;
		this.surcharge = surcharge;
		this.totalPayableAmount = totalPayableAmount;
	}
	
	public BigDecimal getTaxAmount() {
		return taxAmount;
	}
	public BigDecimal getSurcharge() {
		return surcharge;
	}
	public BigDecimal getTotalPayableAmount() {
		return totalPayableAmount;
	}
	
}
