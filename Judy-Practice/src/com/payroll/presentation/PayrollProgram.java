package com.payroll.presentation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.payroll.business.Employee;
import com.payroll.business.FullTime;
import com.payroll.business.MonthlyPayAscComparator;
import com.payroll.business.MonthlyPayDESCComparator;

public class PayrollProgram {
	
	private static void printStars() {
		System.out.println("**********");
	}
	

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		printStars();
		
		System.out.println(new Date());
		
		FullTime ft = new FullTime("bob","bob@gmail.com",125000);
		FullTime ft2 = new FullTime("nancy","nancy@gmail.com",5000);
		FullTime ft3 = new FullTime("anubhav","anubhav@gmail.com",25000);

		Employee[] employees = new Employee[3];
		employees[0] = ft;
		employees[1] = ft2;
		employees[2] = ft3;
		
		for (Employee temp : employees) {
			System.out.println(temp);
		}
		
		System.out.println("******");
		
		Arrays.sort(employees);
		
		for (Employee temp : employees) {
			System.out.println(temp);
		}
		
		System.out.println("****** Pay Ascending ******");
		
		
		Arrays.sort(employees, new MonthlyPayAscComparator());
		
		for (Employee temp : employees) {
			System.out.println(temp);
		}
		
		
System.out.println("****** Pay DESC ******");
		
		//anonymous inner class
		Arrays.sort(employees, 
				(Object o1, Object o2) -> {
				Employee emp1 = (Employee) o1;
				Employee emp2 = (Employee) o2;
				
				//if THIS object comes BEFORE o POSITIVE
						if (emp1.calcMonthlyPay() > emp2.calcMonthlyPay()) {
							return 111;
						}
						
						//if THIS object comes AFTER o NEGATIVE
						else if (emp1.calcMonthlyPay() < emp2.calcMonthlyPay()) {
							return -222111;
						}
						
						return 0;   // EQUAL
			}
		);
		
		for (Employee temp : employees) {
			System.out.println(temp);
		}
		
		Map<Employee, String> myMap = new HashMap<Employee, String>();
		myMap.put(ft, "hello");
		
		
		String received = myMap.get(ft);
		
		//myMap.put("World", ft2)
		
		String[] currencies =  { "one", "two", "three"};
		List<String> currList = Arrays.asList(currencies);
		
		
		
		
	}
	
	
	
}
