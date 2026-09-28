package com.example.subrules;

import com.example.client.EvalInterface;
import com.example.client.Singleton;
import com.example.generators.IdGenerator;

import java.util.ArrayList;

public class Expr implements EvalInterface {

    private final boolean visited;
    private final boolean visitedTerm;

    public Expr(boolean visited, boolean visitedTerm) {
        this.visited = visited;
        this.visitedTerm = visitedTerm;
    }

    @Override
    public ArrayList<Integer> eval() {
        Singleton instance = Singleton.getInstance();

        ArrayList<Integer> test_list = new Test(visitedTerm).eval();
        ArrayList<Integer> list = new ArrayList<>(test_list);

        if (!visited) {
            ArrayList<Integer> expr_list = new Expr(true, visitedTerm).eval();
            for (int expr_index : expr_list) {
                int id_index = new IdGenerator().eval().get(0);
                String expr_string = Singleton.getInstance().map.get(id_index) + " = " + Singleton.getInstance().map.get(expr_index);
                instance.map.put(instance.value, expr_string);
                list.add(instance.value);
                Singleton.increment();

            }
        }

        return list;
    }
}
