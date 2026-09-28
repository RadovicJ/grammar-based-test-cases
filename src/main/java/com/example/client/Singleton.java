package com.example.client;

import java.util.HashMap;

public final class Singleton {
    private static Singleton instance;
    public int value;
    public HashMap<Integer, String> map;
    public static References references;

    private Singleton(int value) {
        this.value = value;
        this.map = new HashMap<>();
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton(1);
            references = new References();
        }
        return instance;
    }

    public static void increment() {
        instance.value++;
    }
}
