package com.example.generators;

import com.example.client.EvalInterface;
import com.example.client.Singleton;

import java.util.ArrayList;
import java.util.Random;

public class IntegerGenerator implements EvalInterface {

    private static final Random RNG = new Random();

    @Override
    public ArrayList<Integer> eval() {
        String number = Integer.toString(RNG.nextInt(100));

        ArrayList<Integer> list = new ArrayList<>();
        Singleton instance = Singleton.getInstance();

        instance.map.put(instance.value, number);
        list.add(instance.value);
        Singleton.increment();
        return list;
    }
}
