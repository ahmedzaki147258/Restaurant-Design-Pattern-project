
package com.example.restrant;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RiverWalk implements ResturantBranches{
MenuItems m=new MenuItems();
    @Override
    public void disply() {
        System.out.println("Come Dine with Us in River Walk"); 
   
       Mange_Resturant man=Mange_Resturant.get_instance();
    try {
        man.Mange();
    } catch (Exception ex) {
        Logger.getLogger(RiverWalk.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
}
