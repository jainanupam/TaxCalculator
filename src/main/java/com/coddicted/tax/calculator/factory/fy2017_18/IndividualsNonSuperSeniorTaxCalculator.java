package com.coddicted.tax.calculator.factory.fy2017_18;

import static com.coddicted.tax.calculator.factory.fy2017_18.TaxConstants.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.coddicted.tax.calculator.pojo.TaxCalculatorInputPOJO;
import com.coddicted.tax.calculator.pojo.TaxInfo;

public class IndividualsNonSuperSeniorTaxCalculator {

	public static TaxInfo calculateTax(TaxCalculatorInputPOJO input){
		
		TaxInfo taxInfo = new TaxInfo();
		BigDecimal taxAmount = BigDecimal.ZERO;

        // Get the net taxable income after leaving out deductions and rebate from first slab
        BigDecimal netTaxableIncome = input.getTotalIncome().subtract(input.getTotalDeductions());
        netTaxableIncome = netTaxableIncome.subtract(slab1);
        // TODO need to change to logger
        System.out.println("Net taxable income for individual: " + netTaxableIncome.toString());

        // Calculate tax for taxable slab1
        if (netTaxableIncome.compareTo(BigDecimal.ZERO) > 0) {
            // BigDecimal is immutable so safe to assign in output object here.
            taxInfo.setNetTaxableIncome(netTaxableIncome);

            BigDecimal taxableAmount = netTaxableIncome.compareTo(slab1) > 0 ? slab1 : netTaxableIncome;
            taxAmount = taxableAmount.multiply(slab1Rate);
            // Re calculate the remaining net taxable income
            netTaxableIncome = netTaxableIncome.subtract(slab1);
        } else {
            // there is no taxable income so setting the value to 0 in output
            taxInfo.setNetTaxableIncome(BigDecimal.ZERO);
        }

        // Calculate tax for slab2 @ slab2Rate %
        if(netTaxableIncome.compareTo(BigDecimal.ZERO) > 0){
            BigDecimal taxableAmount = netTaxableIncome.compareTo(slab2) > 0 ? slab2 : netTaxableIncome;
            taxAmount = taxAmount.add(taxableAmount.multiply(slab2Rate));
            // Re calculate the remaining net taxable income
            netTaxableIncome = netTaxableIncome.subtract(slab2);
        }

        // Calculate flat tax on the remaining amount as per slab3Rate
        if (netTaxableIncome.compareTo(BigDecimal.ZERO) > 0) {
            taxAmount = taxAmount.add(netTaxableIncome.multiply(slab3Rate));
        }

        //taxAmount = taxAmount.setScale(2, RoundingMode.HALF_UP);
        BigDecimal surcharge = taxAmount.multiply(surchargeRate);
        BigDecimal totalPayableAmount = taxAmount.add(surcharge).setScale(2, RoundingMode.HALF_UP);

        // set all the values in the output object.
        // TODO need to check here as we are rounding both to half_up, will this cause any issue?
        taxInfo.setTaxAmount(taxAmount.setScale(2, RoundingMode.HALF_UP));
		taxInfo.setSurcharge(surcharge.setScale(2, RoundingMode.HALF_UP));
		taxInfo.setTotalPayableAmount(totalPayableAmount);
		
		return taxInfo;
	}
}
