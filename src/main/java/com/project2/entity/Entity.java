package com.project2.entity;

import com.project2.view.View;

public abstract class Entity {
    public View view;
    public Coordinates coordinates;

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
