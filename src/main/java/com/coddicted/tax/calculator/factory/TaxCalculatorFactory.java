package com.coddicted.tax.calculator.factory;

import java.math.BigDecimal;

import com.coddicted.tax.calculator.assessYear.FinancialYear;
import com.coddicted.tax.calculator.exception.AssessmentYearNotSupportedException;
import com.coddicted.tax.calculator.exception.FinYearNotSupportedException;
import com.coddicted.tax.calculator.factory.fy2017_18.TaxCalculatorImpl;
import com.coddicted.tax.calculator.pojo.TaxCalculatorInputPOJO;
import com.coddicted.tax.calculator.pojo.TaxInfo;
import com.coddicted.tax.calculator.util.PersonType;

public class TaxCalculatorFactory {

	/**
	 * @param totalIncome
	 * @param pt
	 * @param fy
	 * @return
	 * @throws FinYearNotSupportedException
	 */
	@Deprecated
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

	/**
	 * @param input
	 * @return
	 * @throws AssessmentYearNotSupportedException
	 */
	public static TaxInfo calculateTax(TaxCalculatorInputPOJO input) throws AssessmentYearNotSupportedException {
		TaxCalculator tc = null;
		
		switch (input.getAy()) {
		case AY_2018_19:
			tc = new TaxCalculatorImpl();
			break;

		default:
			throw new AssessmentYearNotSupportedException(input.getAy());
		}

		return tc.calculateTax(input);
	}
}
