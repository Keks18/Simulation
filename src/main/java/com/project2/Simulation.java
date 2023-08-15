package com.project2;

import com.project2.entity.*;
import com.project2.view.Renderer;

import java.util.*;

public class Simulation {
    private int moveCounter = 1;
    private final SimulationMap simulationMap ;
    private final SimulationActions actions;

    public Simulation() {
        this.simulationMap = new SimulationMap();
        this.actions = new SimulationActions(this.simulationMap);
    }
    public void startSimulation(){
        System.out.println("Starting Simulation !!!");
        System.out.println();
        actions.initActions();
        while (moveCounter < 1000){
            System.out.println("| Round " + moveCounter + " |");
            moveCounter++;
            nextTurn();
        }
    }
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.startSimulation();
    }
    private class SimulationActions {
        private final SimulationMap simulationMap;
        private final Renderer renderer;
        public SimulationActions(SimulationMap simulationMap) {
            this.simulationMap = simulationMap;
            this.renderer = new Renderer();
        }

        public void initActions(){
            simulationMap.initializeEntities();
            renderer.simulationMap = simulationMap;
            renderer.render(simulationMap.getMapLineSize());
        }
        public void turnActions(){
            makeMoveCreatures(findCreaturesInMap());
            renderer.render(simulationMap.getMapLineSize());
            if (herbivoreWin()){
                endOfSimulation(Herbivore.class);
            }
            if (predatorWin()){
                endOfSimulation(Predator.class);
            }
        }

    }

    private void nextTurn(){
        actions.turnActions();
    }
    private void pauseSimulation(){
        System.out.println("stop simulation");
    }
    private void makeMoveCreatures(Deque<Creature> creaturesToAdd) {
        for (Creature creature :
                creaturesToAdd) {
                if (creature.getHP() > 0) creature.makeMove();
        }
    }
    private Deque<Creature> findCreaturesInMap(){
        Iterator<Entity> iterator = simulationMap.getAllEntities().iterator();
        Deque<Creature> creaturesToAdd = new ArrayDeque<>();
        while (iterator.hasNext()) {
            Entity entity = iterator.next();
            if (entity instanceof Herbivore) {
                Herbivore herbivore = (Herbivore) entity;
                creaturesToAdd.add(herbivore);
            }
            if (entity instanceof Predator) {
                Predator predator = (Predator) entity;
                creaturesToAdd.add(predator);
            }
        }
        return creaturesToAdd;
    }
    private Boolean herbivoreWin(){
        Iterator<Entity> iterator = simulationMap.getAllEntities().iterator();
        List<Grass> grassInMap = new ArrayList<>();

        while (iterator.hasNext()) {
            Entity entity = iterator.next();
            if (entity instanceof Grass grass) {
                grassInMap.add(grass);
            }
        }
        return grassInMap.isEmpty();
    }
    private Boolean predatorWin(){
        Iterator<Entity> iterator = simulationMap.getAllEntities().iterator();
        List<Herbivore> herbivoreInMap = new ArrayList<>();

        while (iterator.hasNext()) {
            Entity entity = iterator.next();
            if (entity instanceof Herbivore herbivore) {
                herbivoreInMap.add(herbivore);
            }
        }
        return herbivoreInMap.isEmpty();
    }
    private void endOfSimulation(Class winner){
        System.out.println("Simulation ended!!!");
        System.out.println("The winner is " + winner.getSimpleName());
        System.exit(0);
    }
}
