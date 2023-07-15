package com.project2;

public class Predator extends Creature{
    protected int power;

    public Predator(int power, int speed, int hp, Coordinates coordinates) {
        this.power = power;
        this.speed = speed;
        this.HP = hp;
        this.coordinates = coordinates;
    }

    public int getPower() {
        return power;
    }


    @Override
    void makeMove() {
        System.out.println("eating herbivore or make path to him");
    }
}