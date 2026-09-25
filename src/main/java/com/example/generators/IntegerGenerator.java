package com.example.generators;

import com.example.client.EvalInterface;

import java.util.Random;

public class IntegerGenerator implements EvalInterface {

    private static final Random RNG = new Random();

    @Override
    public String eval() {
        return Integer.toString(RNG.nextInt(100));
    }
}
