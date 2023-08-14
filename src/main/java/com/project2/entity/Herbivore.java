package com.project2.entity;

import com.project2.SimulationMap;
import com.project2.service.BreadthFirstSearch;
import com.project2.view.View;

import java.util.*;

public class Herbivore extends Creature{
    final int GRASS_BENEFIT = 10;

    public Herbivore(int hp, int speed, Coordinates coordinates, SimulationMap simulationMap) {
        this.pathFinderService = new BreadthFirstSearch(simulationMap);
        this.HP = hp;
        this.speed = speed;
        this.coordinates = coordinates;
        this.view = View.H;
        this.simulationMap = simulationMap;
    }
    @Override
    public void makeMove() {
        Map<Coordinates, Entity> currentMap = simulationMap.getMap();
        Deque<Coordinates> oneStepPath = new ArrayDeque<>();
        int currentSpeed = 0;

        if (pathFinderService.isGrassAround(this.coordinates) != null){
            simulationMap.getMap().put(this.coordinates, null);
            this.coordinates = pathFinderService.isGrassAround(this.coordinates);
            eatGrass(this.coordinates);
            simulationMap.getMap().put(this.coordinates, this);
        }
        else {
            currentPath = pathFinderService.findPathToGrass(this.coordinates);
            if (currentPath == null) {
                return;
            }
            currentMap.put(this.coordinates, null);

            currentPath.remove(0);
            while (currentSpeed < speed && currentSpeed < currentPath.toArray().length) {
                oneStepPath.add(currentPath.get(currentSpeed));

                currentSpeed++;
            }

            this.coordinates = oneStepPath.peekLast();
            currentMap.put(oneStepPath.getLast(), this);
        }
    }

    Coordinates eatGrass(Coordinates coordinates){
        increaseHP(GRASS_BENEFIT);
        simulationMap.getMap().put(coordinates, null);
        return coordinates;
    }
    void increaseHP(int hp){
        this.HP += hp;
    }
    void decreaseHP(int hp){
        this.HP -= hp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Herbivore herbivore = (Herbivore) o;
        return GRASS_BENEFIT == herbivore.GRASS_BENEFIT;
    }

    @Override
    public int hashCode() {
        return Objects.hash(GRASS_BENEFIT);
    }
}
