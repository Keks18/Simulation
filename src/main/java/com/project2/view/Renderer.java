package com.project2.view;

import com.project2.SimulationMap;
import com.project2.entity.Coordinates;
import com.project2.entity.Entity;

public class Renderer extends Entity {
    public SimulationMap simulationMap;


    public void render(int size){
        Coordinates keyCoordinates = new Coordinates();

        FIRST:for (keyCoordinates.setY(1); keyCoordinates.getY() < size; keyCoordinates.setY(keyCoordinates.getY()+1)) {
            SECOND:for (keyCoordinates.setX(1); keyCoordinates.getX() < size; keyCoordinates.setX(keyCoordinates.getX()+1)) {
                for (Coordinates c: simulationMap.getMap().keySet()) {
                    if (keyCoordinates.equals(c) && simulationMap.getMap().get(c) != null){
                        System.out.print("[" + simulationMap.getMap().get(c).view + "] ");
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
