package com.example.restrant;

public class SeafoodProvencal extends Meal {

    public SeafoodProvencal(baseMeal b) {
        super(b);
    }

    public SeafoodProvencal() {
    }

    ;
    @Override
    public String decorate() {
        return super.decorate() + " ,SeafoodProvencal";
    }

    public String dd() {
        return " ,SeafoodProvencal";
    }
}
