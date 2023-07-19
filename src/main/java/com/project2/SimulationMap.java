package com.project2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SimulationMap {
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
            if (generateEntityDefaultPositions(new Herbivore(10,1, new Coordinates(), this)) != null){
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
    public Entity generateEntityDefaultPositions(Entity entity){
            return setEntity(entity.getCoordinates(), entity);
    }

    public void findAndMakeMoveCreatures() {
        Iterator<Entity> iterator = map.values().iterator();

        while (iterator.hasNext()) {
            Entity entity = iterator.next();

            if (entity instanceof Herbivore) {
                Herbivore herbivore = (Herbivore) entity;
                herbivore.makeMove();
            }

            if (entity instanceof Predator) {
                Predator predator = (Predator) entity;
                predator.makeMove();
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
