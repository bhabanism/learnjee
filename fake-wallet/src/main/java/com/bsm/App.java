package com.bsm;

import com.bsm.client.Interface;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            Interface.main();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
