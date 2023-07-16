package com.example.restrant;

public class SeafoodCurry extends Meal {

    public SeafoodCurry(baseMeal b) {
        super(b);
    }

    public SeafoodCurry() {
    }

    ;
    @Override
    public String decorate() {
        return super.decorate() + " ,SeafoodCurry";
    }

    public String dd() {
        return " ,SeafoodCurry";
    }
}
