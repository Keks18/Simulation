package com.project2.service;

import com.project2.entity.Coordinates;

public interface PathFinderService {
    Coordinates isGrassAround(Coordinates coordinates);

    Coordinates isHerbivoreAround(Coordinates coordinates);

    void findPathToHerbivore(Coordinates coordinates);

    void findPathToGrass(Coordinates coordinates);
}
