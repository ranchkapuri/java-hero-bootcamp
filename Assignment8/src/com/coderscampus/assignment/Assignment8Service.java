package com.coderscampus.assignment;

import java.util.List;

public class Assignment8Service implements Runnable {

	@Override
	public void run() {
		
	       Assignment8 assignment = new Assignment8();

	       
	        for (int i=0; i<1000; i++) {

	            List<Integer> numbersList = assignment.getNumbers();

	            System.out.println(numbersList);

	        }
		
	}
	
	

}
