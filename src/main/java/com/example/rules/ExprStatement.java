package com.example.rules;

import com.example.client.EvalInterface;
import com.example.subrules.Expr;

public class ExprStatement implements EvalInterface {

    private final int depth;

    public ExprStatement(int depth) {
        this.depth = depth;
    }

    @Override
    public String eval() {
        return new Expr(depth).eval() + ";";
    }
}
