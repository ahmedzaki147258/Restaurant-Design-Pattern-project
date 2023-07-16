
package com.example.restrant;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AlmazaCityCenter implements ResturantBranches {

    MenuItems m = new MenuItems();

    @Override
    public void disply() {

        System.out.println("Come Dine with Us in Almaza City Center");
        Mange_Resturant man = Mange_Resturant.get_instance();
        try {
            man.Mange();
        } catch (Exception ex) {
            Logger.getLogger(AlmazaCityCenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
