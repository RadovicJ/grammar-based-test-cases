package com.example.subrules;

import com.example.client.EvalInterface;
import com.example.client.Singleton;

import java.util.ArrayList;

public class ParenExpr implements EvalInterface {

    private final boolean visitedTerm;

    public ParenExpr(boolean visitedTerm) {
        this.visitedTerm = visitedTerm;
    }

    @Override
    public ArrayList<Integer> eval() {
        ArrayList<Integer> list = new ArrayList<>();
        Singleton instance = Singleton.getInstance();
        if (Singleton.references.getParen_expr_reference() != null) {
            return Singleton.references.getParen_expr_reference();
        }

        ArrayList<Integer> expr_list = new Expr(false, visitedTerm).eval();

        for (int expr_index : expr_list) {
            String expr_string = " (" + Singleton.getInstance().map.get(expr_index) + ") ";
            instance.map.put(instance.value, expr_string);
            list.add(instance.value);
            Singleton.increment();
        }

        Singleton.references.setParen_expr_reference(list);

        return list;
    }
}
