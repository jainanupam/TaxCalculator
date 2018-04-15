package com.coddicted.tax.calculator.assessYear;

public enum FinancialYear {

	FY_2018_19(2018, 2019),
	FY_2017_18(2017, 2018);
	
	
	private int startYear;
	private int endYear;
	
	/**
	 * @param startYear (ex: 2018)
	 * @param endYear (ex: 2019)
	 */
	private FinancialYear(int startYear, int endYear){
		this.startYear = startYear;
		this.endYear = endYear;
	}
	
	@Override
	public final String toString() {
		return this.startYear + "-" + String.valueOf(this.endYear).substring(2);
	}

	public static FinancialYear valueFor(String value){
		for(FinancialYear fy: FinancialYear.values()){
			if(fy.toString().equals(value)){
				return fy;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(FinancialYear.valueFor("2017-18").name());
	}
}
