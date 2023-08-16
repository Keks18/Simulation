package com.project2;

import com.project2.entity.*;
import com.project2.service.ConsoleUserInterface;
import com.project2.service.UserInterfaceService;
import com.project2.view.Renderer;

import java.util.*;

public class Simulation {
    public boolean isRun = false;
    int state;
    private int moveCounter = 1;
    private final SimulationMap simulationMap ;
    private final SimulationActions actions;
    UserInterfaceService interfaceService;
    Scanner scanner;

    public Simulation() {
        this.simulationMap = new SimulationMap();
        this.actions = new SimulationActions(this.simulationMap);
        this.interfaceService = new ConsoleUserInterface(this);
        this.scanner = new Scanner(System.in);
    }
    public void startStandardSimulation() throws InterruptedException {
        System.out.println("Starting Simulation !!!");
        System.out.println();
        actions.initActions();
        isRun = true;
        while (isRun){
            System.out.println("| Round " + moveCounter + " |");
            Thread.sleep(1500);
            moveCounter++;
            nextTurn();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Simulation simulation = new Simulation();
        System.out.println("If you type num 1 you will get standard simulation without user control");
        System.out.println("OR");
        System.out.println("If you type num 2 or any else you will get simulation with user control and you can control the round of simulation with typing number");
        simulation.state = simulation.scanner.nextInt();
        simulation.interfaceService.processUserInput(simulation.state);
    }

    public void startSimulationWithControl() throws InterruptedException {
        System.out.println("Starting Simulation With Control!!!");
        System.out.println();
        actions.initActions();
        Thread.sleep(1300);
        int current;
        isRun = true;
        while (isRun){
            System.out.println("| Round " + moveCounter + " |");
            moveCounter++;
            nextTurn();
            System.out.println("If you typing 1 -> end simulation");
            System.out.println("If you typing 2 or any num -> next round generation");
            current = scanner.nextInt();
            if (current == 1) isRun = false;
        }
    }

    private class SimulationActions {
        private final SimulationMap simulationMap;
        private final Renderer renderer;
        public SimulationActions(SimulationMap simulationMap) {
            this.simulationMap = simulationMap;
            this.renderer = new Renderer(simulationMap);
        }

        public void initActions(){
            simulationMap.initializeEntities();
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
        isRun = false;
    }
}
