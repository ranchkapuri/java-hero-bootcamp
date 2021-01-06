
public class User implements Comparable<User>  {
	
	
	String username;
	String password;
	String fullName;
	String role;
	
	
	
	public User(String username, String password, String fullName,String role) {
		super();
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.role= role;
	}
	
	public User () {
		
	}
	

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", fullName=" + fullName + ", role=" + role
				+ "]";
	}

	@Override
	public int compareTo(User that) {
		if (this.role.compareTo(that.role)==0) {
		   return this.username.compareTo(that.username);
		}else { 
			return that.role.compareTo(this.role);
		}	
	
	}
	
	
	
}

