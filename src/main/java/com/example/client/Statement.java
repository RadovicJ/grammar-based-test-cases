package com.example.client;

import com.example.rules.BlockStatement;
import com.example.rules.ExprStatement;
import com.example.rules.IfStatement;
import com.example.rules.WhileStatement;

import java.util.ArrayList;

public class Statement implements EvalInterface {

    private final int level;

    public Statement(int level) {
        this.level = level;
    }

    @Override
    public ArrayList<Integer> eval() {
        ArrayList<Integer> list = new ArrayList<>();
        if (level < 2) {
            list.addAll(new IfStatement(level).eval());
            list.addAll(new WhileStatement(level).eval());
            list.addAll(new BlockStatement(level).eval());
        }
        list.addAll(new ExprStatement().eval());
        return list;
    }
}
