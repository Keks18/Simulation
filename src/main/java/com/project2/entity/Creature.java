package com.project2.entity;

import com.project2.SimulationMap;
import com.project2.service.PathFinderService;

import java.nio.file.Path;
import java.util.Deque;
import java.util.List;

public abstract class Creature extends Entity{
    PathFinderService pathFinderService;
    protected int speed;

    protected int HP;

    public int getHP() {
        return HP;
    }

    public abstract void makeMove();

    SimulationMap simulationMap;

    List<Coordinates> currentPath;

}
