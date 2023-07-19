package com.project2;

public class Simulation extends Entity{
    private SimulationMap simulationMap;
    private int moveCounter = 0;
    private Renderer renderer;

    private void nextTurn(){
        renderer.render(11);
        moveCounter++;
    };
    private void startSimulation(){
        while (1!=0){
            nextTurn();
        }
    };
    private void pauseSimulation(){
        System.out.println("stop simulation");
    };
}
