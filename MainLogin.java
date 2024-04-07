import java.util.*;

class MainLogin {
	
    private static final int MAX_LOGIN_ATTEMPTS = 3;
    private static final String VALID_PASSWORD = "password";
    private int loginAttempts;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainLogin authenticationManager = new MainLogin();

        while (true) {
            try {
            	
                System.out.println("Enter username to log in.");
                System.out.println("Username: ");
                String username = scanner.nextLine();
                
                System.out.print("Password: ");
                String password = scanner.nextLine();

                authenticationManager.logAccess(username, password);
                break;
            } catch (MaxLoginAttempts e) {
                System.out.println(e.getMessage());
                break;
            } catch (InvalidPassword e) {
                System.out.println(e.getMessage() + "\nPlease Try Again.\n");
            }
        }
        scanner.close();
    }
    
    public MainLogin() {
        this.loginAttempts = 0;
    }

    public void logAccess(String username, String password) throws MaxLoginAttempts, InvalidPassword {
        if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
            throw new MaxLoginAttempts("Maximum login attempts reached!");
        }

        if (!password.equals(VALID_PASSWORD)) {
            loginAttempts++;
            if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
                throw new MaxLoginAttempts("Maximum login attempts reached!");
            }
            throw new InvalidPassword("Invalid Password");
        }
        loginAttempts = 0;
        System.out.println("Hello " + username + " you are logged in successfully.");
    }
}
