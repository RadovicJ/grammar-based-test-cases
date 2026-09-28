package com.example.subrules;

import com.example.client.EvalInterface;
import com.example.client.Singleton;

import java.util.ArrayList;

public class Test implements EvalInterface {

    private final boolean visitedTerm;

    public Test(boolean visitedTerm) {
        this.visitedTerm = visitedTerm;
    }

    @Override
    public ArrayList<Integer> eval() {
        ArrayList<Integer> list = new ArrayList<>();
        Singleton instance = Singleton.getInstance();
        ArrayList<Integer> sum_list = new Sum(false, visitedTerm).eval();
        ArrayList<Integer> sum_list2 = new Sum(false, visitedTerm).eval();

        for (int sum_index : sum_list) {
            String sum_string = Singleton.getInstance().map.get(sum_index);

            for (int sum_index2 : sum_list2) {
                String sum_string2 = Singleton.getInstance().map.get(sum_index2);
                String sumCombined = sum_string + " < " + sum_string2;

                instance.map.put(instance.value, sumCombined);
                list.add(instance.value);
                Singleton.increment();

            }
            instance.map.put(instance.value, sum_string);
            list.add(instance.value);
            Singleton.increment();
        }

        return list;
    }
}
