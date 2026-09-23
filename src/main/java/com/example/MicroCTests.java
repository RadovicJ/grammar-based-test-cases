package com.example;

import java.util.Random;

public class MicroCTests {

    static final Random RNG = new Random();

    static String integer() {
        return Integer.toString(RNG.nextInt(100));
    }

    static String id() {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        int size = RNG.nextInt(5) + 1;
        while (sb.length() < size) {
            int index = (int) (RNG.nextFloat() * chars.length());
            sb.append(chars.charAt(index));
        }
        String var = sb.toString();
        if (var.equals("if")) {
            return "x";
        } else if (var.equals("while")) {
            return "y";
        }
        return var;
    }

    static String term() {
        switch (RNG.nextInt(3)) {
            case 0: return id();
            case 1: return integer();
            default: return parenExpr(RNG.nextInt(4));
        }
    }

    static String parenExpr(int depth) {
        return "(" + expr(depth - 1) + ")";
    }

    static String expr(int depth) {
        switch (RNG.nextInt(2)) {
            case 0: return test(depth - 1);
            default: return id() + " = " + expr(depth - 1);
        }
    }

    static String test(int depth) {
        if (depth <= 0) return sum(depth);
        return sum(depth - 1) + " < " + sum(depth - 1);
    }

    static String sum(int depth) {
        if (depth <= 0) return term();
        return sum(depth - 1) + (RNG.nextBoolean() ? " + " : " - ") + term();
    }

    static String exprStatement(int depth) {
        return expr(depth) + ";";
    }

    static String blockStatement(int depth) {
        int n = range(0, Math.min(3, Math.max(0, depth)));
        StringBuilder sb = new StringBuilder("{ ");
        for (int i = 0; i < n; i++) sb.append(statement(depth - 1)).append(' ');
        sb.append('}');
        return sb.toString();
    }

    static int range(int lo, int hi) { return lo + RNG.nextInt(hi - lo + 1); }

    static String ifStatement(int depth) {
        StringBuilder sb = new StringBuilder();
        sb.append("if ").append(parenExpr(depth - 1)).append(' ').append(statement(depth - 1));
        if (RNG.nextBoolean())
            sb.append(" else ").append(statement(depth - 1));
        return sb.toString();
    }

    static String whileStatement(int depth) {
        return "while " + parenExpr(depth - 1) + " " + statement(depth - 1);
    }

    static String statement(int depth) {
        switch (RNG.nextInt(4)) {
            case 0: return ifStatement(depth);
            case 1: return whileStatement(depth);
            case 2: return blockStatement(depth);
            default: return exprStatement(depth);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("- Program " + (i+1) + ": " + statement(RNG.nextInt(10)));
        }
    }
}
