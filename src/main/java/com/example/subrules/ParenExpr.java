package com.example.subrules;

import com.example.client.EvalInterface;

import java.util.ArrayList;

public class ParenExpr implements EvalInterface {

    @Override
    public ArrayList<Object> eval() {
        ArrayList<Object> list = new ArrayList<>();
        list.add("(" + new Expr(false).eval() + ")");
        return list;
    }
}
