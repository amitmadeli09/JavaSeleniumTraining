package course2_MasteryIntermediate;
import java.util.Scanner;
import java.util.LinkedList;


class User{
	private String username;
	private String password;
	
	public User(String username,String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
}
public class AuthenticationSystem {
	private LinkedList<User>userList;
	
	public AuthenticationSystem() {
		userList = new LinkedList<>();
	}
	public void register(String username,String password) {
		User newUser = new User(username,password);
		userList.add(newUser);
		System.out.println("User registered Successfully");
	}
	
	public boolean login(String username,String password) {
		for(User user:userList) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		
		AuthenticationSystem authSystem = new AuthenticationSystem();
		Scanner sc = new Scanner(System.in);
		
		boolean loggedIn = false;
		while(!loggedIn) {
			System.out.println("Choose an option :");
			System.out.println("1. Resgister");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1 : 
				System.out.println("Enter a username :");
				String registerUsername = sc.nextLine();
				
				System.out.println("Enter a password :");
				String registerPassword = sc.nextLine();
				
				authSystem.register(registerUsername, registerPassword);
				break;
				
			case 2: 
				System.out.println("Enter your username :");
				String loginUsername = sc.nextLine();
				
				System.out.println("Enter your password :");
				String loginPassword = sc.nextLine();
				
				if(authSystem.login(loginUsername, loginPassword)) {
					System.out.println("Login Successfully");
					loggedIn = true;
				}else {
					System.out.println("Login Failed");
				}
				break;
			case 3:
				System.out.println("Exiting");
				loggedIn = true;
				break;
			
			default : 
				System.out.println("Invalid Choice. Try Again !");
			}
			
		}
		sc.close();

	}

}
