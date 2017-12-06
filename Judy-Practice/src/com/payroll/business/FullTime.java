package com.payroll.business;

public class FullTime extends Employee {
	
	private int salary;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public FullTime(String name, String email, int salary) {
		super(name, email);
		this.salary = salary;
	}
	

	@Override
	public double calcMonthlyPay() {
		return salary / 12.0;
	}
	
	public String toString() {
		return "FT: " + super.toString() + " salary=" + this.salary;
	}

	


}
