package com.project2;

public class Herbivore extends Creature{
    public Herbivore(int hp, int speed, Coordinates coordinates) {
        this.HP = hp;
        this.speed = speed;
        this.coordinates = coordinates;
        this.view = View.H;
    }

    @Override
    void makeMove() {
        System.out.println("Eat smth or make path to grass");
    }

}
