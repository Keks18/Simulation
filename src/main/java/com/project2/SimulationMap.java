package com.project2;

import com.project2.entity.*;

import java.util.*;

public class SimulationMap {
    private final int mapLineSize = 11;
    private final int coordinateBound = 10;
    private final Map<Coordinates, Entity> map = new HashMap<>();

    public SimulationMap() {
        generateAllMapCoordinates();
    }

    public int getMapLineSize() {
        return mapLineSize;
    }
    public int getSize(){
        return map.size();
    }
    public void setEntity(Coordinates coordinate, Entity entity){
        map.put(coordinate, entity);
    }
    public Collection<Entity> getAllEntities(){
        return map.values();
    }
    public Set<Coordinates> getAllKeysCoordinates(){
        return map.keySet();
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
            if (generateEntityDefaultPositions(new Herbivore(10,2, new Coordinates(coordinateBound), this)) != null){
                i--;
            }
        }
        for (int i = 0; i < 3; i++){
            if (generateEntityDefaultPositions(new Predator(10,2, 10, new Coordinates(coordinateBound), this)) != null){
                i--;
            }
        }
        for (int i = 0; i < 7; i++){
            if (generateEntityDefaultPositions(new Grass(new Coordinates(coordinateBound))) != null){
                i--;
            }
        }
        for (int i = 0; i < 10; i++){
            if (generateEntityDefaultPositions(new Rock(new Coordinates(coordinateBound))) != null){
                i--;
            }
        }
        for (int i = 0; i < 10; i++){
            if (generateEntityDefaultPositions(new Tree(new Coordinates(coordinateBound))) != null){
                i--;
            }
        }
    }

    private Entity setIfAbsentAndReturnEntity(Coordinates coordinate, Entity entity){
        if (map.putIfAbsent(coordinate, entity) == null){
            entity.coordinates = coordinate;
            return null;
        } else {
            return map.putIfAbsent(coordinate, entity);
        }
    }
    private Entity generateEntityDefaultPositions(Entity entity){
            return setIfAbsentAndReturnEntity(entity.getCoordinates(), entity);
    }
    private void generateAllMapCoordinates(){
        for (int x = 1; x < mapLineSize; x++) {
            for (int y = 1; y < mapLineSize; y++) {
                this.setEntity(new Coordinates(x, y), null);
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
