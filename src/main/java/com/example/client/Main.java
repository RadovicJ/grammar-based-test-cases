package com.example.client;

import com.example.rules.IfStatement;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Object> list = new Statement(0).eval();
        String s = list.get(0).toString();
    }
}
