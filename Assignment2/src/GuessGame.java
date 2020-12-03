import java.util.Random;
import java.util.Scanner;

public class GuessGame {

	public static void main(String[] args) {
	
	 int numberOfGuess=0;
	 
	 int random = (int) (Math.random() * 100); 
	 
     System.out.println("Random Nunber is " + random);  
     
     Scanner scanner1 = new Scanner (System.in);
     System.out.println("Please enter First Name ");
     String firstName = scanner1.nextLine();
     System.out.println("Please enter Last Name ");
     String lastName = scanner1.nextLine();
	
      Players player = new Players (firstName,lastName);
      
   
      GameHelper gameHelper = new GameHelper();     
     
    
//      System.out.println("Player " + player.firstName + " " + player.lastName + " enter your first guess");
      

      boolean isAlive = true; 
      String prompt= "Pick a number between 1 and 100 and you have 5 max guessess";
      
      while (isAlive == true & numberOfGuess<=5) {
    	  int guess= gameHelper.getUserInput(prompt); 
    	  System.out.println(guess);
    	  numberOfGuess=numberOfGuess + 1;
    	  System.out.println("Number of guess so far is " +numberOfGuess);
    	  if (guess < random) {
    		  prompt= "Please pick a higher number";
    		  isAlive=true;    		  
    	  }else if (guess > random) {
    		  prompt="Please pick a lower number";
    		  isAlive=true;
    	  }else if (guess == random) {
    		  System.out.println("You win!");
    		  isAlive=false;
    	  }
      }
      
      if (isAlive == true & numberOfGuess==6) {
      
      System.out.println("The Player " + player.firstName + " " + player.lastName  + " lost, the number to guess was " + random);
	}

	}   
}
