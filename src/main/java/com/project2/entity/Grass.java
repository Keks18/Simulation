package com.project2.entity;

import com.project2.view.View;

public class Grass extends Block{
    public Grass(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.view = View.G;
    }

}
