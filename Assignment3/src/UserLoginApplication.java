import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {
		
//		User user = new User();
		
		UserService userService = new UserService();
		
//		System.out.println(userService.getLeadLine());
		
		User[] user2= userService.getLeadLine();
		
		
/*		
		for (User user: user2) {
			System.out.println(user.username);
			System.out.println(user.password);
			System.out.println(user.fullName);
			System.out.println(user);
		}
*/
	     
	     int i=0;
		 boolean isAlive=true;
		 
PARENT_LOOP: while (isAlive==true && i<5 ) {
			   
			    i=i+1; 	
			 
				Scanner scanner = new Scanner(System.in);

			     System.out.println("Enter your email:");
			     String userName = scanner.nextLine();
			     System.out.println("Enter your password:");
			     String password = scanner.nextLine();
			 
			 
			 for (User user3: user2) {
				String userName1 = user3.username;
				String password1 = user3.password;	
				if (userName1.equalsIgnoreCase(userName) && password1.equals(password)) {
					System.out.println("Welcome " +  userName);
					isAlive=false;
					break PARENT_LOOP;
				} else {
					if (i==5) {
						System.out.println("Too many failed login attempts, you are now locked out.");
						break PARENT_LOOP;
					}else {
					System.out.println("Invalid login, please try again.");
					isAlive=true;
					break;
					}
				}
			  
			 }
			 
//			 i=i+1;
			 
			 
		 } 

/*
	      if (isAlive == true & i==5) {
	          
	          System.out.println("Too many failed login attempts, you are now locked out.");
	    	}
*/	 
		 
	}

}
