package com.project2;

import com.project2.entity.*;

import java.util.*;

public class SimulationMap {
    public final int lineSize = 11;
    Map<Coordinates, Entity> map = new HashMap<>();
    public int getSize(){
        return map.size();
    }
    public Entity setEntity(Coordinates coordinate, Entity entity){
        if (map.putIfAbsent(coordinate, entity) == null){
            entity.coordinates = coordinate;
            return null;
        } else {
            return map.putIfAbsent(coordinate, entity);
        }
    }

    public SimulationMap() {
        generateAllMapCoordinates();
    }

    public Map<Coordinates, Entity> getMap() {
        return map;
    }

    public Entity getEntity(Coordinates coordinates){
        return map.get(coordinates);
    }
    public void removeEntity(Coordinates coordinates){
        map.remove(coordinates);
    }
    public boolean containsCoordinate(Coordinates coordinates){
        return map.containsKey(coordinates);
    }
    public void initializeEntities(){
        for (int i = 0; i < 3; i++){
            if (generateEntityDefaultPositions(new Herbivore(10,2, new Coordinates(), this)) != null){
                i--;
            }
        }
        for (int i = 0; i < 3; i++){
            if (generateEntityDefaultPositions(new Predator(10,2, 10, new Coordinates(), this)) != null){
                i--;
            }
        }
        for (int i = 0; i < 7; i++){
            if (generateEntityDefaultPositions(new Grass(new Coordinates())) != null){
                i--;
            }
        }
        for (int i = 0; i < 10; i++){
            if (generateEntityDefaultPositions(new Rock(new Coordinates())) != null){
                i--;
            }
        }
        for (int i = 0; i < 10; i++){
            if (generateEntityDefaultPositions(new Tree(new Coordinates())) != null){
                i--;
            }
        }
    }
    public Entity generateEntityDefaultPositions(Entity entity){
            return setEntity(entity.getCoordinates(), entity);
    }


    private void generateAllMapCoordinates(){
        for (int x = 1; x < lineSize; x++) {
            for (int y = 1; y < lineSize; y++) {
                map.put(new Coordinates(x, y), null);
            }
        }
    }
    @Override
    public String toString() {
        return "Map{" +
                "map=" + map +
                '}';
    }
}
