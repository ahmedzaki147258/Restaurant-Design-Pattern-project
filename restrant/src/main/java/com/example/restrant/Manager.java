package com.example.restrant;

import java.util.Scanner;

public class Manager {

    Scanner s = new Scanner(System.in);
    static MenuItems m = new MenuItems();
    Menu menu;
    Database db = new Database();

    public void Modify_Worker() throws Exception {

        while (true) {
            System.out.println("The available Workers");
            db.get_worker();
            System.out.println("[1]Add Worker");
            System.out.println("[2]Updat Worker");
            System.out.println("[3]Delete Worker");
            int q = s.nextInt();
            if (q == 1) {
                System.out.println("Enter name");
                String name = s.next();
                System.out.println("Enter job");
                String job = s.next();
                System.out.println("Enter salary");
                int salary = s.nextInt();
                db.insert_worker(name, job, salary);
                db.get_worker();
            }
            if (q == 2) {
                System.out.println("Enter Id for update worker");
                int id = s.nextInt();
                System.out.println("Enter name");
                String name = s.next();
                System.out.println("Enter job");
                String job = s.next();
                System.out.println("Enter salary");
                int salary = s.nextInt();
                db.update_worker(id, name, job, salary);
                db.get_worker();
            }
            if (q == 3) {
                System.out.println("Enter Id for delete worker");
                int id = s.nextInt();
                db.delete_worker(id);
                db.get_worker();
            } else {
                break;
            }
        }

    }

    public void Modify_Menu() {
        int a = 1, count = 0;
        while (a < 4) {
            System.out.println("1-" + m.Seafood.getSectionName());
            System.out.println("2-" + m.Salads.getSectionName());
            System.out.println("3-" + m.pizaa.getSectionName());
            System.out.println("Enter the section you want to modifay: ");
            a = s.nextInt();
            if (a == 1) {
                for (Menu m2 : m.Seafood.getSubordinates()) {
                    count++;
                    System.out.println(count + ")" + m2.showItems());
                }
                System.out.println("Enter New Section: ");
                String sec = s.next();
                System.out.println("Enter New Item: ");
                String item = s.next();
                System.out.println("Enter New price: ");
                int price = s.nextInt();
                menu = new Menu(item, price, sec);
                m.Seafood.add(menu);
              //  m.show();
            }
            if (a == 2) {
                for (Menu m2 : m.Salads.getSubordinates()) {
                    count++;
                    System.out.println(count + ")" + m2.showItems());
                }
                System.out.println("Enter New Section: ");
                String sec = s.next();
                System.out.println("Enter New Item: ");
                String item = s.next();
                System.out.println("Enter New price: ");
                int price = s.nextInt();
                menu = new Menu(item, price, sec);
                m.Salads.add(menu);
              //  m.show();
            }
            if (a == 3) {
                for (Menu m2 : m.pizaa.getSubordinates()) {
                    count++;
                    System.out.println(count + ")" + m2.showItems());
                }
                System.out.println("Enter New Section: ");
                String sec = s.nextLine();
                System.out.println("Enter New Item: ");
                String item = s.nextLine();
                System.out.println("Enter New price: ");
                int price = s.nextInt();
                menu = new Menu(item, price, sec);
                m.pizaa.add(menu);
               // m.show();
            }
        }
    }

}
