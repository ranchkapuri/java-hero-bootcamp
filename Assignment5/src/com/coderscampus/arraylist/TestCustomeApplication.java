package com.coderscampus.arraylist;

public class TestCustomeApplication {

	public static void main(String[] args) {
		
		CustomList<Integer> numbers = new CustomArrayList<>();

		
		for (int i=0; i<40; i++) {
			numbers.add(i);
//			System.out.println(numbers.get(i));
		}

	       for (int j=0; j<numbers.getSize(); j++) {
	    	   System.out.println(numbers.get(j));
	       }		
		
       System.out.println("----------");		
	   System.out.println(numbers.getSize());
       System.out.println("----------");
	   System.out.println(numbers.get(5));
	   
      

	}

}
