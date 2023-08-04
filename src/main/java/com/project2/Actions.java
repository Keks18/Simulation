package com.project2;

import com.project2.entity.Herbivore;
import com.project2.entity.Predator;
import com.project2.view.Renderer;

public class Actions {
    Simulation simulation;
    SimulationMap simulationMap;
    Renderer renderer = new Renderer();

    public Actions(SimulationMap simulationMap, Simulation simulation) {
        this.simulationMap = simulationMap;
        this.simulation = simulation;
    }

    public void initActions(){
        simulationMap.initializeEntities();

        renderer.simulationMap = simulationMap;
        renderer.render(simulationMap.lineSize);
    }
    public void turnActions(){
        simulation.makeMoveCreatures(simulation.findCreaturesInMap());
        renderer.render(simulationMap.lineSize);
        if (simulation.herbivoreWin()){
            simulation.endOfSimulation(Herbivore.class);
        }
        if (simulation.predatorWin()){
            simulation.endOfSimulation(Predator.class);
        }
    }

}
