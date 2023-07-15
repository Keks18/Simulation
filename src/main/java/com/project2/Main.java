package com.project2;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        map.generateAllPositions();
        System.out.println(map.getSize());
        System.out.println(map);

    }
}