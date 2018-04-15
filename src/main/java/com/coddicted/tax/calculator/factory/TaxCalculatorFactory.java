package com.coddicted.tax.calculator.factory;

import java.math.BigDecimal;

import com.coddicted.tax.calculator.assessYear.FinancialYear;
import com.coddicted.tax.calculator.exception.FinYearNotSupportedException;
import com.coddicted.tax.calculator.factory.fy2017_18.TaxCalculatorImpl;
import com.coddicted.tax.calculator.util.PersonType;
import com.coddicted.tax.calculator.util.TaxInfo;

public class TaxCalculatorFactory {

	/**
	 * @param totalIncome
	 * @param pt
	 * @param fy
	 * @return
	 * @throws FinYearNotSupportedException
	 */
	public static TaxInfo calculateTax(BigDecimal totalIncome, PersonType pt, FinancialYear fy)
			throws FinYearNotSupportedException {

		TaxCalculator tc = null;

		switch (fy) {
		case FY_2017_18:
			tc = new TaxCalculatorImpl();
			break;

		default:
			throw new FinYearNotSupportedException(fy);
		}

		return tc.calculateTax(totalIncome, pt);
	}
}
