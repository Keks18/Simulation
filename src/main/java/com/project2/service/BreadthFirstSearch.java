package com.project2.service;

import com.project2.entity.Coordinates;
import com.project2.SimulationMap;
import com.project2.entity.Grass;
import com.project2.entity.Herbivore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    public Coordinates isHerbivoreAround(Coordinates coordinates) {
        //try to find a herbivore near the predator and return coordinate of herb. or null(help meth)
        return checkCoordinatesAround(coordinates)
                .stream()
                .filter(e -> simulationMap.getMap().get(e) instanceof Herbivore)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void findPathToHerbivore(Coordinates coordinates) {

    }

    @Override
    public void findPathToGrass(Coordinates coordinates) {

    }
    private List<Coordinates> findAvailableCoordinatesAround(Coordinates coordinates){
        return null;
    }
    private Set<Coordinates> checkCoordinatesAround(Coordinates coordinates){
        //a set of coordinates to check food for a creature
        return Stream.of(
                new Coordinates(++coordinates.x, ++coordinates.y),
                new Coordinates(--coordinates.x, --coordinates.y),
                new Coordinates(++coordinates.x, coordinates.y),
                new Coordinates(coordinates.x, ++coordinates.y),
                new Coordinates(--coordinates.x, ++coordinates.y),
                new Coordinates(++coordinates.x, --coordinates.y),
                new Coordinates(coordinates.x, --coordinates.y),
                new Coordinates(--coordinates.x, coordinates.y)
        ).collect(Collectors.toCollection(HashSet::new));
    }
}
