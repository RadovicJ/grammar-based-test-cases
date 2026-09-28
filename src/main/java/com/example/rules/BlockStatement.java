package com.example.rules;

import com.example.client.EvalInterface;
import com.example.client.Singleton;
import com.example.client.Statement;

import java.util.ArrayList;

public class BlockStatement implements EvalInterface {

    private final int level;

    public BlockStatement(int level) {
        this.level = level;
    }

    @Override
    public ArrayList<Integer> eval() {
        ArrayList<Integer> list = new ArrayList<>();
        Singleton instance = Singleton.getInstance();
        ArrayList<Integer> statement_list = new Statement(level + 1).eval();

        for (int statement_index : statement_list) {
            String statement_string = Singleton.getInstance().map.get(statement_index);
            String statementCombined = "{ " + statement_string + " }";
            instance.map.put(statement_index, statementCombined);
            list.add(statement_index);
        }

        return list;
    }

}
