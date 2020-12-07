import java.io.*;


public class UserService {
	
    int i =0 ; 


public User[] getLeadLine()	{
	
	String readDataLine = null;
    User[] arrayUser= new User[4];
	
	try {

		File myFile = new File ("data.txt");
		FileReader fileReader = new FileReader(myFile);
		BufferedReader bufferedReader= new BufferedReader(fileReader);
		while ((readDataLine = bufferedReader.readLine()) !=null) {
			
			System.out.println(readDataLine);
			String[] string1= readDataLine.split(",");
			
		
			User usr= new User();
			usr.username=string1[0];
			usr.password=string1[1];
			usr.fullName=string1[2];
			
//			User[] arrayUser= new User[4];
			arrayUser[i]=usr;
			
			
			i=i+1;
		}
		bufferedReader.close();
	} catch (Exception ex) {
		System.out.println("Oops Somehting is wrong reading the text file");
		ex.printStackTrace();
	}
	
	return arrayUser;
}



}


