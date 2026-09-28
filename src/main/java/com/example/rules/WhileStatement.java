package com.example.rules;

import com.example.client.EvalInterface;
import com.example.client.Singleton;
import com.example.client.Statement;
import com.example.subrules.ParenExpr;

import java.util.ArrayList;

public class WhileStatement implements EvalInterface {

    private final int level;

    public WhileStatement(int level) {
        this.level = level;
    }

    @Override
    public ArrayList<Integer> eval() {
        ArrayList<Integer> list = new ArrayList<>();
        Singleton instance = Singleton.getInstance();
        ArrayList<Integer> paren_expr_list = new ParenExpr(false).eval();
        ArrayList<Integer> statement_list = new Statement(level + 1).eval();

        for (int paren_expr_index : paren_expr_list) {
            for (int statement_index : statement_list) {
                String paren_expr_string = Singleton.getInstance().map.get(paren_expr_index);
                String statement_string = Singleton.getInstance().map.get(statement_index);
                String whileCombined = "while " + paren_expr_string + " " + statement_string;
                instance.map.put(instance.value, whileCombined);
                list.add(instance.value);
                Singleton.increment();
            }
        }

        return list;
    }
}
