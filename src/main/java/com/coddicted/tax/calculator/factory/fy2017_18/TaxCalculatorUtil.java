package com.coddicted.tax.calculator.factory.fy2017_18;

import static com.coddicted.tax.calculator.factory.fy2017_18.TaxConstants.MAX_DEDUCTIBLE_AMOUNT;

import java.math.BigDecimal;

public class TaxCalculatorUtil {

	public static BigDecimal getMaxDeductableAmount(BigDecimal totalDeduction) {
		return MAX_DEDUCTIBLE_AMOUNT.compareTo(totalDeduction) > 0 ? totalDeduction : MAX_DEDUCTIBLE_AMOUNT;
	}
}
