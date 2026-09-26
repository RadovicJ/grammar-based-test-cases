package com.example.rules;

import com.example.client.EvalInterface;
import com.example.client.Statement;

import java.util.ArrayList;
import java.util.Random;

public class BlockStatement implements EvalInterface {

    static final Random RNG = new Random();
    private final int level;

    public BlockStatement(int level) {
        this.level = level;
    }

    @Override
    public ArrayList<Object> eval() {
        ArrayList<Object> list = new ArrayList<>();
        int n = range(0, Math.min(3, Math.max(0, 2)));
        StringBuilder sb = new StringBuilder("{ ");
        for (int i = 0; i < n; i++) sb.append(new Statement(level + 1).eval()).append(' ');
        sb.append('}');
        list.add(sb.toString());
        return list;
    }

    private static int range(int lo, int hi) { return lo + RNG.nextInt(hi - lo + 1); }
}
