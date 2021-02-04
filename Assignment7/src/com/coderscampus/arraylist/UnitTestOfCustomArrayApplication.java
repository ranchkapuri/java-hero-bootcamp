package com.coderscampus.arraylist;


public class UnitTestOfCustomArrayApplication {

	public static void main(String[] args) {
		
   
		CustomArrayList<Integer> listToTestAddItemsByIndex = new CustomArrayList<>();
		
		listToTestAddItemsByIndex.add(10);
		listToTestAddItemsByIndex.add(20);
		listToTestAddItemsByIndex.add(30);
		listToTestAddItemsByIndex.add(40);
		
		System.out.println("Using Method add(item)");
	       for (int j=0; j<listToTestAddItemsByIndex.getSize(); j++) {
	             System.out.println(listToTestAddItemsByIndex.get(j));
             }
		

		listToTestAddItemsByIndex.add(2,101);


		System.out.println("========================");
		System.out.println("Using Method add(index,item)");
	       for (int j=0; j<listToTestAddItemsByIndex.getSize(); j++) {
 	             System.out.println(listToTestAddItemsByIndex.get(j));
               }
	       

     System.out.println("-----------------------");
     System.out.println("Using Method remove(index)");
     listToTestAddItemsByIndex.remove(2);
     for (int j=0; j<listToTestAddItemsByIndex.getSize(); j++) {
          System.out.println(listToTestAddItemsByIndex.get(j));
       }
	   
      
		System.out.println("========================");
		System.out.println("Using Method add(index,item),simulating throwing Exceptions");
		listToTestAddItemsByIndex.add(15,101);
		
		
	}

}

