package com.project2;

public class Renderer extends Entity{
    SimulationMap simulationMap;


    public void render(int size){
        Coordinates keyCoordinates = new Coordinates();


        FIRST:for (keyCoordinates.y = 1; keyCoordinates.y < size; keyCoordinates.y++) {
            SECOND:for (keyCoordinates.x = 1; keyCoordinates.x < size; keyCoordinates.x++) {
                for (Coordinates c: simulationMap.map.keySet()) {
                    if (keyCoordinates.equals(c)){
                        System.out.print("[" + simulationMap.map.get(c).view + "] ");
                        continue SECOND;
                    }
                }
                System.out.print("[ ] ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------");
    }
}
