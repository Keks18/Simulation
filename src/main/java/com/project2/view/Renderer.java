package com.project2.view;

import com.project2.SimulationMap;
import com.project2.entity.Coordinates;
import com.project2.entity.Entity;
import com.project2.entity.Herbivore;
import com.project2.entity.Predator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Renderer extends Entity {
    public SimulationMap simulationMap;


    public void render(int size){
        Coordinates keyCoordinates = new Coordinates();


        FIRST:for (keyCoordinates.y = 1; keyCoordinates.y < size; keyCoordinates.y++) {
            SECOND:for (keyCoordinates.x = 1; keyCoordinates.x < size; keyCoordinates.x++) {
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
