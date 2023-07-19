package com.project2;

import java.util.HashMap;
import java.util.Map;

public abstract class Creature extends Entity{
    protected int speed;

    protected int HP;

    abstract void makeMove();

    SimulationMap simulationMap;

}
