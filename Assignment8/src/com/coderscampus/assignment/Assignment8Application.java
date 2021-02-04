package com.coderscampus.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;



public class Assignment8Application {

	public static void main(String[] args) {

		String message = "Starting";
		System.out.println(message);
		System.out.println("Thead-"+ Thread.currentThread().getName());
		
		Assignment8 assignment = new Assignment8();

		
		 List<Integer> numbersList = Collections.synchronizedList(new ArrayList<>(1000));
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		List<CompletableFuture<Void>> tasks = new ArrayList<>(1000);

		for (int i=0; i<1000; i++) {
			CompletableFuture<Void> task = (CompletableFuture.supplyAsync(() -> assignment.getNumbers(), executor)
							                                 .thenAcceptAsync(numbers -> numbersList.addAll(numbers)));
		
       tasks.add(task);

	}
		while (tasks.stream().filter(CompletableFuture::isDone).count() < 1000) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		

		System.out.println("Done getting all 1,000,000 numbers");
		System.out.println("This number should be one million " + numbersList.size());

		
		Map<Integer, Long> intergerGrouped= numbersList.stream()
                                                       .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(intergerGrouped);

	
	}
}
