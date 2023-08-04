package com.project2.service;

import com.project2.entity.Coordinates;
import com.project2.SimulationMap;
import com.project2.entity.Grass;
import com.project2.entity.Herbivore;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BreadthFirstSearch implements PathFinderService{
    SimulationMap simulationMap;

    public BreadthFirstSearch(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
    }

    @Override
    public Coordinates isGrassAround(Coordinates coordinates) {
        //try to find a grass near the herbivore and return coordinate of grass or null (help meth)
        return checkCoordinatesAround(coordinates)
                .stream()
                .filter(e -> simulationMap.getMap().get(e) instanceof Grass)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Deque<Coordinates> findPathToGrass(Coordinates coordinates) {
        Deque<Coordinates> path = new ArrayDeque<>();
        Deque<Coordinates> toVisit = new ArrayDeque<>(getAvailableCoordinatesAround(coordinates));

        while (!toVisit.isEmpty()){
            Coordinates visited = toVisit.pollFirst();
            path.add(visited);
            if (isGrassAround(visited) != null) break;

            toVisit.addAll(getAvailableCoordinatesAround(visited).stream().filter(e -> !path.contains(e)).toList());
        }

        return path;
    }

    @Override
    public Coordinates isHerbivoreAround(Coordinates coordinates) {
        //try to find a herbivore near the predator and return coordinate of herb. or null(help meth)
        return getAvailableCoordinatesAround(coordinates)
                .stream()
                .filter(e -> simulationMap.getMap().get(e) instanceof Herbivore && simulationMap.getMap().get(e) != null)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Deque<Coordinates> findPathToHerbivore(Coordinates coordinates) {
        Deque<Coordinates> path = new ArrayDeque();
        Deque<Coordinates> toVisit = new ArrayDeque<>(getAvailableCoordinatesAround(coordinates));
        while (!toVisit.isEmpty()){
            Coordinates visited = toVisit.pollFirst();
            path.add(visited);
            if (isHerbivoreAround(visited) != null) break;

            toVisit.addAll(getAvailableCoordinatesAround(visited).stream().filter(e -> !path.contains(e)).toList());
        }

        return path;
    }


    private List<Coordinates> getAvailableCoordinatesAround(Coordinates coordinates){
        Set<Coordinates> checkList = checkCoordinatesAround(coordinates);
        List<Coordinates> availableList = new ArrayList<>();
        for (Coordinates c: checkList) {
            if (
                    (c.getX() < simulationMap.lineSize && c.getX() > 0)
                    && (c.getY() < simulationMap.lineSize && c.getY() > 0)
                    && (simulationMap.getMap().get(c) == null)
            ){
                availableList.add(c);
            }
        }
        return availableList;
    }
    private Set<Coordinates> checkCoordinatesAround(Coordinates coordinates){
        //a list of coordinates to check food for a creature
        int x = coordinates.getX();
        int y = coordinates.getY();

        return Stream.of(
                new Coordinates(x - 1, y - 1),
                new Coordinates(x, y - 1),
                new Coordinates(x + 1, y - 1),
                new Coordinates(x - 1, y),
                new Coordinates(x + 1, y),
                new Coordinates(x - 1, y + 1),
                new Coordinates(x, y + 1),
                new Coordinates(x + 1, y + 1)
        ).collect(Collectors.toCollection(HashSet::new));
    }
}