package com.project2.entity;

import com.project2.SimulationMap;
import com.project2.service.BreadthFirstSearch;
import com.project2.view.View;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
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

    public int getPower() {
        return power;
    }
    @Override
    public void makeMove(){
        Map<Coordinates, Entity> currentMap = simulationMap.getMap();
        Deque<Coordinates> oneStepPath = new ArrayDeque<>();
        int currentSpeed = speed;

        currentPath = pathFinderService.findPathToHerbivore(this.coordinates);
        currentMap.put(coordinates, null);
        if (currentPath == null){
            return;
        }
        while (currentSpeed > 0) {
            oneStepPath.add(currentPath.pollFirst());
            if (pathFinderService.isHerbivoreAround(oneStepPath.peekLast()) != null){
                attackHerbivore(
                        (Herbivore) currentMap.get
                                (pathFinderService.isHerbivoreAround(oneStepPath.peekLast()))
                );
                break;
            }
            currentSpeed--;
        }

        this.coordinates = oneStepPath.peekLast();
        currentMap.put(oneStepPath.getLast(), this);

    }
    private void attackHerbivore(Herbivore herbivore){
        herbivore.decreaseHP(power);
        if (herbivore.getHP() <= 0){
            killHerbivore(herbivore);
        }
    }
    private void killHerbivore(Herbivore herbivore){
            simulationMap.getMap().put(herbivore.coordinates, null);
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
