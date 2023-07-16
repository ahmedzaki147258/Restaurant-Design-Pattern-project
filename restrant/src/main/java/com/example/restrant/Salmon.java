package com.example.restrant;

public class Salmon extends Meal {

    public Salmon(baseMeal b) {
        super(b);
    }

    public Salmon() {
    }

    ;
    @Override
    public String decorate() {
        return super.decorate() + " ,Salmon";
    }

    public String dd() {
        return " ,Salmon";
    }
}
