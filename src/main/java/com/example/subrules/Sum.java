package com.example.subrules;

import com.example.client.EvalInterface;
import com.example.client.Singleton;

import java.util.ArrayList;

public class Sum implements EvalInterface {

    private final boolean visited;
    private final boolean visitedTerm;

    public Sum(boolean visited, boolean visitedTerm) {
        this.visited = visited;
        this.visitedTerm = visitedTerm;
    }

    @Override
    public ArrayList<Integer> eval() {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> term_list = new Term(visitedTerm).eval();
        Singleton instance = Singleton.getInstance();

        for (int term_index : term_list) {
            String term_string = Singleton.getInstance().map.get(term_index);
            instance.map.put(instance.value, term_string);
            list.add(instance.value);
            Singleton.increment();
        }

        if (!visited) {
            ArrayList<Integer> sum_list = new Sum(true, visitedTerm).eval();

            for (Integer integer : sum_list) {
                for (Integer value : term_list) {
                    int sum_index = integer;
                    int term_index = value;

                    String sum_string = Singleton.getInstance().map.get(sum_index) + " + " + Singleton.getInstance().map.get(term_index);
                    instance.map.put(instance.value, sum_string);
                    list.add(instance.value);
                    Singleton.increment();

                    sum_string = Singleton.getInstance().map.get(sum_index) + " - " + Singleton.getInstance().map.get(term_index);
                    instance.map.put(instance.value, sum_string);
                    list.add(instance.value);
                    Singleton.increment();
                }
            }
        }

        return list;
    }
}
