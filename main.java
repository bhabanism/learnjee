import java.util.Scanner;

public class main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            boolean isLoggedIn = false;
            int command = 0;
            User user = null;
            while(command != 5) {
                if(!isLoggedIn) {
                    //TODO Implement Open Account
                    System.out.print("Username:");
                    String username = scanner.next();
                    System.out.print("Password:");
                    String password = scanner.next();
                    user = new User(username, password);
                    isLoggedIn = user.authenticate();
                } else {
                    String console = "Choose what you wanna do? \n1. View Balance \n2. Deposit Amount \n3. Purchase Item \n4. Close Account \n5. Exit \nHit that number:";
                    System.out.print(console);
                    command = scanner.nextInt();
                    switch(command) {
                        case 1:
                            System.out.println("The balance is : "+ user.viewBalance());
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
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void continu() {
        System.out.println("\n\nHit Enter to continue...");
        scanner.nextLine();
        scanner.nextLine();
    }

}
