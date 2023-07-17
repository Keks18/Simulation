package com.project2;

import java.util.HashMap;

public class Map extends Entity{
    HashMap<Coordinates, Entity> map = new HashMap<>();
    public int getSize(){
        return map.size();
    }
    public Entity setEntity(Coordinates coordinate, Entity entity){
        return map.putIfAbsent(coordinate, entity);
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
    public void generateAllPositions(){
        for (int i = 0; i < 3; i++){
            if (generateEntityDefaultPositions(new Herbivore(10,1, new Coordinates())) != null){
                i--;
            }
        }
        for (int i = 0; i < 3; i++){
            if (generateEntityDefaultPositions(new Predator(10,1, 10, new Coordinates())) != null){
                i--;
            }
        }
        for (int i = 0; i < 6; i++){
            if (generateEntityDefaultPositions(new Grass(new Coordinates())) != null){
                i--;
            }
        }
        for (int i = 0; i < 8; i++){
            if (generateEntityDefaultPositions(new Rock(new Coordinates())) != null){
                i--;
            }
        }
        for (int i = 0; i < 8; i++){
            if (generateEntityDefaultPositions(new Tree(new Coordinates())) != null){
                i--;
            }
        }
    }
    public <T extends Entity> Entity generateEntityDefaultPositions(T t){
            return setEntity(t.getCoordinates(), t);
    }

    @Override
    public String toString() {
        return "Map{" +
                "map=" + map +
                '}';
    }
}
