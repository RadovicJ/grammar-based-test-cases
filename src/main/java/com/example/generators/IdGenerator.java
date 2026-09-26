package com.example.generators;

import com.example.client.EvalInterface;
import com.example.client.Singleton;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.Random;

public class IdGenerator implements EvalInterface {

    private static final Random RNG = new Random();

    @Override
    public ArrayList<Integer> eval() {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        int size = RNG.nextInt(5) + 1;
        while (sb.length() < size) {
            int index = (int) (RNG.nextFloat() * chars.length());
            sb.append(chars.charAt(index));
        }
        String var = sb.toString();
        if (var.equals("if")) {
            var = "x";
        } else if (var.equals("while")) {
            var = "y";
        }

        ArrayList<Integer> list = new ArrayList<>();
        Singleton instance = Singleton.getInstance();

        instance.map.put(instance.value, var);
        list.add(instance.value);
        Singleton.increment();
        return list;
    }
}
