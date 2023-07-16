package com.example.restrant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuItems {

    //Meal m1;
    Scanner s = new Scanner(System.in);
    Menu Seafood;
    Menu Salads;
    Menu pizaa;
    Menu Salmon;
    Menu SeafoodProvencal;
    Menu ShrimpCrabPlate;
    Menu SeafoodCurry;
    Menu CeasrSalad;
    Menu ChickenQuinoa;
    Menu SalmonSeeds;
    Menu CitusSalad;
    Menu Margarita;
    Menu ChickenBBQ;
    Menu SeaFoodPizaa;
    static List<baseMeal> order = new ArrayList<>();
    static List<String> oo = new ArrayList<>();
    static List<Menu> menu = new ArrayList<>();
    int a = 1;
    baseMeal b = new firstMeal();
    Receptionist rece = new Receptionist();

    static int counter_price = 0;

    public MenuItems() {
        /*Sections of Menu*/
        Seafood = new Menu(null, 0, "Seafood");
        Salads = new Menu(null, 0, "Salads");
        pizaa = new Menu(null, 0, "pizaa");

        /*Item of Seafood*/
        Salmon = new Menu("Salmon", 280, "Seafood");
        SeafoodProvencal = new Menu("Seafood Provencal", 260, "Seafood");
        ShrimpCrabPlate = new Menu("Shrimp CrabPlate", 245, "Seafood");
        SeafoodCurry = new Menu("Seafood Curry", 250, "Seafood");

        /*Item of Salads*/
        CeasrSalad = new Menu("Ceasr Salad", 125, "Salads");
        ChickenQuinoa = new Menu("Chicken Quinoa", 130, "Salads");
        SalmonSeeds = new Menu("Salmon Seeds", 245, "Salads");
        CitusSalad = new Menu("Citus Salad", 250, "Salads");
        /*Item of pizaa*/
        Margarita = new Menu("Margarita", 110, "pizaa");
        ChickenBBQ = new Menu("Chicken BBQ", 145, "pizaa");
        SeaFoodPizaa = new Menu("Seafood", 225, "pizaa");

        Seafood.add(Salmon);
        Seafood.add(SeafoodProvencal);
        Seafood.add(ShrimpCrabPlate);
        Seafood.add(SeafoodCurry);

        Salads.add(CeasrSalad);
        Salads.add(ChickenQuinoa);
        Salads.add(SalmonSeeds);
        Salads.add(CitusSalad);

        pizaa.add(Margarita);
        pizaa.add(ChickenBBQ);
        pizaa.add(SeaFoodPizaa);

        //order=new ArrayList<>();
    }

    public void show() {

        int x = 1;
        int j = 1;
        int z = 1;
        int i = 0;

        while (a < 4) {
            System.out.println("1-" + Seafood.getSectionName());
            System.out.println("2-" + Salads.getSectionName());
            System.out.println("3-" + pizaa.getSectionName());

            a = s.nextInt();

            int count = 0, con = 0;
            if (a == 1) {

                for (Menu m2 : Seafood.getSubordinates()) {
                    con++;
                    System.out.println(con + ")" + m2.showItems());

                }
                while (x < 5) {
                    System.out.println("Enter what the Item you Want..");
                    x = s.nextInt();
                    if (x == 1) {
                        b = new Salmon(b);
                        order.add(b);
                        oo.add(new Salmon().dd());
                        menu.add(Salmon);
                    }
                    if (x == 2) {
                        b = new SeafoodProvencal(b);
                        order.add(b);
                        oo.add(new SeafoodProvencal().dd());
                        menu.add(SeafoodProvencal);
                    }
                    if (x == 3) {
                        b = new ShrimpCrabPlate(b);
                        order.add(b);
                        menu.add(ShrimpCrabPlate);
                        oo.add(new ShrimpCrabPlate().dd());
                    }
                    if (x == 4) {
                        b = new SeafoodCurry(b);
                        order.add(b);
                        menu.add(SeafoodCurry);
                        oo.add(new ShrimpCrabPlate().dd());
                    }

                }
            }
            if (a == 2) {
                for (Menu m2 : Salads.getSubordinates()) {
                    count++;
                    System.out.println(count + ")" + m2.showItems());

                }
                while (j < 5) {
                    System.out.println("Enter what the Item you Want..");
                    j = s.nextInt();
                    if (j == 1) {
                        b = new CeasrSalad(b);
                        order.add(new CeasrSalad(b));
                        menu.add(CeasrSalad);
                        oo.add(new CeasrSalad().dd());
                    }
                    if (j == 2) {
                        b = new ChickenQuinoa(b);
                        order.add(b);
                        menu.add(ChickenQuinoa);
                        oo.add(new ChickenQuinoa().dd());
                    }
                    if (j == 3) {
                        b = new SalmonSeeds(b);
                        order.add(b);
                        menu.add(SalmonSeeds);
                        oo.add(new SalmonSeeds().dd());
                    }
                    if (j == 4) {
                        b = new CitusSalad(b);
                        order.add(b);
                        menu.add(CitusSalad);
                        oo.add(new CitusSalad().dd());
                    }

                }
            }
            if (a == 3) {

                for (Menu m2 : pizaa.getSubordinates()) {
                    con++;
                    System.out.println(con + ")" + m2.showItems());

                }

                while (z < 4) {
                    System.out.println("Enter what the Item you Want..");
                    z = s.nextInt();
                    if (z == 1) {
                        b = new Margarita(b);
                        //order.add(b);
                        order.add(new Margarita());
                        oo.add(new Margarita().dd());
                        //counter_price+=pizaa.getPrice();
                        menu.add(Margarita);
                    }
                    if (z == 2) {
                        b = new ChickenBBQ(b);
                        //order.add(b);
                        order.add(new ChickenBBQ());
                        oo.add(new ChickenBBQ().dd());
                        //counter_price+=pizaa.getPrice();
                        menu.add(ChickenBBQ);
                    }
                    if (z == 3) {
                        b = new SeaFoodPizaa(b);
                        //order.add(b);
                        order.add(new SeaFoodPizaa());
                        oo.add(new SeaFoodPizaa().dd());
                        //counter_price+=pizaa.getPrice();
                        menu.add(SeaFoodPizaa);
                    }
                }
            }
        }
        System.out.println(b.decorate());
        //showOrder();

    }

    int k = 1;

    public void showOrder() {
        for (baseMeal bb : order) {
            System.out.println("\t\t\tAnd Added..");
            System.out.println(bb.decorate());
        }
    }

    public int calculate_total() {
        for (Menu m : menu) {
            counter_price += m.getPrice();
        }
        return counter_price;

    }

    public void pay(payment p) {
        p.Make_payment(counter_price);
    }
}
