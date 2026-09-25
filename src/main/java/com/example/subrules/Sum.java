package com.example.subrules;

import com.example.client.EvalInterface;

import java.util.Random;

public class Sum implements EvalInterface {

    private final int depth;
    static final Random RNG = new Random();

    public Sum(int depth) {
        this.depth = depth;
    }

    @Override
    public String eval() {
        if (depth <= 0) return new Term().eval();
        return new Sum(depth - 1).eval() + (RNG.nextBoolean() ? " + " : " - ") + new Term().eval();
    }
}
