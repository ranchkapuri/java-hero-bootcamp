import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

	public static void login() {
		List<User> users = getUsersFromFile();

		Integer attempts = 0;
		Boolean isAlive = true;

		PARENT_LOOP: while (isAlive == true && attempts < 5) {

			attempts++;

			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter your email:");
			String userName = scanner.nextLine();
			System.out.println("Enter your password:");
			String userPassword = scanner.nextLine();

			if (checkIfUserExists(userName, userPassword, users)) {
				scanner.close();
				isAlive = false;
				break PARENT_LOOP;
			}

			if (attempts == 5) {
				scanner.close();
				System.out.println("Too many failed login attempts, you are now locked out.");
				break PARENT_LOOP;
			}

			System.out.println("Invalid login, please try again.");
			isAlive = true;
		}

	}

	private static Boolean checkIfUserExists(String userName, String password, List<User> users) {
		for (User user : users) {
			String existingUsername = user.getUsername();
			String existingPassword = user.getPassword();
			if (existingUsername.equalsIgnoreCase(userName) && existingPassword.equals(password)) {
				System.out.println("Welcome " + userName);
				return true;
			}
		}
		return false;
	}

	private static List<User> getUsersFromFile() {
		List<User> users = new ArrayList<User>(4);

		String userFromFile = null;

		try {

			File myFile = new File("data.txt");
			FileReader fileReader = new FileReader(myFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((userFromFile = bufferedReader.readLine()) != null) {

				System.out.println(userFromFile);
				String[] userData = userFromFile.split(",");

				User user = new User();
				user.setUsername(userData[0]);
				user.setPassword(userData[1]);
				user.setFullName(userData[2]);

				users.add(user);
			}
			bufferedReader.close();
		} catch (Exception ex) {
			System.out.println("Oops Somehting is wrong reading the text file");
			ex.printStackTrace();
		}

		return users;
	}

}
