/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restrant;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nourhan Maher
 */
public class MadinatyOpenAirMall implements ResturantBranches{
    @Override
    public void disply() {
       System.out.println("Come Dine with Us in Madinaty Open Air Mall"); 
    //MenuItems m=new MenuItems();
       Mange_Resturant man=Mange_Resturant.get_instance();
        try {
            man.Mange();
        } catch (Exception ex) {
            Logger.getLogger(MadinatyOpenAirMall.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
