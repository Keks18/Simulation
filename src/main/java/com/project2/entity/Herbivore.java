package com.project2.entity;

import com.project2.SimulationMap;
import com.project2.service.BreadthFirstSearch;
import com.project2.view.View;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Objects;

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

        int currentSpeed = speed;
        currentPath = pathFinderService.findPathToGrass(this.coordinates);
        currentMap.put(coordinates, null);
        if (currentPath == null){
            return;
        }
        while (currentSpeed > 0) {
            oneStepPath.add(currentPath.pollFirst());
            if (pathFinderService.isGrassAround(oneStepPath.peekLast()) != null){
                oneStepPath.add(eatGrass(pathFinderService.isGrassAround(oneStepPath.peekLast())));
                break;
            }
            currentSpeed--;
        }
        this.coordinates = oneStepPath.peekLast();
        currentMap.put(oneStepPath.getLast(), this);
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
        this.HP += hp;
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
