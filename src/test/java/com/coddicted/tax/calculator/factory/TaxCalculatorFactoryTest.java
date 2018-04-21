package com.coddicted.tax.calculator.factory;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.coddicted.tax.calculator.assessYear.AssessmentYear;
import com.coddicted.tax.calculator.exception.AssessmentYearNotSupportedException;
import com.coddicted.tax.calculator.pojo.TaxCalculatorInputPOJO;
import com.coddicted.tax.calculator.pojo.TaxInfo;
import com.coddicted.tax.calculator.util.PersonType;

public class TaxCalculatorFactoryTest {

	@Test
	public void testCalculateTax() throws AssessmentYearNotSupportedException{
		
		TaxCalculatorInputPOJO input = new TaxCalculatorInputPOJO();
		
		// test for Female individual
		System.out.println("----------- Testing for Female individual --------------");
		input.setAy(AssessmentYear.AY_2018_19);
		input.setPersonType(PersonType.MALE);
		input.setTotalIncome(new BigDecimal(5_00_000));
		input.setTotalDeductions(new BigDecimal(10_000));
		TaxInfo ti = TaxCalculatorFactory.calculateTax(input);
		System.out.println(ti.toString());
		assertEquals(12360.00, ti.getTotalPayableAmount().doubleValue(), 0.01);
		
		// Test for super senior citizen
		System.out.println("----------- Testing for Super Senior individual --------------");
		input.setPersonType(PersonType.SUPER_SENIOR_CITIZEN);
		ti = TaxCalculatorFactory.calculateTax(input);
		System.out.println(ti.toString());
		assertEquals(9785.00, ti.getTotalPayableAmount().doubleValue(), 0.01);
		
		// Test for super senior citizen
		System.out.println("----------- Testing for Max Discount allowed --------------");
		input.setPersonType(PersonType.MALE);
		input.setTotalDeductions(new BigDecimal(5_00_000));
		ti = TaxCalculatorFactory.calculateTax(input);
		System.out.println(ti.toString());
		assertEquals(5150.00, ti.getTotalPayableAmount().doubleValue(), 0.01);

	}
}
