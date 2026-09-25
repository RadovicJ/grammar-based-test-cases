package com.example.subrules;

import com.example.client.EvalInterface;
import com.example.generators.IdGenerator;

import java.util.Random;

public class Expr implements EvalInterface {

    static final Random RNG = new Random();
    private final int depth;

    public Expr(int depth) {
        this.depth = depth;
    }

    @Override
    public String eval() {
        switch (RNG.nextInt(2)) {
            case 0: return new Test(depth - 1).eval();
            default: return new IdGenerator().eval() + " = " + new Expr(depth - 1).eval();
        }
    }
}
