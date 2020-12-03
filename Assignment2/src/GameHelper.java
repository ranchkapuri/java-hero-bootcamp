import java.util.Scanner;

public class GameHelper {

	public int getUserInput(String prompt) {
		
		int input = 0;
		
		System.out.println(prompt + " ");
		
		Scanner scanner = new Scanner(System.in);
		input= scanner.nextInt();
		if (input > 100) {
			System.out.println("Your guess is not between 1 and 100, please try again");
		} 
		
		return input;
		
	
	}
	
}
