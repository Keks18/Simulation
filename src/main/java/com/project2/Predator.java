package com.project2;

import java.util.Objects;

public class Predator extends Creature{
    protected int power;

    public Predator(int power, int speed, int hp, Coordinates coordinates) {
        this.power = power;
        this.speed = speed;
        this.HP = hp;
        this.coordinates = coordinates;
        this.view = View.P;
    }

    public int getPower() {
        return power;
    }

    @Override
    void makeMove() {
        System.out.println("eating herbivore or make path to him");
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
