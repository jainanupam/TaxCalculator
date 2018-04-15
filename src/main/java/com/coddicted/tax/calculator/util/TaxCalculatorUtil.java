package com.coddicted.tax.calculator.util;

import com.coddicted.tax.calculator.assessYear.FinancialYear;

public class TaxCalculatorUtil {

	public static String[] getSupportedFinancialYears(){
		
		FinancialYear[] fys = FinancialYear.values();
		String[] finYears = new String[fys.length];
		int i = 0;
		for(FinancialYear fy: fys) {
			finYears[i++] = fy.toString();
		}
		return  finYears;
	}
	
	public static String[] getSupportedPersonTypes(){
		PersonType[] pts = PersonType.values();
		String[] persTypes = new String[pts.length];
		int i= 0;
		for(PersonType pt: pts){
			persTypes[i++] = pt.toString();
		}
		return persTypes;
	}
	
	public static void main(String[] args) {
		String[] fys = getSupportedFinancialYears();
		for(String fy: fys){
			System.out.println(fy);
		}
		
		String[] pts = getSupportedPersonTypes();
		for (String string : pts) {
			System.out.println(string);
		}
	}
}
