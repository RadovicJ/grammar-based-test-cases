package com.example.subrules;

import com.example.client.EvalInterface;
import com.example.generators.IdGenerator;

import java.util.ArrayList;

public class Expr implements EvalInterface {

    private final boolean visited;

    public Expr(boolean visited) {
        this.visited = visited;
    }

    @Override
    public ArrayList<Object> eval() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(new Test().eval());
        if (!visited) {
            list.add(new IdGenerator().eval() + " = " + new Expr(true).eval());
        }
        return list;
    }
}
