package com.example.restrant;

public class Cash implements payment {

    @Override
    public void Make_payment(int n) {
        System.out.println("You pay cash... " + n);
    }

}
