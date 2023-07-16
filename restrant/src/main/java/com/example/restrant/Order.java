package com.example.restrant;

import java.util.ArrayList;
import java.util.List;

public class Order {

    Menu m;
    //baseMeal b;
    private List<Menu> order = new ArrayList<>();

    public void add(Menu T) {
        order.add(T);
    }

    public void remove(Menu T) {
        order.remove(T);
    }

    public void show() {
        System.out.println("\t \t the available Order");
        for (Menu b1 : order) {
            b1.showItems();
        }
    }
}
