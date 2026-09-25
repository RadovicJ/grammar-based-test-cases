package com.example.subrules;

import com.example.client.EvalInterface;

public class ParenExpr implements EvalInterface {

    private final int depth;

    public ParenExpr(int depth) {
        this.depth = depth;
    }

    @Override
    public String eval() {
        return "(" + new Expr(depth - 1).eval() + ")";
    }
}
