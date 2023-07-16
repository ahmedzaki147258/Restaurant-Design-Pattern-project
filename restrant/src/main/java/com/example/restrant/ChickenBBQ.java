/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restrant;

public class ChickenBBQ extends Meal {

    public ChickenBBQ(baseMeal b) {
        super(b);
    }

    public ChickenBBQ() {
    }

    ;
    @Override
    public String decorate() {
        return super.decorate() + " ,ChickenBBQ";
    }

    public String dd() {
        return " ,ChickenBBQ";
    }
}
