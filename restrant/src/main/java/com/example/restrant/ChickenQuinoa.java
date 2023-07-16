package com.example.restrant;


public class ChickenQuinoa extends Meal {

    public ChickenQuinoa(baseMeal b) {
        super(b);
    }

    public ChickenQuinoa() {
    }

    ;
    @Override
    public String decorate() {
        return super.decorate() + " ,ChickenQuinoa";
    }

    public String dd() {
        return " ,ChickenQuinoa";
    }
}
