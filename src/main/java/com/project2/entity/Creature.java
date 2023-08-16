package com.project2.entity;

import com.project2.service.PathFinderService;
import java.util.List;

public abstract class Creature extends Entity{
    protected int speed;
    protected int HP;
    PathFinderService pathFinderService;
    SimulationMap simulationMap;
    List<Coordinates> currentPath;

    public int getHP() {
        return HP;
    }
    public abstract void makeMove();

}
