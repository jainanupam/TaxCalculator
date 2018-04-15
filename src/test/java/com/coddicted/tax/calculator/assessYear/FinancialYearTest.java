package com.coddicted.tax.calculator.assessYear;

import org.junit.Assert;
import org.junit.Test;

public class FinancialYearTest {

	@Test public void testValueOf(){
		Assert.assertEquals("Financial year value not received properly", FinancialYear.valueFor("2017-18").toString(), "2017-18");
	}
}
