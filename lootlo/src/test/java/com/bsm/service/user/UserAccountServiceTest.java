package com.bsm.service.user;

import com.bsm.entity.user.UserEntity;
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

    private static UserEntity testuser;

    @Before
    public void before() throws Exception {
        String username = "testuser";
        String password = "testpass";
        long openingBalance = 1000;
        testuser =  UserAccountService.openAccount(username, password, openingBalance);
    }

    @After
    public void after() throws Exception {
        UserAccountService.closeAccount(testuser);
    }

    /**
    *
    * Method: viewBalance(UserEntity user)
    *
    */
    @Test
    public void testViewBalance() throws Exception {
        long balance = UserAccountService.viewBalance(testuser);
        Assert.assertEquals(balance, 1000);
    }

    /**
    *
    * Method: deposit(UserEntity user, long amount)
    *
    */
    @Test
    public void testDeposit() throws Exception {
        UserAccountService.deposit(testuser, 1000);
        long balance = UserAccountService.viewBalance(testuser);
        Assert.assertEquals(balance, 2000);
    }

    /**
    *
    * Method: purchase(long price)
    *
    */
    @Test
    public void testPurchase() throws Exception {
        long price = 500;
        UserAccountService.purchase(testuser, price);
        long balance = UserAccountService.viewBalance(testuser);
        Assert.assertEquals(balance, 500);
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
