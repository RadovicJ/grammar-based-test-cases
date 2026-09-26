package com.example.rules;

import com.example.client.EvalInterface;
import com.example.client.Statement;
import com.example.subrules.ParenExpr;

import java.util.ArrayList;
import java.util.Random;

public class IfStatement implements EvalInterface {

    static final Random RNG = new Random();
    private final int level;

    public IfStatement(int level) {
        this.level = level;
    }

    @Override
    public ArrayList<Object> eval() {
        ArrayList<Object> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("if ").append(new ParenExpr().eval()).append(' ').append(new Statement(level + 1).eval());
        if (RNG.nextBoolean())
            sb.append(" else ").append(new Statement(level + 1).eval());
        list.add(sb.toString());
        return list;
    }
}
