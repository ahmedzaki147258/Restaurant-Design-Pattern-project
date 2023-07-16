/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restrant;

import java.sql.Time;
//import java.util.ArrayList;
import java.util.Date;
//import java.util.List;
import java.sql.*;
//import java.time.Instant;
//import java.sql.*;
import java.time.LocalTime;
//import static restaurant.management.system.Database.getConnection;

public class Reservation {

    String full_Name;
    int phone;
    Time time;
    Date date;
    Table table;
    ;

    Database db = new Database();

    public Reservation(String full_Name, int phone, Date date, Time time, int t1, int t2) throws SQLException, Exception {
        this.full_Name = full_Name;
        this.phone = phone;
        this.date = date;
        this.time = time;
        //  reserve = new ArrayList<>();

        //db.insert_table(t1.table_number,t1.num_of_seats);
        db.insert_table(t2);

    }

    public void add(Reservation r) throws Exception {
        //     insert_Reservation("ahmed",123,Date.valueOf(java.time.LocalDate.now()),Time.valueOf(LocalTime.now()));
        db.insert_Reservation(r.full_Name, r.phone, java.sql.Date.valueOf(java.time.LocalDate.now()), Time.valueOf(LocalTime.now()));

    }

    public void getReserve() throws Exception {
        db.get_Reservation();
    }

    public void remove(Reservation r) throws Exception {
        db.delete_Reservation(r.full_Name);
    }

   /* public void BookNow1(Table t) throws Exception {
        db.delete_table(t.getTable_number());
    }

    public void BookNow(Reservation r, Table t) throws Exception {
        add(r);
        db.delete_table(t.getTable_number());
    }*/

    public void Cancel_reservation(Reservation r, Table t) throws Exception {
        db.delete_Reservation(r.full_Name);
        db.insert_table(t.getNum_of_seats());
    }

    public void reservation_details() {
        System.out.println("customer Name: " + this.full_Name + "\t customer phone: " + this.phone + "The Date is: " + this.date + "The time is: ");
    }

    public void show() throws Exception {
        System.out.println("\t \t the available tables");
        db.get_Reservation();
    }
}
