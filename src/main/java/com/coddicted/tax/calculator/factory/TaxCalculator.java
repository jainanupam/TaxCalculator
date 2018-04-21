package com.coddicted.tax.calculator.factory;

import java.math.BigDecimal;

import com.coddicted.tax.calculator.pojo.TaxCalculatorInputPOJO;
import com.coddicted.tax.calculator.pojo.TaxInfo;
import com.coddicted.tax.calculator.util.PersonType;

public interface TaxCalculator {

	@Deprecated
	public TaxInfo calculateTax(BigDecimal totalIncome, PersonType p);
	public TaxInfo calculateTax(TaxCalculatorInputPOJO input);
}
