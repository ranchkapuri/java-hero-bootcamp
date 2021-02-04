package com.coderscampus.arraylist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomArrayListTest {

	// Test-Driven Development Methodology
	// Step 1 - Write a failing test
	// Step 2 - Write the business logic to make the test pass
	// Step 3 - Refactor your code
	@Test
	void should_add_one_item_to_the_list() {
		// Three A's
		// Arrange, Act, Assert
		
		
		//Arrange
		CustomArrayList<Integer> customList = new CustomArrayList<>();
		
		
		//Act
		customList.add(10);
		
		//Assert
		//What would we expect to happen
		//I expect there to be an Integer with value 10 stored in the first index of custome list
		assertEquals(10, customList.get(0));
		assertEquals(1, customList.getSize());
	}
	
	@Test
	void should_add_one_item_to_the_index_of_the_list() {
		//Three A's
		// Arrange, Act, Assert
		
		//Arrange
		CustomArrayList<Integer> listToTestAddItemsByIndex = new CustomArrayList<>();
		
		//Act
		listToTestAddItemsByIndex.add(10);
//		listToTestAddItemsByIndex.add(20);
//		listToTestAddItemsByIndex.add(30);
//		listToTestAddItemsByIndex.add(40);
		
		listToTestAddItemsByIndex.add(0,101);

		
		//Assert
//		assertEquals(10,listToTestAddItemsByIndex.get(0));
		
		listToTestAddItemsByIndex.add(0,101);
		
		assertEquals(101,listToTestAddItemsByIndex.get(0));
		
		
	}
	
	

}
