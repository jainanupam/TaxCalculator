package com.coddicted.tax.calculator.assessYear;

/**
 * 
 *  Assessment year is taken as 1 + Financial year for which assessment
 *         is being done.
 *         
 * @author anupam jain
 */
public enum AssessmentYear {

	//AY_2019_20(2019, 2020),
	AY_2018_19(2018, 2019);
	
	private int startYear;
	private int endYear;
	
	/**
	 * @param startYear (ex: 2018)
	 * @param endYear (ex: 2019)
	 */
	private AssessmentYear(int startYear, int endYear){
		this.startYear = startYear;
		this.endYear = endYear;
	}
	
	@Override
	public final String toString() {
		return this.startYear + "-" + String.valueOf(this.endYear).substring(2);
	}

	public static AssessmentYear valueFor(String value){
		for(AssessmentYear fy: AssessmentYear.values()){
			if(fy.toString().equals(value)){
				return fy;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(AssessmentYear.valueFor("2018-19").name() + " : " + AssessmentYear.AY_2018_19.toString());
	}
}
