package com.example.restrant;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Heliopolis implements ResturantBranches {

    @Override
    public void disply() {
        System.out.println("Come Dine with Us in Heliopolis");
        Mange_Resturant man = Mange_Resturant.get_instance();
        try {
            man.Mange();
        } catch (Exception ex) {
            Logger.getLogger(Heliopolis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
