package com.project2;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        map.generateAllPositions();
        Renderer renderer = new Renderer();
        renderer.map = map;
        renderer.render(11);

    }
}