import java.util.Scanner;

public class main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean isLoggedIn = false;
        int command = 0;
        while(command != 5) {
            if(!isLoggedIn) {
                //TODO Implement Open Account
                System.out.print("Username:");
                String username = scanner.next();
                System.out.println(username);
                System.out.print("Password:");
                String password = scanner.next();
                System.out.println(password);
                //TODO authenticate user
                isLoggedIn = authenticate(username, password);
            } else {
                String console = "Choose what you wanna do? \n1. View Balance \n2. Deposit Amount \n3. Purchase Item \n4. Close Account \n5. Exit \nHit that number:";
                System.out.print(console);
                command = scanner.nextInt();
                switch(command) {
                    case 1:
                        System.out.println("You are viewing balance");
                        continu();
                        break;
                    case 2:
                        System.out.println("You deposited amount");
                        continu();
                        break;
                    case 3:                        
                        System.out.println("You purchased some crap");                    
                        continu();
                        break;
                    case 4: 
                        System.out.println("You closed the account");
                        continu();
                        break;
                    case 5:
                        break;
                    default:                        
                        continu();
                }
            }
        }
    }
    private static boolean authenticate(String username, String password) {
        //TODO implement auth
        return true;
    }
    
    private static void continu() {
        System.out.println("\n\nHit Enter to continue...");
        scanner.nextLine();
        scanner.nextLine();
    }

}
