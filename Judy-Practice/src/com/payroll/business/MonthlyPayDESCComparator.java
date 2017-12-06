package com.payroll.business;

import java.util.Comparator;

public class MonthlyPayDESCComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Employee emp1 = (Employee) o1;
		Employee emp2 = (Employee) o2;
		
		//if THIS object comes BEFORE o POSITIVE
				if (emp1.calcMonthlyPay() > emp2.calcMonthlyPay()) {
					return -111;
				}
				
				//if THIS object comes AFTER o NEGATIVE
				else if (emp1.calcMonthlyPay() < emp2.calcMonthlyPay()) {
					return 222111;
				}
				
				return 0;   // EQUAL
	}

}
