package com.coddicted.tax.calculator.factory;

import java.math.BigDecimal;

import com.coddicted.tax.calculator.util.PersonType;
import com.coddicted.tax.calculator.util.TaxInfo;

public interface TaxCalculator {

	public TaxInfo calculateTax(BigDecimal totalIncome, PersonType p);
}
