# Simulation
Study console project
Terms of reference was taken from this course https://zhukovsd.github.io/java-backend-learning-course/Projects/Simulation/

Visualization of the project is carried out in a matrix view in the console

![image](https://github.com/Keks18/Simulation/assets/49402815/ff0447fc-d657-4e48-93f4-fabcd8296daa)

## Goal
The goal of this simulation is to fight every round between herbivores and predators to win the game.  
The benefit for herbivores is no grass on the map.  
The benefit for predators is the absence of herbivores on the map.

### Entities
There are the following entities on the map:

- H -> Herbivore
- P -> Predator
- G -> Grass
- T,R -> Tree and Rock

### Path
To find the path of creatures to their goal, an algorithm was used BFS (Breadth-first search)

### Renderer
The renderer class is used to display the state of the map in each round

### Modes
The simulation can be run in two modes:
1. When the simulation is out of user control, continue to play new rounds until one side wins.  
2. When the simulation is under the control of the user, it can be played step by step with the ability to exit at any time.
