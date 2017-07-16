package com.bsm.user.service;

import com.bsm.user.entity.UserEntity;

/**
* This Service is an API/Interface service for the
* client to interact with the business layer/domain objects
*/
public class UserAccountService {
    
    //TODO Factory for User    

    public static long viewBalance(UserEntity user) {
        return user.getBalance();
    }

    public static void deposit(UserEntity user, long amount) throws Exception {
        //TODO Aspects to implement authentication on each transaction
        getAuthenticatedUser(user).deposit(amount);
    }

    public static void purchase(UserEntity user, long price) throws Exception {
        //TODO Aspects to implement authentication on each transaction
        getAuthenticatedUser(user).purchase(price);
    }
    
    public static long closeAccount(UserEntity user) throws Exception {
        long balance = user.closeAccount();
        user = null;
        return balance;
    }

    public void openAccount(UserEntity user, long deposit) {
        throw new UnsupportedOperationException("To do! Implement this shit!");
    }

    public static UserEntity getAuthenticatedUser(String username, String password) throws Exception {
        UserEntity user = new UserEntity(username, password);
        return user.authenticate() ? user : null;
    }

    private static UserEntity getAuthenticatedUser(UserEntity user) throws Exception {
        return user.authenticate() ? user : null;
    }

    public String toString(UserEntity user) {
        return user.toString();        
    }

}
