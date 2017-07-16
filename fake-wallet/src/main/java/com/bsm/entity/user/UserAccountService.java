package com.bsm.entity.user;

import java.util.List;

/**
* This Service is an API/Interface service for the
* client to interact with the business layer/domain objects
*/
public class UserAccountService {
    
    //TODO Factory for User    

    public static long viewBalance(User user) {
        return user.getBalance();
    }

    public static void deposit(User user, long amount) throws Exception {
        //TODO Aspects to implement authentication on each transaction
        getAuthenticatedUser(user).deposit(amount);
    }

    public void purchase(long price) {
        throw new UnsupportedOperationException("To do! Implement this shit!");
    }
    
    public void closeAccount() {
        throw new UnsupportedOperationException("To do! Implement this shit!");
    }

    public void openAccount(long deposit) {
        throw new UnsupportedOperationException("To do! Implement this shit!");
    }

    public static User getAuthenticatedUser(String username, String password) throws Exception {
        User user = new User(username, password);
        return user.authenticate() ? user : null;
    }

    private static User getAuthenticatedUser(User user) throws Exception {
        return user.authenticate() ? user : null;
    }

    public String toString(User user) {
        return user.toString();        
    }

}
