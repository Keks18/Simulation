package com.project2;

import java.util.ArrayList;

public class Simulation extends Entity{
    private Map map;
    private int moveCounter;
    private Renderer renderer;

    private void nextTurn(){};
    private void startSimulation(){
        while (1!=0){
            nextTurn();
        }
    };
    private void pauseSimulation(){
        System.out.println("stop simulation");
    };
}
