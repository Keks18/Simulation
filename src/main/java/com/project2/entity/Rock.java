package com.project2.entity;

import com.project2.view.View;

public class Rock extends Block{
    public Rock(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.view = View.R;
    }
}
