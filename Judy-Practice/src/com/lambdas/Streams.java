package com.lambdas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import domain.MarketOrder;
import domain.Order;
import domain.Trader;
import domain.Person;

public class Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//				new Thread(()-> {
//				      System.out.println("Lambda Thread Line One");
//				      System.out.println("Lambda Thread Line Two");
//				    }).start();

				
//				   Function<Integer,Integer> addOne = x -> x+1;
//			        Function<Integer,Integer> multiplyByTwo = x -> x*2;
		//
//			        Function<Integer,Integer> andThenExample = 		
//			        			addOne.andThen(multiplyByTwo);
//			        Function<Integer,Integer> composeExample =
//			        			addOne.compose(multiplyByTwo);
		//
//			        System.out.println(andThenExample.apply(10));    
//			        System.out.println(composeExample.apply(10));     
				
//			        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//			        List<Integer> oddSquares = 
//			              numbers.stream()
//			        	.filter(n->{
//			        	        System.out.println("filtering " + n);
//			        	        return n % 2 != 0; 
//			        	    })
//			        	.map(n->{
//			        	        System.out.println("mapping " + n);
//			        	        return n*n;
//			        	    })
//			        	.limit(3)
//			        	.collect(Collectors.toList());
		//
//				System.out.println(oddSquares);
				
				
//				try(Stream<String> lines = Files.lines(Paths.get("test.txt"))){
//				    lines.forEach(System.out::println);
//				}catch(IOException e){
//				    System.out.println(e.toString());
//				}

				
				

		List<Person> persons =
		    Arrays.asList(
		        new Person("Max", 18),
		        new Person("Peter", 23),
		        new Person("Pamela", 23),
		        new Person("David", 12));


		//persons
		//.stream()
		//.reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
		//.ifPresent(System.out::println);    // Pamela
				
				

		Integer ageSum = persons
		//.stream()
		.parallelStream()
		.reduce(0,
		    (sum, p) -> {
		        System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
		        return sum += p.getAge();
		    },
		    (sum1, sum2) -> {
		        System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
		        return sum1 + sum2;
		    });

		//accumulator: sum=0; person=Max
		//accumulator: sum=18; person=Peter
		//accumulator: sum=41; person=Pamela
		//accumulator: sum=64; person=David


		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		System.out.println(commonPool.getParallelism());    // 3

		//JVM parameter: -Djava.util.concurrent.ForkJoinPool.common.parallelism=5

				
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
