package com.project2.view;

import com.project2.SimulationMap;
import com.project2.entity.Coordinates;

public class Renderer {
    private final SimulationMap simulationMap;

    public Renderer(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
    }

    public void render(int size){
        Coordinates keyCoordinates = new Coordinates();

        FIRST:for (keyCoordinates.setY(1); keyCoordinates.getY() < size; keyCoordinates.setY(keyCoordinates.getY()+1)) {
            SECOND:for (keyCoordinates.setX(1); keyCoordinates.getX() < size; keyCoordinates.setX(keyCoordinates.getX()+1)) {
                for (Coordinates c: simulationMap.getAllKeysCoordinates()) {
                    if (keyCoordinates.equals(c) && simulationMap.getEntity(c) != null){
                        System.out.print("[" + simulationMap.getEntity(c).view + "] ");
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
