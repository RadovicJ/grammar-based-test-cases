package com.example.rules;

import com.example.client.EvalInterface;
import com.example.client.Singleton;
import com.example.subrules.Expr;

import java.util.ArrayList;

public class ExprStatement implements EvalInterface {

    @Override
    public ArrayList<Integer> eval() {
        ArrayList<Integer> list = new ArrayList<>();
        Singleton instance = Singleton.getInstance();
        if (Singleton.references.getExpr_reference() != null) {
            return Singleton.references.getExpr_reference();
        }

        ArrayList<Integer> expr_list = new Expr(false, false).eval();

        for (int expr_index : expr_list) {
            String expr_string = Singleton.getInstance().map.get(expr_index) + "; ";
            instance.map.put(expr_index, expr_string);
            list.add(expr_index);
        }

        Singleton.references.setExpr_reference(list);
        return list;
    }
}
