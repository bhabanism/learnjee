package com.bsm.client;

import com.bsm.user.entity.UserEntity;
import com.bsm.user.service.UserAccountService;

import java.util.Scanner;

public class Interface {
    private static Scanner scanner = new Scanner(System.in);
    public static void main() {
        try {
            int command = 0;
            UserEntity user = null;
            while(command != 5) {
                if(user == null) {

                    String console = "Choose what you wanna do? \n" +
                     "1. Login \n" +
                      "2. Create Account \n" +
                       "5. Exit \n" +
                        "Choose a number: ";
                    System.out.print(console);
                    command = scanner.nextInt();
                    switch(command) {
                        case 1:
                            user = login();
                            continu();
                            break;
                        case 2:
                            user = createAccount();
                            continu();
                            break;
                        case 5:
                            break;
                        default:
                            continu();
                    }
                    //TODO Implement Open Account

                } else {
                    String console = "Choose what you wanna do? \n" +
                     "1. View Balance \n" +
                      "2. Deposit Amount \n" +
                       "3. Purchase Item \n" +
                        "4. Close Account \n" +
                         "5. Exit \n" +
                          "Choose a number: ";
                    System.out.print(console);
                    command = scanner.nextInt();
                    switch(command) {
                        case 1:
                            System.out.println("The balance is : "+ UserAccountService.viewBalance(user));
                            continu();
                            break;
                        case 2:
                            System.out.print("Enter amount to deposit: ");
                            UserAccountService.deposit(user, scanner.nextInt());
                            continu();
                            break;
                        case 3:
                            System.out.print("Enter price of item: ");
                            UserAccountService.purchase(user, scanner.nextInt());
                            continu();
                            break;
                        case 4: 
                            System.out.println("You closed the account");
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

    private static UserEntity createAccount() throws Exception {
        UserEntity user;
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();
        System.out.println("Enter Opening Balance: ");
        long openingBalance = scanner.nextLong();
        user = UserAccountService.openAccount(username, password, openingBalance);
        return user;
    }

    private static UserEntity login() throws Exception {
        UserEntity user;
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();
        user =  UserAccountService.getAuthenticatedUser(username, password);
        if(user == null) {
            System.out.println("Invalid Login, try again!");
        }
        return user;
    }

    private static void continu() {
        System.out.println("\n\nHit Enter to continue...");
        scanner.nextLine();
    }

}
