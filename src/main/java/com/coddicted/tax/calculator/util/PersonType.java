package com.coddicted.tax.calculator.util;

public enum PersonType {

	MALE("Male"),
	FEMALE("Female"),
	SENIOR_CITIZEN("Senior Citizen"),
	SENIOR_CITIZEN_ABOVE_80("Senior Citizen (Above 80)"),;
	
	private final String type;
	
	PersonType(String type){
		this.type = type;
	}
	
	public String getType(){
		return this.type;
	}
	
	@Override
	public String toString() {
		return this.type;
	}
	
	/**
	 * @return String[] : array of all available Person
	 * Types as Strings
	 */
	public static String[] getAllAvailablePersonTypes(){
		PersonType[] personTypes = PersonType.values();
		String[] types = new String[personTypes.length];
		int i = 0;
		for(PersonType pt: personTypes){
			types[i++] = pt.type;
		}
		return types;
	}
	
	public static void main(String[] args) {
		for(String s: PersonType.getAllAvailablePersonTypes()) {
			System.out.println(s);
		}
	}
}
