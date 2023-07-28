package com.project2;

import com.project2.view.Renderer;

public class Actions {
    SimulationMap simulationMap = new SimulationMap();
    Renderer renderer = new Renderer();
    public void initActions(){
        simulationMap.initializeEntities();

        renderer.simulationMap = simulationMap;
        renderer.render(11);
    }
    public void turnActions(){
        simulationMap.findAndMakeMoveCreatures();
        renderer.render(11);
    }

}
