package com.example.subrules;

import com.example.client.EvalInterface;
import com.example.client.Singleton;

import java.util.ArrayList;

public class Test implements EvalInterface {

    @Override
    public ArrayList<Integer> eval() {
        ArrayList<Integer> list = new ArrayList<>();
        Singleton instance = Singleton.getInstance();
        ArrayList<Integer> sum_list = new Sum(false).eval();
        ArrayList<Integer> sum_list2 = new Sum(false).eval();

        for (int i = 0; i < sum_list.size(); i++) {
            int sum_index = sum_list.get(i);

            String sum_string = Singleton.getInstance().map.get(sum_index);
            instance.map.put(sum_index, sum_string);
            list.add(sum_index);
        }

        for (int i = 0; i < sum_list2.size(); i++) {
            int sum_index = sum_list.get(i);
            int sum_index2 = sum_list2.get(i);

            String sum_string = Singleton.getInstance().map.get(sum_index);
            String sum_string2 = Singleton.getInstance().map.get(sum_index2);
            String sumCombined = sum_string + " < " + sum_string2;

            instance.map.put(sum_index2, sumCombined);
            list.add(sum_index2);
        }

        return list;
    }
}
