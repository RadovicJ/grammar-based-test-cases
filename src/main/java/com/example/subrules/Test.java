package com.example.subrules;

import com.example.client.EvalInterface;

import java.util.ArrayList;

public class Test implements EvalInterface {

    @Override
    public ArrayList<Object> eval() {
        ArrayList<Object> list = new ArrayList<>();
//        if (depth <= 0) {
//            list.add(new Sum().eval());
//            return list;
//        }
//        list.add(new Sum().eval() + " < " + new Sum().eval());
        return list;
    }
}
