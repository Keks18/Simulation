package com.project2;

import java.util.Map;

public class Actions {
    SimulationMap simulationMap = new SimulationMap();
    Renderer renderer = new Renderer();
    public void initActions(){

        simulationMap.initializeEntities();

        renderer.simulationMap = simulationMap;
        renderer.render(11);

        simulationMap.findAndMakeMoveCreatures();
        renderer.render(11);
    }
    public void turnActions(){

    }

}
