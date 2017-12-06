package com.lambdas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import domain.MarketOrder;
import domain.Order;
import domain.Trader;

public class Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
		Supplier<Stream<String>> streamSupplier = 	
				() -> Stream.of("a","b","c","d","e")
				        .filter(s -> s.startsWith("a"));

			streamSupplier.get().anyMatch(s -> s.startsWith("a"));
			streamSupplier.get().noneMatch(s -> s.startsWith("b"));
			
			
			try {
				Files.lines(Paths.get("test.txt"))
				.map(line -> line.split("\\s+"))
				.flatMap(Arrays::stream)
				.distinct()
				.forEach(System.out::println);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			List<Trader> traders = new ArrayList<>();

			IntStream
			  .range(1,4)
			  .forEach(i -> traders.add(new Trader(i)));

						
			  traders.forEach( t->
			     IntStream
				.range(1,6)
				.forEach(o -> t.addOrder(new MarketOrder())));

			  long totalNumberOrders = 
					    traders.stream()
						.map(t->  (t.getOrders()))
						.count();
					System.out.printf("Total number of orders without FlatMap is %d%n", 
									totalNumberOrders);


			long totalNumberOrders2 = 
						    traders.stream()
							.flatMap(t->  (t.getOrders().stream()))
							.count();
						System.out.printf("Total number of orders with FlatMap is %d%n", 
										totalNumberOrders2);
		
					
	}

}
