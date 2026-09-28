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
        int integer_index = new IntegerGenerator().eval().get(0);
        String integer = Singleton.getInstance().map.get(integer_index);
//        if (!visited) {
//            list.add(new ParenExpr().eval());
//            visited = true;
//        }

        ArrayList<Integer> list = new ArrayList<>();
        Singleton instance = Singleton.getInstance();

        instance.map.put(id_index, id);
        list.add(id_index);

        instance.map.put(integer_index, integer);
        list.add(integer_index);

//        instance.map.put(instance.value, number);
//        list.add(instance.value);
//        Singleton.increment();
        return list;
    }
}
