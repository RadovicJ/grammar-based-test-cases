package com.example.rules;

import com.example.client.EvalInterface;
import com.example.client.Statement;
import com.example.subrules.ParenExpr;

import java.util.Random;

public class IfStatement implements EvalInterface {

    private final int depth;
    static final Random RNG = new Random();

    public IfStatement(int depth) {
        this.depth = depth;
    }

    @Override
    public String eval() {
        StringBuilder sb = new StringBuilder();
        sb.append("if ").append(new ParenExpr(depth - 1).eval()).append(' ').append(new Statement(depth - 1).eval());
        if (RNG.nextBoolean())
            sb.append(" else ").append(new Statement(depth - 1).eval());
        return sb.toString();
    }
}
