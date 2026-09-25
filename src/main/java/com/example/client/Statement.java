package com.example.client;

import com.example.rules.BlockStatement;
import com.example.rules.ExprStatement;
import com.example.rules.IfStatement;
import com.example.rules.WhileStatement;

import java.util.Random;

public class Statement implements EvalInterface {

    private final int depth;
    static final Random RNG = new Random();

    public Statement(int depth) {
        this.depth = depth;
    }

    @Override
    public String eval() {
        switch (RNG.nextInt(4)) {
            case 0: return new IfStatement(depth).eval();
            case 1: return new WhileStatement(depth).eval();
            case 2: return new BlockStatement(depth).eval();
            default: return new ExprStatement(depth).eval();
        }
    }
}
