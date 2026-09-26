package com.example.rules;

import com.example.client.EvalInterface;
import com.example.client.Statement;
import com.example.subrules.ParenExpr;

import java.util.ArrayList;

public class WhileStatement implements EvalInterface {

    private final int level;

    public WhileStatement(int level) {
        this.level = level;
    }

    @Override
    public ArrayList<Object> eval() {
        ArrayList<Object> list = new ArrayList<>();
        list.add("while " + new ParenExpr().eval() + " " + new Statement(level + 1).eval());
        return list;
    }
}
