package com.project2;

import com.project2.entity.Entity;

public class Simulation {
    Actions actions;
    private int moveCounter = 1;

    public Simulation(Actions actions) {
        this.actions = actions;
    }

    private void nextTurn(){
        actions.turnActions();
    };
    public void startSimulation(){
        System.out.println("Starting Simulation !!!");
        System.out.println();
        actions.initActions();
        while (moveCounter < 2){
            System.out.println("| Round " + moveCounter + " |");
            moveCounter++;
            nextTurn();
        }
    };
    private void pauseSimulation(){
        System.out.println("stop simulation");
    };
}
