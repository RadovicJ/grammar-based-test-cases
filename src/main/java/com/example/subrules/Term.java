package com.example.subrules;

import com.example.client.EvalInterface;
import com.example.client.Singleton;
import com.example.generators.IdGenerator;
import com.example.generators.IntegerGenerator;

import java.util.ArrayList;

public class Term implements EvalInterface {

    private final boolean visitedTerm;

    public Term(boolean visitedTerm) {
        this.visitedTerm = visitedTerm;
    }

    @Override
    public ArrayList<Integer> eval() {
        int id_index = new IdGenerator().eval().get(0);
        String id = Singleton.getInstance().map.get(id_index);
        int integer_index = new IntegerGenerator().eval().get(0);
        String integer = Singleton.getInstance().map.get(integer_index);

        ArrayList<Integer> list = new ArrayList<>();
        Singleton instance = Singleton.getInstance();

        instance.map.put(instance.value, id);
        list.add(instance.value);
        Singleton.increment();

        instance.map.put(instance.value, integer);
        list.add(instance.value);
        Singleton.increment();

        if (!visitedTerm) {
            ArrayList<Integer> paren_expr_list = new ParenExpr(true).eval();
            for (int paren_expr_index : paren_expr_list) {
                String paren_expr_string = Singleton.getInstance().map.get(paren_expr_index);
                instance.map.put(instance.value, paren_expr_string);
                list.add(instance.value);
                Singleton.increment();
            }
        }

        return list;
    }
}
