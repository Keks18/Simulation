package com.project2;

import java.util.Objects;

public class Herbivore extends Creature{
    final int GRASS_BENEFIT = 10;

    public Herbivore(int hp, int speed, Coordinates coordinates, SimulationMap simulationMap) {
        this.HP = hp;
        this.speed = speed;
        this.coordinates = coordinates;
        this.view = View.H;
        this.simulationMap = simulationMap;
    }

    @Override
    void makeMove() {
//        if (coordinates.x < 11 && coordinates.y < 11){
//            simulationMap.removeEntity(coordinates);
//            ++coordinates.y;
//            ++coordinates.x;
//            simulationMap.setEntity(coordinates, this);
//        } else {
//            System.out.println("Error");
//        }
    }
    void eatGrass(Coordinates coordinates){
        simulationMap.map.remove(coordinates);
        this.coordinates = coordinates;
        increaseHP(GRASS_BENEFIT);
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
