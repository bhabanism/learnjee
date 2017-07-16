package com.bsm.user.service;

import com.bsm.user.entity.UserEntity;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.Assert;

/** 
* UserAccountService Tester. 
* 
* @author <Authors name> 
* @since <pre>Jul 16, 2017</pre> 
* @version 1.0 
*/ 
public class UserAccountServiceTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: viewBalance(UserEntity user)
    *
    */
    @Test
    public void testViewBalance() throws Exception {
        String username = "testuser";
        String password = "testpass";
        UserEntity user =  UserAccountService.getAuthenticatedUser(username, password);
        long balance = UserAccountService.viewBalance(user);
        Assert.assertEquals(balance, 1000);
    }

    /**
    *
    * Method: deposit(UserEntity user, long amount)
    *
    */
    @Test
    public void testDeposit() throws Exception {
        String username = "testuser";
        String password = "testpass";
        UserEntity user =  UserAccountService.getAuthenticatedUser(username, password);
        UserAccountService.deposit(user, 1000);
        long balance = UserAccountService.viewBalance(user);
        Assert.assertEquals(balance, 2000);
    }

    /**
    *
    * Method: purchase(long price)
    *
    */
    @Test
    public void testPurchase() throws Exception {
        String username = "testuser";
        String password = "testpass";
        UserEntity user =  UserAccountService.getAuthenticatedUser(username, password);
        long price = 500;
        UserAccountService.purchase(user, price);
        long balance = UserAccountService.viewBalance(user);
        Assert.assertEquals(balance, 1500);
    }

    /**
    *
    * Method: closeAccount()
    *
    */
    @Test
    public void testCloseAccount() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: openAccount(long deposit)
    *
    */
    @Test
    public void testOpenAccount() throws Exception {
        String username = "testuser";
        String password = "testpass";
        long openingBalance = 100;
        UserEntity user =  UserAccountService.openAccount(username, password, openingBalance);
    }

    /**
    *
    * Method: toString(UserEntity user)
    *
    */
    @Test
    public void testToString() throws Exception {
    //TODO: Test goes here...
    }


    /**
    *
    * Method: getAuthenticatedUser(UserEntity user)
    *
    */
    @Test
    public void testGetAuthenticatedInvalidUser() throws Exception {
        String username = "testuser";
        String password = "testfail";
        UserEntity user =  UserAccountService.getAuthenticatedUser(username, password);
        Assert.assertNull(user);
    }

    /**
     *
     * Method: getAuthenticatedUser(UserEntity user)
     *
     */
    @Test
    public void testGetAuthenticatedValidUser() throws Exception {
        String username = "testuser";
        String password = "testpass";
        UserEntity user =  UserAccountService.getAuthenticatedUser(username, password);
        Assert.assertNotNull(user);
    }

} 
