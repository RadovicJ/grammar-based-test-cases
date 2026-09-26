package com.example.rules;

import com.example.client.EvalInterface;
import com.example.subrules.Expr;

import java.util.ArrayList;

public class ExprStatement implements EvalInterface {

    @Override
    public ArrayList<Object> eval() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(new Expr(false).eval() + ";");
        return list;
    }
}
