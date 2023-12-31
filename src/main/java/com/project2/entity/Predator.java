package com.project2.entity;

import com.project2.service.BreadthFirstSearch;
import com.project2.view.View;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Predator extends Creature{
    protected int power;

    public Predator(int power, int speed, int hp, Coordinates coordinates, SimulationMap simulationMap) {
        this.pathFinderService = new BreadthFirstSearch(simulationMap);
        this.power = power;
        this.speed = speed;
        this.HP = hp;
        this.coordinates = coordinates;
        this.view = View.P;
        this.simulationMap = simulationMap;
    }

    @Override
    public void makeMove(){
        Deque<Coordinates> currentPath = new ArrayDeque<>();
        int currentSpeed = 0;

        if (pathFinderService.isHerbivoreAround(this.getCoordinates()) != null){
            attackHerbivore((Herbivore) simulationMap.getEntity(pathFinderService.isHerbivoreAround(this.getCoordinates())));
        }
        else {
            this.currentPath = pathFinderService.findPathToHerbivore(this.coordinates);
            simulationMap.setEntity(coordinates, null);
            if (this.currentPath == null) {
                return;
            }
            this.currentPath.remove(0);
            while (currentSpeed < speed && currentSpeed < this.currentPath.size()) {
                currentPath.add(this.currentPath.get(currentSpeed));

                currentSpeed++;
            }

            this.coordinates = currentPath.peekLast();
            simulationMap.setEntity(currentPath.getLast(), this);
        }
    }
    private void attackHerbivore(Herbivore herbivore){
        herbivore.decreaseHP(power);
        if (herbivore.getHP() <= 0){
            killHerbivore(herbivore);
        }
    }
    private void killHerbivore(Herbivore herbivore){
        Coordinates current = herbivore.getCoordinates();

        simulationMap.setEntity(this.coordinates, null);
        this.coordinates = current;
        simulationMap.setEntity(this.getCoordinates(), this);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Predator predator = (Predator) o;
        return power == predator.power;
    }

    @Override
    public int hashCode() {
        return Objects.hash(power);
    }
}
