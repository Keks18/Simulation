package com.project2.entity;

import com.project2.SimulationMap;
import com.project2.view.View;

import java.util.Objects;

public class Predator extends Creature{
    protected int power;

    public Predator(int power, int speed, int hp, Coordinates coordinates, SimulationMap simulationMap) {
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
    public void makeMove() {
        System.out.println("eating herbivore or make path to him");
    }

    @Override
    void checkVariantsToMove() {
        // checking variants... use graphs...
        // return Coordinate if haven`t around a herbivore
        // return Herbivore if pred can hit them
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
