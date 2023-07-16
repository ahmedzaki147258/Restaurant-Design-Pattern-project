package com.example.restrant;

public class CeasrSalad extends Meal {

    public CeasrSalad(baseMeal b) {
        super(b);
    }

    public CeasrSalad() {
    }

    ;
    @Override
    public String decorate() {
        return super.decorate() + " ,CeasrSalad";
    }

    public String dd() {
        return " ,CeasrSalad";
    }
}
