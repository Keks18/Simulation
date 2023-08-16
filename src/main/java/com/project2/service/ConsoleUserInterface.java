package com.project2.service;

import com.project2.Simulation;

public class ConsoleUserInterface implements UserInterfaceService{
    Simulation simulation;
    public ConsoleUserInterface(Simulation simulation) {
        this.simulation = simulation;
    }

    @Override
    public void processUserInput(int value) {
        switch (value) {
            case 1 -> {
                try {
                    simulation.startStandardSimulation();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            case 2 -> {
                try {
                    simulation.startSimulationWithControl();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            default -> simulation.setRun(false);
        }
    }
}
