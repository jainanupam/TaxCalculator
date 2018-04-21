package com.coddicted.tax.calculator.pojo;

import java.math.BigDecimal;

import com.coddicted.tax.calculator.assessYear.AssessmentYear;
import com.coddicted.tax.calculator.assessYear.FinancialYear;
import com.coddicted.tax.calculator.util.PersonType;

/**
 * Simple POJO to act as the input argument for TaxCalculator API.
 * 
 * @author anupamjain
 *
 */
public class TaxCalculatorInputPOJO {

	private PersonType personType;
	private AssessmentYear ay;
	private FinancialYear fy;
	private BigDecimal totalIncome;
	private BigDecimal totalDeductions;
	
	public PersonType getPersonType() {
		return personType;
	}
	public void setPersonType(PersonType personType) {
		this.personType = personType;
	}
	public AssessmentYear getAy() {
		return ay;
	}
	public void setAy(AssessmentYear ay) {
		this.ay = ay;
	}
	public FinancialYear getFy() {
		return fy;
	}
	public void setFy(FinancialYear fy) {
		this.fy = fy;
	}
	public BigDecimal getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(BigDecimal totalIncome) {
		this.totalIncome = totalIncome;
	}
	public BigDecimal getTotalDeductions() {
		return totalDeductions;
	}
	public void setTotalDeductions(BigDecimal totalDeductions) {
		this.totalDeductions = totalDeductions;
	}
	
}
