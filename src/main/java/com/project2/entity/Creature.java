package com.project2.entity;

import com.project2.SimulationMap;

public abstract class Creature extends Entity{
    protected int speed;

    protected int HP;

    public abstract void makeMove();

    SimulationMap simulationMap;

    abstract void checkVariantsToMove();

}
