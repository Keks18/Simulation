package com.project2;

import com.project2.entity.*;

import java.util.*;

public class Simulation {
    SimulationMap simulationMap ;
    Actions actions;
    private int moveCounter = 1;

    public Simulation() {
        this.simulationMap = new SimulationMap();
        this.actions = new Actions(this.simulationMap, this);
    }

    private void nextTurn(){
        actions.turnActions();
    }
    public void startSimulation(){
        System.out.println("Starting Simulation !!!");
        System.out.println();
        actions.initActions();
        while (moveCounter < 2){
            System.out.println("| Round " + moveCounter + " |");
            moveCounter++;
            nextTurn();
        }
    }

    private void pauseSimulation(){
        System.out.println("stop simulation");
    }

    public void makeMoveCreatures(Deque<Creature> creaturesToAdd) {
        for (Creature creature :
                creaturesToAdd) {
            creature.makeMove();
        }
    }
    public Deque<Creature> findCreaturesInMap(){
        Iterator<Entity> iterator = simulationMap.getMap().values().iterator();
        Deque<Creature> creaturesToAdd = new ArrayDeque<>();
        while (iterator.hasNext()) {
            Entity entity = iterator.next();
            if (entity instanceof Herbivore) {
                Herbivore herbivore = (Herbivore) entity;
                creaturesToAdd.add(herbivore);
            }
//            if (entity instanceof Predator) {
//                Predator predator = (Predator) entity;
//                predator.makeMove();
//                creaturesToAdd.add(predator);
////                iterator.remove();
//            }
        }
        return creaturesToAdd;
    }
    public Boolean herbivoreWin(){
        Iterator<Entity> iterator = simulationMap.getMap().values().iterator();
        List<Grass> grassInMap = new ArrayList<>();

        while (iterator.hasNext()) {
            Entity entity = iterator.next();
            if (entity instanceof Grass grass) {
                grassInMap.add(grass);
            }
        }
        return grassInMap.isEmpty();
    }
    public Boolean predatorWin(){
        Iterator<Entity> iterator = simulationMap.getMap().values().iterator();
        List<Herbivore> herbivoreInMap = new ArrayList<>();

        while (iterator.hasNext()) {
            Entity entity = iterator.next();
            if (entity instanceof Herbivore herbivore) {
                herbivoreInMap.add(herbivore);
            }
        }
        return herbivoreInMap.isEmpty();
    }
    public void endOfSimulation(Class winner){
        System.out.println("Simulation ended!!!");
        System.out.println("The winner is " + winner.getSimpleName());
        System.exit(0);
    }
}
