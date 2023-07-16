package com.example.restrant;

public class CitusSalad extends Meal {

    public CitusSalad(baseMeal b) {
        super(b);
    }

    public CitusSalad() {
    }

    ;
    @Override
    public String decorate() {
        return super.decorate() + " ,CitusSalad";
    }

    public String dd() {
        return " ,CitusSalad";
    }
}
