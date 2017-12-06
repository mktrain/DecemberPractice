package com.payroll.business;

public class PartTime extends Employee {

	
	double hourlyRate;
	double currentHoursForTheMonth;
	
	public PartTime(String name, String email, double hours, double hourlyRate) {
		super(name, email);
		// TODO Auto-generated constructor stub
	}
	
	public double getHourlyRate() {
		return hourlyRate;
	}   
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	public double getCurrentHoursForTheMonth() {
		return currentHoursForTheMonth;
	}
	public void setCurrentHoursForTheMonth(double currentHoursForTheMonth) {
		this.currentHoursForTheMonth = currentHoursForTheMonth;
	}

	@Override
	public double calcMonthlyPay() {
		// TODO Auto-generated method stub
		return currentHoursForTheMonth * hourlyRate;
	}
	
	
	
}
