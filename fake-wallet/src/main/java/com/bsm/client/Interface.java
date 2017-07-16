package com.bsm.client;

import com.bsm.user.entity.UserEntity;
import com.bsm.user.service.UserAccountService;

import java.util.Scanner;

public class Interface {
    private static Scanner scanner = new Scanner(System.in);
    public static void main() {
        try {
            boolean isLoggedIn = false;
            int command = 0;
            UserEntity user = null;
            while(command != 5) {
                if(user == null) {
                    //TODO Implement Open Account
                    System.out.print("Username:");
                    String username = scanner.next();
                    System.out.print("Password:");
                    String password = scanner.next();  
                    user =  UserAccountService.getAuthenticatedUser(username, password);
                    if(user == null) {
                        System.out.println("Invalid Login, try again!");
                    }
                } else {
                    String console = "Choose what you wanna do? \n1. View Balance \n2. Deposit Amount \n3. Purchase Item \n4. Close Account \n5. Exit \nChoose a number:";
                    System.out.print(console);
                    command = scanner.nextInt();
                    switch(command) {
                        case 1:
                            System.out.println("The balance is : "+ UserAccountService.viewBalance(user));
                            continu();
                            break;
                        case 2:
                            System.out.print("Enter amount to deposit:");
                            UserAccountService.deposit(user, scanner.nextInt());
                            continu();
                            break;
                        case 3:
                            System.out.print("Enter price of item:");
                            UserAccountService.purchase(user, scanner.nextInt());
                            continu();
                            break;
                        case 4: 
                            System.out.println("You closed the account");
                            /*long withdrawAmount = UserAccountService.viewBalance(user);
                            UserAccountService.purchase(user, withdrawAmount);*/
                            System.out.println("Here's $" + UserAccountService.closeAccount(user) + "! That's all you had! Thanks for being with us!");
                            continu();
                            return;
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
    }

}
