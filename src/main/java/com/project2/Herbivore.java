package com.project2;

public class Herbivore extends Creature{
    public Herbivore(int speed, int hp) {
        this.speed = speed;
        this.HP = hp;
    }

    @Override
    void makeMove() {
        System.out.println("Eat smth or make path to grass");
    }

}
