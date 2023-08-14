package com.project2.service;

import com.project2.entity.Coordinates;

import java.util.List;

public interface PathFinderService {
    Coordinates isGrassAround(Coordinates coordinates);

    Coordinates isHerbivoreAround(Coordinates coordinates);

    List<Coordinates> findPathToHerbivore(Coordinates coordinates);

    List<Coordinates> findPathToGrass(Coordinates coordinates);
}
