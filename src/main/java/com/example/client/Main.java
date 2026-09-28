package com.example.client;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new Statement(0).eval();
        for (Integer testCaseIndex : list) {
            String testCaseString = Singleton.getInstance().map.get(testCaseIndex);
            System.out.println(testCaseString);
        }
    }
}
