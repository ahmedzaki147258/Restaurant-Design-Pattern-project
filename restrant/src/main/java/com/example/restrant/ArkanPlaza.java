package com.example.restrant;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ArkanPlaza implements ResturantBranches {

    MenuItems m = new MenuItems();

    @Override
    public void disply() {
        System.out.println("Come Dine with Us in Arkan Plaza");
        Mange_Resturant man = Mange_Resturant.get_instance();
        try {
            man.Mange();
        } catch (Exception ex) {
            Logger.getLogger(ArkanPlaza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
