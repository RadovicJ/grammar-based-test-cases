package com.example.rules;

import com.example.client.EvalInterface;
import com.example.client.Statement;
import com.example.subrules.ParenExpr;

public class WhileStatement implements EvalInterface {

    private final int depth;

    public WhileStatement(int depth) {
        this.depth = depth;
    }

    @Override
    public String eval() {
        return "while " + new ParenExpr(depth - 1).eval() + " " + new Statement(depth - 1).eval();
    }
}
