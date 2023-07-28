package com.project2.entity;

import com.project2.view.View;

public class Tree extends Block{
    public Tree(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.view = View.T;
    }
}
