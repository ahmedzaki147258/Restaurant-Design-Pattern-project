/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restrant;

/**
 *
 * @author Nourhan Maher
 */
public class credit_card implements payment{

    @Override
    public void Make_payment(int n) {
        System.out.println("You pay by credit_card... "+n);
    }
    
}
