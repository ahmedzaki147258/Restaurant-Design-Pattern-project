package com.example.restrant;

public class SeaFoodPizaa extends Meal {

    public SeaFoodPizaa(baseMeal b) {
        super(b);
    }

    public SeaFoodPizaa() {

    }

    @Override
    public String decorate() {
        return super.decorate() + " ,SeaFoodPizaa";
    }

    public String dd() {
        return " ,SeaFoodPizaa";
    }
}
