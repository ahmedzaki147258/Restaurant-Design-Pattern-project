package com.example.restrant;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CairoFestivalCity implements ResturantBranches {

    @Override
    public void disply() {
        System.out.println("Come Dine with Us in Cairo Festival City");
        Mange_Resturant man = Mange_Resturant.get_instance();
        try {
            man.Mange();
        } catch (Exception ex) {
            Logger.getLogger(CairoFestivalCity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
