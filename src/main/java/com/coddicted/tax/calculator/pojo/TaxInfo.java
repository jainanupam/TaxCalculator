package com.coddicted.tax.calculator.pojo;

import java.math.BigDecimal;

public class TaxInfo {

	private BigDecimal totalDeductionsConsidered;
	private BigDecimal netTaxableIncome;
	private BigDecimal taxAmount;
	private BigDecimal surcharge;
	private BigDecimal totalPayableAmount;

	public TaxInfo() {

	}

	public TaxInfo(BigDecimal taxAmount, BigDecimal surcharge, BigDecimal totalPayableAmount) {
		super();
		this.taxAmount = taxAmount;
		this.surcharge = surcharge;
		this.totalPayableAmount = totalPayableAmount;
	}

	@Override
	public String toString() {
		return "Net Taxable Income: " + netTaxableIncome.toString() + "taxAmount: " + taxAmount.toString()
				+ "\nsurcharge: " + surcharge.toString() + "\ntotalPayableAmount: " + totalPayableAmount.toString();
	}
	
	public BigDecimal getNetTaxableIncome() {
		return netTaxableIncome;
	}

	public void setNetTaxableIncome(BigDecimal netTaxableIncome) {
		this.netTaxableIncome = netTaxableIncome;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public BigDecimal getSurcharge() {
		return surcharge;
	}

	public void setSurcharge(BigDecimal surcharge) {
		this.surcharge = surcharge;
	}

	public BigDecimal getTotalPayableAmount() {
		return totalPayableAmount;
	}

	public void setTotalPayableAmount(BigDecimal totalPayableAmount) {
		this.totalPayableAmount = totalPayableAmount;
	}

	public BigDecimal getTotalDeductionsConsidered() {
		return totalDeductionsConsidered;
	}

	public void setTotalDeductionsConsidered(BigDecimal totalDeductionsConsidered) {
		this.totalDeductionsConsidered = totalDeductionsConsidered;
	}

}
