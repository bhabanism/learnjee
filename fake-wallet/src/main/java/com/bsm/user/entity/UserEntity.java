package com.bsm.user.entity;

import com.bsm.user.dataaccess.UserDataUtil;

import java.util.List;
import java.util.ArrayList;


public class UserEntity {
    private String username;
    private String password;
    private long balance;

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getBalance() {
        return this.balance;
    }
    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void deposit(long amount) throws Exception {
        this.balance += amount;
        modifyBalanceAndupdateAllUsers();
    }

    public void purchase(long price) throws Exception {
        this.balance -= price;
        modifyBalanceAndupdateAllUsers();
    }


    public long closeAccount() throws Exception {
        deleteUserAndUpdateAllUsers();
        long balance = this.balance;
        this.balance = 0;
        return balance;
    }

    public void openAccount(long openingBalance) throws Exception {
        this.balance = openingBalance;
        List<UserEntity> allUsers = UserDataUtil.getAllUsersFromDB();
        allUsers.add(this);
        UserDataUtil.setAllUsers(allUsers);
        updateAllUsers();
    }

    public boolean authenticate() throws Exception {
        List<UserEntity> list = UserDataUtil.getAllUsersFromDB();
        for(UserEntity user : list) {
            if(isUserValid(user)) {
                this.setBalance(user.getBalance());
                return true;
            }
        }
        return false;
    }

    private boolean isUserValid(UserEntity user) {
        return user.username.equals(this.username) && user.password.equals(this.password);
    }


    private void deleteUserAndUpdateAllUsers() throws Exception {
        List<UserEntity> userlist = UserDataUtil.getAllUsersFromDB();
        List<String> list = new ArrayList<String>();
        for(UserEntity user : userlist) {
            if(!this.username.equalsIgnoreCase(user.username)) {
                list.add(user.toString());
            }
        }
        UserDataUtil.updateAllUsers(list);
    }

    private void updateAllUsers() throws Exception {
        List<UserEntity> userlist = UserDataUtil.getAllUsers();
        List<String> list = new ArrayList<String>();
        for(UserEntity user : userlist) {
            list.add(user.toString());
        }
        UserDataUtil.updateAllUsers(list);
    }

    @Deprecated
    private void modifyBalanceAndupdateAllUsers() throws Exception {
        List<UserEntity> userlist = UserDataUtil.getAllUsersFromDB();
        List<String> list = new ArrayList<>();
        for(UserEntity user : userlist) {
            if(this.username.equalsIgnoreCase(user.username)) {
                user.setBalance(this.balance);
            }
            list.add(user.toString());
        }
        UserDataUtil.updateAllUsers(list);
    }

    public String toString() {
        return this.username + " " + this.password + " " + this.balance;
    }

}
