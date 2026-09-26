package com.example.subrules;

import com.example.client.EvalInterface;
import com.example.client.Singleton;
import com.example.generators.IdGenerator;

import java.util.ArrayList;

public class Sum implements EvalInterface {

    private final boolean visited;

    public Sum(boolean visited) {
        this.visited = visited;
    }

    @Override
    public ArrayList<Integer> eval() {
        ArrayList<Integer> term_list = new Term().eval();

        ArrayList<Integer> list = new ArrayList<>();
        Singleton instance = Singleton.getInstance();
        for (int i = 0; i < term_list.size(); i++) {
            int id_index = term_list.get(i);
            String term_string = Singleton.getInstance().map.get(id_index);

            instance.map.put(instance.value, term_string);
            list.add(instance.value);
            Singleton.increment();
        }

//        list.add(new Term().eval());
        if (!visited) {
            ArrayList<Integer> sum_list = new Sum(true).eval();
            for (int i = 0; i < sum_list.size(); i++) {
                for (int j = 0; j < term_list.size(); j++) {
                    int sum_index = sum_list.get(i);
                    int term_index = term_list.get(j);

                    String sum_string = Singleton.getInstance().map.get(sum_index) + " + " +  Singleton.getInstance().map.get(term_index);
                    instance.map.put(instance.value, sum_string);
                    list.add(instance.value);
                    Singleton.increment();

                    sum_string = Singleton.getInstance().map.get(sum_index) + " - " +  Singleton.getInstance().map.get(term_index);
                    instance.map.put(instance.value, sum_string);
                    list.add(instance.value);
                    Singleton.increment();
                }
            }
            String plus = new Sum(true).eval() + " + " + new Term().eval();
            instance.map.put(instance.value, plus);
            list.add(instance.value);
            Singleton.increment();

            String minus = new Sum(true).eval() + " - " + new Term().eval();
            instance.map.put(instance.value, minus);
            list.add(instance.value);
            Singleton.increment();
        }
        return list;
    }
}
