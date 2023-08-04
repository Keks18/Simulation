package com.project2.service;

import com.project2.entity.Coordinates;

import java.util.Deque;

public interface PathFinderService {
    Coordinates isGrassAround(Coordinates coordinates);

    Coordinates isHerbivoreAround(Coordinates coordinates);

    Deque<Coordinates> findPathToHerbivore(Coordinates coordinates);

    Deque<Coordinates> findPathToGrass(Coordinates coordinates);
}
