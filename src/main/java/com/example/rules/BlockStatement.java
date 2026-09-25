package com.example.rules;

import com.example.client.EvalInterface;
import com.example.client.Statement;

import java.util.Random;

public class BlockStatement implements EvalInterface {

    private final int depth;
    static final Random RNG = new Random();

    public BlockStatement(int depth) {
        this.depth = depth;
    }

    @Override
    public String eval() {
        int n = range(0, Math.min(3, Math.max(0, depth)));
        StringBuilder sb = new StringBuilder("{ ");
        for (int i = 0; i < n; i++) sb.append(new Statement(depth - 1).eval()).append(' ');
        sb.append('}');
        return sb.toString();
    }

    private static int range(int lo, int hi) { return lo + RNG.nextInt(hi - lo + 1); }
}
