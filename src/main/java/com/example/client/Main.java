package com.example.client;

import com.example.subrules.Test;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new Test(false).eval();
        for (Integer testCaseIndex : list) {
            String testCaseString = Singleton.getInstance().map.get(testCaseIndex);
            System.out.println(testCaseString);
        }
    }
}
