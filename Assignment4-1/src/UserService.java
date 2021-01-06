
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class UserService implements UserRoleInterface {
	
    int i =0 ; 


public User[] getAllUsers()	{
	
	String readDataLine = null;
    User[] arrayUser= new User[20];
    NormalUser normalUser= null;
    SuperUser superUser= null;
	
	try {

		File myFile = new File ("users.txt");
		FileReader fileReader = new FileReader(myFile);
		BufferedReader bufferedReader= new BufferedReader(fileReader);
		while ((readDataLine = bufferedReader.readLine()) !=null) {
			
			System.out.println(readDataLine);
			String[] string1= readDataLine.split(",");
			
		
			User usr= new User();
			if (NORMAL_ROLE.equals(string1[3].trim())){
				normalUser= new NormalUser(string1[0],string1[1],string1[2],string1[3]);
				arrayUser[i]=normalUser;
			} else if (SUPER_ROLE.equals(string1[3].trim())) {
				superUser= new SuperUser(string1[0],string1[1],string1[2],string1[3]);
				arrayUser[i]=superUser;
			}
			
		
			i=i+1;
		}
		bufferedReader.close();
	} catch (Exception ex) {
		System.out.println("Oops Something is wrong reading the text file");
		ex.printStackTrace();
	}
	
	return arrayUser;
}



}
