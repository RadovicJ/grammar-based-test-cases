package com.example.client;

import java.util.Random;

public class Main {

    static final Random RNG = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("- Program " + (i+1) + ": " + new Statement(RNG.nextInt(10)).eval());
        }
    }
}
