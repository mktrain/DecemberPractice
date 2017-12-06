package com.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {
		
		List<String> currencies = Arrays.asList("USD", "JPY", "EUR", "HKD", "INR", "AUD");

		Comparator<String> comparator
	      = (h1, h2) -> h1.compareTo(h2);
		
	    Collections.sort(currencies, comparator.reversed() );
	    
		//Collections.sort(currencies, ( a,  b) -> a.compareTo(b) ).reversed() );

	    Collections.sort(currencies, ( (Comparator<String>) ( (String a, String b) -> a.compareTo(b) ) ).reversed() );
	     
	    
	    Collections.sort(currencies, (h1, h2) -> h1.compareTo(h2) );
	    //Collections.sort(currencies, (Comparator) (h1, h2) -> h1.compareTo(h2) );
	   
	    Collections.sort(currencies, ( 
	    		(Comparator<String>)
	    		( ( a,  b) -> a.compareTo(b) ) ).reversed() 
	    );
	    
//	    Collections.sort(currencies,  
//	    		Comparator.comparing(( a,  b) -> a.compareTo(b) ).reversed() 
//	    );
	    
	    currencies.sort(Collections.reverseOrder((a,b) -> a.compareTo(b)));
//	    
	   
	   
	    
	    System.out.printf("Sorted Currencies (Descending):%n%n");
		currencies.forEach(currency -> System.out.println(currency));
		System.out.println();

//		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//		List<Integer> oddSquares = 
//		      numbers.stream()
//		      .limit(3)
//			.filter(n->{
//			        System.out.println("filtering " + n);
//			        return n % 2 != 0; 
//			    })
//			.map(n->{
//			        System.out.println("mapping " + n);
//			        return n*n;
//			    })
//			.collect(Collectors.toList());
//		
//		System.out.println(oddSquares);

		
		
		
		

	}

}
