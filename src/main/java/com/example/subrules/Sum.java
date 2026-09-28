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

        if (!visited) {
            ArrayList<Integer> list = new ArrayList<>();
            Singleton instance = Singleton.getInstance();
            ArrayList<Integer> sum_list = new Sum(true).eval();
            for (int i = 0; i < sum_list.size(); i++) {
                for (int j = 0; j < term_list.size(); j++) {
                    int sum_index = sum_list.get(i);
                    int term_index = term_list.get(j);

                    String sum_string = Singleton.getInstance().map.get(sum_index) + " + " +  Singleton.getInstance().map.get(term_index);
                    instance.map.put(sum_index, sum_string);
                    list.add(sum_index);

                    sum_string = Singleton.getInstance().map.get(sum_index) + " - " +  Singleton.getInstance().map.get(term_index);
                    instance.map.put(term_index, sum_string);
                    list.add(term_index);
                }
            }
            term_list = list;
        }

        return term_list;
    }
}
