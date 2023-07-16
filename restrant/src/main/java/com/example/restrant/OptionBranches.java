package com.example.restrant;

import java.util.Scanner;

public class OptionBranches {

    public void getOption() {

        System.out.println("Come Dine with Us...\n");

        Scanner s = new Scanner(System.in);
        int a = 1;
        while (a < 7) {
            System.out.println("1-Almaza City Center");
            System.out.println("2-Cairo Festival City");
            System.out.println("3-River Walk");
            System.out.println("4-Heliopolis");
            System.out.println("5-Arkan Plaza");
            System.out.println("6-Madinaty Open Air Mall\n");
            System.out.println("Enter what the Branch you want: ");
            a = s.nextInt();

            //int b=s.nextInt();
            if (a == 1) {
                BranchesFactory b = new BranchesFactory();
                ResturantBranches Almaza = b.getBranch("Almaza City Center");
                Almaza.disply();
            }
            if (a == 2) {
                BranchesFactory b = new BranchesFactory();
                ResturantBranches Almaza = b.getBranch("Cairo Festival City");
                Almaza.disply();
            }
            if (a == 3) {
                BranchesFactory b = new BranchesFactory();
                ResturantBranches Almaza = b.getBranch("River Walk");
                Almaza.disply();
            }
            if (a == 4) {
                BranchesFactory b = new BranchesFactory();
                ResturantBranches Almaza = b.getBranch("Heliopolis");
                Almaza.disply();
            }
            if (a == 5) {
                BranchesFactory b = new BranchesFactory();
                ResturantBranches Almaza = b.getBranch("Arkan Plaza");
                Almaza.disply();
            }
            if (a == 6) {
                BranchesFactory b = new BranchesFactory();
                ResturantBranches Almaza = b.getBranch("Madinaty Open Air Mall");
                Almaza.disply();
            }
        }
    }
}
