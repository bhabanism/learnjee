package com.bsm;

import com.bsm.client.Interface;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            Interface.main();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
