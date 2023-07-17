package com.project2;

public class Renderer extends Entity{
    Map map;


    public void render(int size){
        Coordinates keyCoordinates = new Coordinates();


        FIRST:for (keyCoordinates.y = 1; keyCoordinates.y < size; keyCoordinates.y++) {
            SECOND:for (keyCoordinates.x = 1; keyCoordinates.x < size; keyCoordinates.x++) {
                for (Coordinates c: map.map.keySet()) {
                    if (keyCoordinates.equals(c)){
                        System.out.print("[" + map.map.get(c).view + "] ");
                        continue SECOND;
                    }
                }
                System.out.print("[ ] ");
            }
            System.out.println();
        }
    }
}
