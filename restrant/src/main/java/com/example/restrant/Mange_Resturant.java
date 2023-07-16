package com.example.restrant;

import java.util.Scanner;

public class Mange_Resturant {

    Scanner s = new Scanner(System.in);
    private static Mange_Resturant m = null;
    Database db = new Database();

    private Mange_Resturant() {
    }

    public static int price = 0;

    public static Mange_Resturant get_instance() {
        if (m == null) {
            m = new Mange_Resturant();
        }
        return m;
    }

    public void Mange() throws Exception {
        MenuItems me = new MenuItems();
        Receptionist r = new Receptionist();
        int a = 1;

        while (a < 6) {
            System.out.println("[1]Manager");
            System.out.println("[2]Receiptionist");
            System.out.println("[3]Waiter");
            System.out.println("[4]Chef");
            System.out.println("[5]Cashier");

            a = s.nextInt();
            if (a == 1) {
                Manager manger = new Manager();
                System.out.println("[1]ModifyMenu");
                System.out.println("[2]ModifyWorker");
                int l = s.nextInt();
                if (l == 1) {
                    manger.Modify_Menu();
                }
                if (l == 2) {
                    manger.Modify_Worker();
                }
            }
            if (a == 2) {
                int x = 1;
                while (x < 5) {
                    System.out.println("[1]add Table");
                    System.out.println("[2]Modify Table");
                    System.out.println("[3]Creat reservation");
                    System.out.println("[4]Cancel reservation");
                    x = s.nextInt();
                    if (x == 1) {
                        r.add_table();
                    }
                    if (x == 2) {
                        r.Modifay();
                    }
                    if (x == 3) {
                        r.Creat_Reservation();
                    }
                    if (x == 4) {
                        r.cancel_reservation();
                    }
                }
            }
            if (a == 3) {
                System.out.println("[1]add Order");
                System.out.println("[2]Modify Order");
                int g = s.nextInt();
                int i = 0;
                if (g == 1) {
                    db.get_table_res();
                    //db.get_Reservation();
                    System.out.println("Enter Id of your table");
                    int k = s.nextInt();
                   // i = db.get_table_id(k);
                    i=db.get_table_res(k);
                    System.out.println(i);
                    int u = 0, p = 1;
                    int rr = 0;
                    while (u < i) {
                        System.out.println("The order of Seat : " + p);
                        me = new MenuItems();
                        me.show();
                        u++;
                        rr++;
                        p++;
                        if (rr < u) {
                            for (int t = 0; u < me.oo.size(); t++) {
                                System.out.println(me.oo.get(t));
                            }
                        }
                        price = me.calculate_total();
                    }
                }

                int cou = 0;
                if (g == 2) {
                    int n = 0;
                    System.out.println("The order is: ");

                    for (int u = 0; u < me.oo.size(); u++) {
                        cou++;
                        System.out.println("[" + cou + "]" + me.oo.get(u));
                    }
                    //System.out.println(me.order.get(me.order.size()-1));
                    System.out.println("[1]Update");
                    System.out.println("[2]Add");
                    int w = s.nextInt();
                    if (w == 1) {
                        System.out.println("Enter Number of Meal you want to update: ");
                        int p = s.nextInt();
                        me.oo.remove(me.oo.get(p - 1));
                        MenuItems menuItems = new MenuItems();
                        menuItems.show();
                        System.out.println("\t\tAnd");
                        for (int u = 0; u < me.oo.size(); u++) {
                            n++;
                            System.out.println("[" + n + "]" + me.oo.get(u));
                        }

                    }
                    if (w == 2) {
                        MenuItems menuItems = new MenuItems();
                        menuItems.show();
                        System.out.println("\t\tAnd");
                        for (int u = 0; u < me.oo.size(); u++) {
                            n++;
                            System.out.println("[" + n + "]" + me.oo.get(u));
                        }
                    }

                }
            }

            int count = 0;
            if (a == 4) {
                for (int u = 0; u < me.oo.size(); u++) {
                    count++;
                    System.out.println("[" + count + "]" + me.oo.get(u));
                }
                System.out.println("Enter Number of Meal you work in: ");
                int g = s.nextInt();
                me.oo.remove(me.oo.get(g - 1));
                System.out.println("\t\t\tThe available Meal..");

                for (int u = 0; u < me.oo.size(); u++) {
                    count++;
                    System.out.println("[" + count + "]" + me.oo.get(u));
                }
            }

            if (a == 5) {
                System.out.println("\t\t\t\t the order price is " + price);
                System.out.println("[1]Pay by credit card");
                System.out.println("[2]Pay by check or cash");
                int o = s.nextInt();
                if (o == 1) {
                    me.pay(new credit_card());
                }
                if (o == 2) {
                    me.pay(new Cash());
                }

            }

        }

    }

}
