package com.coddicted.tax.calculator.exception;

import com.coddicted.tax.calculator.assessYear.AssessmentYear;

public class AssessmentYearNotSupportedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AssessmentYear ay;
	
	public AssessmentYearNotSupportedException(AssessmentYear fy) {
		this.ay = fy;
	}

	@Override
	public String getMessage() {
		return "The Assessment year: " + ay.toString() + " is not supported yet";
	}
}
