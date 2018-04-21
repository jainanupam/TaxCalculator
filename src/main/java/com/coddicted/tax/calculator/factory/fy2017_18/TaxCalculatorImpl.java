package com.coddicted.tax.calculator.factory.fy2017_18;

import static com.coddicted.tax.calculator.factory.fy2017_18.TaxConstants.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.coddicted.tax.calculator.factory.TaxCalculator;
import com.coddicted.tax.calculator.pojo.TaxCalculatorInputPOJO;
import com.coddicted.tax.calculator.pojo.TaxInfo;
import com.coddicted.tax.calculator.util.PersonType;

public class TaxCalculatorImpl implements TaxCalculator {

	private static TaxCalculator _instance;

	public static TaxCalculator getInstance() {
		if (_instance == null) {
			_instance = new TaxCalculatorImpl();
		}
		return _instance;
	}

	/* (non-Javadoc)
	 * @see com.coddicted.tax.calculator.factory.TaxCalculator#calculateTax(java.math.BigDecimal, com.coddicted.tax.calculator.util.PersonType)
	 */
	@Override
	public TaxInfo calculateTax(BigDecimal totalIncome, PersonType p) {
		/*
		 * NOTE:
		 * This method was just for testing purposes and should not be used anymore.
		 * Is also a candidate for removal in future release.
		 */

		BigDecimal taxAmount = BigDecimal.ZERO.setScale(0);

		// Get the net taxable income after rebate from first slab
		BigDecimal netTaxableIncome = totalIncome.subtract(slab1);
		System.out.println(netTaxableIncome.toString());

		// Calculate tax for taxable slab1
		if (netTaxableIncome.compareTo(BigDecimal.ZERO) > 0) {
			BigDecimal taxableAmount = netTaxableIncome.compareTo(slab1) > 0 ? slab1 : netTaxableIncome;
			taxAmount = taxableAmount.multiply(slab1Rate);
			// Re calculate the remaining net taxable income
			netTaxableIncome = netTaxableIncome.subtract(slab1);
		}

		// Calculate tax for slab2 @ slab2Rate %
		if (netTaxableIncome.compareTo(BigDecimal.ZERO) > 0) {
			BigDecimal taxableAmount = netTaxableIncome.compareTo(slab2) > 0 ? slab2 : netTaxableIncome;
			taxAmount = taxAmount.add(taxableAmount.multiply(slab2Rate));
			// Re calculate the remaining net taxable income
			netTaxableIncome = netTaxableIncome.subtract(slab2);
		}

		// Calculate flat tax on the remaining amount as per slab3Rate
		if (netTaxableIncome.compareTo(BigDecimal.ZERO) > 0) {
			taxAmount = taxAmount.add(netTaxableIncome.multiply(slab3Rate));
		}

		// taxAmount = taxAmount.setScale(2, RoundingMode.HALF_UP);
		BigDecimal surcharge = taxAmount.multiply(surchargeRate);
		BigDecimal totalPayableAmount = taxAmount.add(surcharge).setScale(2, RoundingMode.HALF_UP);
		TaxInfo ti = new TaxInfo(taxAmount.setScale(2, RoundingMode.HALF_UP), surcharge, totalPayableAmount);
		return ti;
	}

	@Override
	public TaxInfo calculateTax(TaxCalculatorInputPOJO input) {

		TaxInfo taxInfo = null;

		switch (input.getPersonType()) {
		case SUPER_SENIOR_CITIZEN:
			// Slab 1 differs for super senior citizens. Hence separate
			// calculations.
			taxInfo = SuperSeniorTaxCalculator.calculateTax(input);
			break;
		case MALE:
		case FEMALE:
		case SENIOR_CITIZEN:
			taxInfo = IndividualsNonSuperSeniorTaxCalculator.calculateTax(input);
		default:
			break;
		}
		return taxInfo;
	}

}
