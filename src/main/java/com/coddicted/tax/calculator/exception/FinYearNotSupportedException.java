package com.coddicted.tax.calculator.exception;

import com.coddicted.tax.calculator.assessYear.FinancialYear;

public class FinYearNotSupportedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FinancialYear fy;
	
	public FinYearNotSupportedException(FinancialYear fy) {
		this.fy = fy;
	}

	@Override
	public String getMessage() {
		return "The financial year: " + fy.toString() + " is not supported yet";
	}
}
