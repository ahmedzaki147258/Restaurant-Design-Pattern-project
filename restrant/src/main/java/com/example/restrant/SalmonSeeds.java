package com.example.restrant;

public class SalmonSeeds extends Meal {

    public SalmonSeeds(baseMeal b) {
        super(b);
    }

    public SalmonSeeds() {
    }

    ;
    @Override
    public String decorate() {
        return super.decorate() + " ,SalmonSeeds";
    }

    public String dd() {
        return " ,SalmonSeeds";
    }
}
