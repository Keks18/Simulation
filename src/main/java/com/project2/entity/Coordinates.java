package com.project2.entity;

import java.util.Objects;
import java.util.Random;

public class Coordinates{
    private int x;
    private int y;

    public Coordinates() {
        this.x = generateRandomCoordinate();
        this.y = generateRandomCoordinate();
    }
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int generateRandomCoordinate(){
        return new Random().nextInt(10) + 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
