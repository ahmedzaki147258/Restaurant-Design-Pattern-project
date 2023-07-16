package com.example.restrant;

public class Margarita extends Meal {

    public Margarita(baseMeal b) {
        super(b);
    }

    public Margarita() {
    }

    ;
    @Override
    public String decorate() {
        return super.decorate() + " ,Margarita";
    }

    public String dd() {
        return " ,Margarita";
    }
}
