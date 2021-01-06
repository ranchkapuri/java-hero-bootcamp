import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;



public class UserLoginApplication implements UserRoleInterface{
	

	public static void main(String[] args) {
		
	
		UserService userService = new UserService();
		
		User[] extractedUser= userService.getAllUsers();
		
		sortTextData(extractedUser);
		
	
		Scanner scanner = new Scanner(System.in);
		
     
	     int tryCounter=0;
		 boolean isValid=false;
		 String choice = null;
		 Integer number = 0;
		 

	       while (isValid==false && tryCounter<5 ) {
			   
	               tryCounter=tryCounter+1; 
                   User foundUser=null;
			 
     		     System.out.println("Enter your email:");
			     String userNameInput = scanner.nextLine();
			     System.out.println("Enter your password:");
			     String passwordInput = scanner.nextLine();
			 
			 
			 for (User user: extractedUser) {
				
				if (user.username.trim().equalsIgnoreCase(userNameInput.trim()) && 
					user.password.trim().equals(passwordInput.trim()) && 
				    SUPER_ROLE.equals(user.role.trim()) ) {
					foundUser= user;
                    
				}else if (user.username.trim().equalsIgnoreCase(userNameInput.trim()) && 
						user.password.trim().equals(passwordInput.trim()) && 
						NORMAL_ROLE.equals(user.role.trim()) ) {
						foundUser= user;
	                    
					} 
				  
	  
			 }
			 
			   if (foundUser !=null) {
				   isValid=true; 
//			       System.out.println(foundUser.username + "," + foundUser.password + "," + foundUser.fullName + "," + foundUser.role);   
				   
			while (number >= 0 & number < 5 ) {
				
				chooseOneOption(foundUser);

  			   choice = scanner.nextLine();
			   number = Integer.parseInt(choice);
			   
			   if (number==0 & SUPER_ROLE.equals(foundUser.role.trim())) {
				   
				     System.out.println("Which user would you like to login as? (Type in a valid username)");
				     choice = scanner.nextLine();
				     
					 for (User user: extractedUser) {
					
						if (user.username.trim().equalsIgnoreCase(choice.trim())) {
							foundUser=user;
		                    break;
						} 
					}			  
				   
			   }else if (number==1) {
				   System.out.println("Please type in your new Username:");
				   choice = scanner.nextLine();
				   TextFileModificationProgram.modifyFile("C:\\Users\\13474\\eclipse-workspace\\Assignment4\\users.txt", foundUser.username, choice);
				   foundUser.username=choice;
				   sortTextData(extractedUser);
				   
				   
				   
							   
			   }else if (number==2) {
				   System.out.println("Please type in your new password:");
				   choice = scanner.nextLine();
				   TextFileModificationProgram.modifyFile("C:\\Users\\13474\\eclipse-workspace\\Assignment4\\users.txt", foundUser.password, choice);
				   foundUser.password=choice;
								   
			   }else if (number==3) {
				   System.out.println("Please type in your new Fullname:");
				   choice = scanner.nextLine();
				   TextFileModificationProgram.modifyFile("C:\\Users\\13474\\eclipse-workspace\\Assignment4\\users.txt", foundUser.fullName, choice);
				   foundUser.fullName=choice;
				
				   
			   }else if (number==4) {
				   System.exit(0);
				   
			   }
			   
			   
			   
				
			}	   

			   }else {
				   if (tryCounter<5) {
					   System.out.println("Invalid login, please try again");
				   }
			   }
			 
		 } 
	       
	       
	       if (!isValid) {
	    	   System.out.println("Too many failed login attempts, you are not locked out.");
	       }
	       
	       scanner.close(); 
	}

	public static void sortTextData(User[] extractedUser) {	
		
		
		System.out.println("Before sorted");
		
		 for (User user: extractedUser) {
			 System.out.println(user);
		 }
		
		 System.out.println("------------------------------------------");
		 
		System.out.println("After sorted");
		 
		Arrays.sort(extractedUser);
		
		File file = new File("users.txt");
		 
		try {
			FileWriter writer = new FileWriter(file);
			writer.write("");
			 for (User user: extractedUser) {
				 System.out.println(user.username + "," + user.password + "," + user.fullName + "," + user.role);			 
				 String output = user.username + "," + user.password + "," + user.fullName + "," + user.role + "\n";
				 writer.write(output);
			
	         }
			 writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void  chooseOneOption(User foundUser) {
		

		
		if (SUPER_ROLE.equals(foundUser.role.trim())) {
		
		System.out.println("Welcome " + foundUser.fullName);
		   System.out.println("-------------------------------");
		   System.out.println("Please choose from the following options:");
		   System.out.println("(0) Log in as another user");
		   System.out.println("(1) Update username");
		   System.out.println("(2) Update password");
		   System.out.println("(3) Update name");
		   System.out.println("(4) Exit");

		   
		} else {
			System.out.println("Welcome " + foundUser.fullName);
			   System.out.println("-------------------------------");
			   System.out.println("Please choose from the following options:");
			   System.out.println("(1) Update username");
			   System.out.println("(2) Update password");
			   System.out.println("(3) Update name");
			   System.out.println("(4) Exit");

			
		}  
		

	}

}

