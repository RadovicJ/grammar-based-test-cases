package com.example.subrules;

import com.example.client.EvalInterface;

public class Test implements EvalInterface {

    private final int depth;

    public Test(int depth) {
        this.depth = depth;
    }

    @Override
    public String eval() {
        if (depth <= 0) return new Sum(depth).eval();
        return new Sum(depth - 1).eval() + " < " + new Sum(depth - 1).eval();
    }
}
