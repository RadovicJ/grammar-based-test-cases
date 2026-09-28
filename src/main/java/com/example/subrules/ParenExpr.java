package com.example.subrules;

import com.example.client.EvalInterface;
import com.example.client.Singleton;
import com.example.generators.IdGenerator;

import java.util.ArrayList;

public class ParenExpr implements EvalInterface {

    @Override
    public ArrayList<Integer> eval() {
        ArrayList<Integer> list = new ArrayList<>();
        Singleton instance = Singleton.getInstance();
        ArrayList<Integer> expr_list = new Expr(false).eval();

        for (int expr_index : expr_list) {
            String expr_string = " (" + Singleton.getInstance().map.get(expr_index) + ") ";
            instance.map.put(expr_index, expr_string);
            list.add(expr_index);
        }
        return list;
    }
}
