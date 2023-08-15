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
                .filter(e -> simulationMap.getEntity(e) != null && simulationMap.getEntity(e) instanceof Grass)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Coordinates> findPathToGrass(Coordinates start) {
        Deque<Coordinates> queue = new ArrayDeque<>();
        Set<Coordinates> visited = new HashSet<>();
        Map<Coordinates, Coordinates> parentMap = new HashMap<>();
        Coordinates end = null;

        queue.offer(start);
        visited.add(start);

        while (!visited.isEmpty()){
            Coordinates current = queue.poll();
            if (current == null){
                return Stream.of(
                        start,
                        start
                ).collect(Collectors.toList());
            }
            if (isGrassAround(current) != null){
                end = current;
                break;
            }

            List<Coordinates> neighbors = getAvailableCoordinatesAround(current);

            for (Coordinates neighbor :
                    neighbors) {
                if (!visited.contains(neighbor)){
                    queue.offer(neighbor);
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                }
            }
        }

        return reconstructPath(parentMap, start, end);
    }

    @Override
    public Coordinates isHerbivoreAround(Coordinates coordinates) {
        //try to find a herbivore near the predator and return coordinate of herb. or null(help meth)
        return checkCoordinatesAround(coordinates)
                .stream()
                .filter(e -> simulationMap.getEntity(e) != null && simulationMap.getEntity(e) instanceof Herbivore)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Coordinates> findPathToHerbivore(Coordinates start) {
        Deque<Coordinates> queue = new ArrayDeque<>();
        Set<Coordinates> visited = new HashSet<>();
        Map<Coordinates, Coordinates> parentMap = new HashMap<>();
        Coordinates end = null;

        queue.offer(start);
        visited.add(start);

        while (!visited.isEmpty()){
            Coordinates current = queue.poll();
            if (current == null){
                return Stream.of(
                        start,
                        start
                ).collect(Collectors.toList());
            }
            if (isHerbivoreAround(current) != null){
                end = current;
                break;
            }

            List<Coordinates> neighbors = getAvailableCoordinatesAround(current);

            for (Coordinates neighbor :
                    neighbors) {
                if (!visited.contains(neighbor)){
                    queue.offer(neighbor);
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                }
            }
        }

        return reconstructPath(parentMap, start, end);
    }
    private static List<Coordinates> reconstructPath(Map<Coordinates, Coordinates> parentMap, Coordinates start, Coordinates end) {
        List<Coordinates> path = new ArrayList<>();
        Coordinates current = end;

        while (current != null && !current.equals(start)) {
            path.add(current);
            current = parentMap.get(current);
        }

        if (current != null && current.equals(start)) {
            path.add(current);
        }

        Collections.reverse(path);
        return path;
    }
    private List<Coordinates> getAvailableCoordinatesAround(Coordinates coordinates){
        return checkCoordinatesAround(coordinates).stream()
                .filter(el -> simulationMap.containsCoordinate(el) && simulationMap.getEntity(el) == null)
                .collect(Collectors.toList());
    }
    private Set<Coordinates> checkCoordinatesAround(Coordinates coordinates){
        //a list of coordinates to check food for a creature
        int x = coordinates.getX();
        int y = coordinates.getY();

        return Stream.of(
                new Coordinates(x, y - 1),
                new Coordinates(x - 1, y),
                new Coordinates(x + 1, y),
                new Coordinates(x, y + 1)
        ).collect(Collectors.toCollection(HashSet::new));
    }

}
