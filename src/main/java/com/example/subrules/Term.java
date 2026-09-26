package com.example.subrules;

import com.example.client.EvalInterface;
import com.example.client.Singleton;
import com.example.generators.IdGenerator;
import com.example.generators.IntegerGenerator;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;

public class Term implements EvalInterface {

    private boolean visited = false;

    @Override
    public ArrayList<Integer> eval() {
        int id_index = new IdGenerator().eval().get(0);
        String id = Singleton.getInstance().map.get(id_index);
        int integer_index = new IdGenerator().eval().get(0);
        String integer = Singleton.getInstance().map.get(integer_index);
//        if (!visited) {
//            list.add(new ParenExpr().eval());
//            visited = true;
//        }

        ArrayList<Integer> list = new ArrayList<>();
        Singleton instance = Singleton.getInstance();

        instance.map.put(instance.value, id);
        list.add(instance.value);
        Singleton.increment();

        instance.map.put(instance.value, integer);
        list.add(instance.value);
        Singleton.increment();

//        instance.map.put(instance.value, number);
//        list.add(instance.value);
//        Singleton.increment();
        return list;
    }
}
