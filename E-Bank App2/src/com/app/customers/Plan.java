package com.app.customers;

public enum Plan{
	SILVER(1000), GOLD(1500), DIAMOND(2000), PLATINUM(2500);
	private int planFee;
	
	//constructor : access modifier--private
	private Plan(int fee) {
		//super(String name, int ordinal);
		this.planFee = fee;
	}
	
	//setter for planFee
	public void changePlanFee(int planFee) {
		this.planFee = planFee;
	}

	public int getPlanFee() {
		return planFee;
	}

	
	//Plan.values +> gives Plan[] of enun constant names we can iterate using for each loop
	//Plan.valueOf(String name)  convert to datatype enum
	//name() returns name of enum constant
}
