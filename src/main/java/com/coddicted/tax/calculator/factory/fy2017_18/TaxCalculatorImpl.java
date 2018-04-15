package com.coddicted.tax.calculator.factory.fy2017_18;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.coddicted.tax.calculator.factory.TaxCalculator;
import com.coddicted.tax.calculator.util.PersonType;
import com.coddicted.tax.calculator.util.TaxInfo;

public class TaxCalculatorImpl implements TaxCalculator {

	private static final BigDecimal slab1 = new BigDecimal(2_50_000).setScale(2); // 5%
    private static final BigDecimal slab2 = new BigDecimal(5_00_000).setScale(2); // 20%
    //private static final BigDecimal slab3 = new BigDecimal(10_00_000).setScale(2);	// 30%

    private static final BigDecimal slab1Rate = new BigDecimal(0.05);	// 5%
    private static final BigDecimal slab2Rate = new BigDecimal(0.20);	// 20%
    private static final BigDecimal slab3Rate = new BigDecimal(0.30);	// 30%
    
    private static final BigDecimal surchargeRate = new BigDecimal(0.03);	// 3%

	@Override
	public TaxInfo calculateTax(BigDecimal totalIncome, PersonType p) {
		System.out.println(totalIncome.toString());

        BigDecimal taxAmount = BigDecimal.ZERO.setScale(0);

        // Get the net taxable income after rebate from first slab
        BigDecimal netTaxableIncome = totalIncome.subtract(slab1);
        System.out.println(netTaxableIncome.toString());

        // Calculate tax for taxable slab1
        if (netTaxableIncome.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal taxableAmount = netTaxableIncome.compareTo(slab1) > 0 ? slab1 : netTaxableIncome;
            taxAmount = taxableAmount.multiply(slab1Rate).setScale(2, RoundingMode.HALF_UP);
            // Re calculate the remaining net taxable income
            netTaxableIncome = netTaxableIncome.subtract(slab1);
        }

        // Calculate tax for slab2 @ slab2Rate %
        if(netTaxableIncome.compareTo(BigDecimal.ZERO) > 0){
            BigDecimal taxableAmount = netTaxableIncome.compareTo(slab2) > 0 ? slab2 : netTaxableIncome;
            taxAmount = taxAmount.add(taxableAmount.multiply(slab2Rate).setScale(2, RoundingMode.HALF_UP));
            // Re calculate the remaining net taxable income
            netTaxableIncome = netTaxableIncome.subtract(slab2);
        }

        // Calculate flat tax on the remaining amount as per slab3Rate
        if (netTaxableIncome.compareTo(BigDecimal.ZERO) > 0) {
            taxAmount = taxAmount.add(netTaxableIncome.multiply(slab3Rate).setScale(2, RoundingMode.HALF_UP));
        }

        taxAmount = taxAmount.setScale(2, RoundingMode.HALF_UP);
        BigDecimal surcharge = taxAmount.multiply(surchargeRate).setScale(2);
        BigDecimal totalPayableAmount = taxAmount.add(surcharge).setScale(2, RoundingMode.HALF_UP);
        TaxInfo ti = new TaxInfo(taxAmount.setScale(2, RoundingMode.HALF_UP), surcharge, totalPayableAmount);
        return ti;
	}

}
