package com.example.generators;

import com.example.client.EvalInterface;

import java.util.Random;

public class IdGenerator implements EvalInterface {

    private static final Random RNG = new Random();

    @Override
    public String eval() {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        int size = RNG.nextInt(5) + 1;
        while (sb.length() < size) {
            int index = (int) (RNG.nextFloat() * chars.length());
            sb.append(chars.charAt(index));
        }
        String var = sb.toString();
        if (var.equals("if")) {
            return "x";
        } else if (var.equals("while")) {
            return "y";
        }
        return var;
    }
}
