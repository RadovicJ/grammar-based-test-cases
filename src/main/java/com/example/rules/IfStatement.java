package com.example.rules;

import com.example.client.EvalInterface;
import com.example.client.Singleton;
import com.example.client.Statement;
import com.example.subrules.ParenExpr;

import java.util.ArrayList;

public class IfStatement implements EvalInterface {

    private final int level;

    public IfStatement(int level) {
        this.level = level;
    }

    @Override
    public ArrayList<Integer> eval() {

        ArrayList<Integer> list = new ArrayList<>();
        Singleton instance = Singleton.getInstance();
        ArrayList<Integer> paren_expr_list = new ParenExpr(false).eval();

        ArrayList<Integer> statement_if_list = new Statement(level + 1).eval();
        ArrayList<Integer> statement_else_list = new Statement(level + 1).eval();

        for (int paren_expr_index : paren_expr_list) {

            String paren_expr_string = Singleton.getInstance().map.get(paren_expr_index);
            int i = 0;
            for (int statement_if_index : statement_if_list) {
                String statement_if_string = Singleton.getInstance().map.get(statement_if_index);
                String ifCombined = "if " + paren_expr_string + " " + statement_if_string;
                instance.map.put(instance.value, ifCombined);
                list.add(instance.value);
                Singleton.increment();

                int statement_else_index = statement_else_list.get(i);
                String statement_else_string = Singleton.getInstance().map.get(statement_else_index);
                String elseCombined = ifCombined + " " + statement_else_string;
                instance.map.put(instance.value, elseCombined);
                list.add(instance.value);
                Singleton.increment();
                i++;
            }
        }

        return list;
    }
}
