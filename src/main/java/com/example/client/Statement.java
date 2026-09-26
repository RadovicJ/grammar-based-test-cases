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
    public ArrayList<Object> eval() {
        if (level == 2) {
            return null;
        }
        ArrayList<Object> list = new ArrayList<>();
        list.add(new IfStatement(level).eval());
//        list.add(new WhileStatement().eval());
//        list.add(new BlockStatement().eval());
//        list.add(new ExprStatement().eval());
        return list;
    }
}
