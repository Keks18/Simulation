package com.project2;

import com.project2.entity.*;

import java.util.*;

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

    public SimulationMap() {
        generateAllMapCoordinates();
    }

    public Map<Coordinates, Entity> getMap() {
        return map;
    }

    public void setMap(Map<Coordinates, Entity> map) {
        this.map = map;
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
            if (generateEntityDefaultPositions(new Predator(10,1, 10, new Coordinates(), this)) != null){
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
        // прототип того как будем удалять из мапы и добавлять обновленных существ с их координатами
        Iterator<Entity> iterator = map.values().iterator();
        List<Entity> entitiesToAdd = new ArrayList<>();

        while (iterator.hasNext()) {
            Entity entity = iterator.next();
            if (entity instanceof Herbivore) {
                Herbivore herbivore = (Herbivore) entity;
                entitiesToAdd.add(herbivore);
                iterator.remove();
//                map.put(new Coordinates(), herbivore);
            }
            if (entity instanceof Predator) {
                Predator predator = (Predator) entity;
                predator.makeMove();
                entitiesToAdd.add(predator);
                iterator.remove();
            }
        }
        for (Entity entity :
                entitiesToAdd) {
            entity.coordinates.y++;
        }
        for (Entity entity : entitiesToAdd) {
            map.put(entity.getCoordinates(), entity);
        }
    }
    private void generateAllMapCoordinates(){
        for (int x = 1; x < 11; x++) {
            for (int y = 1; y < 11; y++) {
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
