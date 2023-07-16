
package com.example.restrant;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
import java.util.Scanner;


public class Receptionist {
    
    Table t;
    Scanner s=new Scanner(System.in);
    int n;
    Database db = new Database(); 
   private Reservation res;
   ///Table
   
    public void add_table() throws Exception
    {
         int counter=0;
         System.out.println("how many tables do you want to add?");
         n=s.nextInt();//all added tables;
        for(int i=1;i<=n;i++){
        counter++;
        System.out.println("Enter Number of seats table"+counter);
        int b=s.nextInt();
        t=new Table( b);
        t.add(t);

        }
       System.out.println("\t \t the available tables");

            t.show_availble_table();
    }

    public void Modifay() throws SQLException, Exception{
        System.out.println("\t \t the available tables");

             t.show_availble_table();
            System.out.println("[1]Update");
            System.out.println("[2]delete");
            int w=s.nextInt();
            if(w==1){  
                System.out.println("Enter The Id of Table you want to Update: ");
                int g=s.nextInt();
               //System.out.println(table.get_table(g-1));  
            System.out.println("Enter New Number of site: ");
            int a2=s.nextInt();
            db.update_table(g,a2);
                System.out.println("The New available Table ");
                db.get_table();
            }
            if(w==2)
            {

            System.out.println("Enter Id of Table you want to delet: ");
            int a1=s.nextInt();
            db.delete_table(a1);
            db.get_table();
            }
        }


    public void Creat_Reservation() throws SQLException, Exception{
        System.out.println("Enter Full_Name: ");
        Scanner s=new Scanner(System.in);
        String full_name=s.nextLine();
        System.out.println("Enter phonenumber: ");
        int phone= s.nextInt();
        Show_table(); 
        System.out.println("Enter Id of table you want to reserve: ");
        int y=s.nextInt(); //tableid  
        res=new Reservation(full_name, phone, Date.valueOf(java.time.LocalDate.now()), Time.valueOf(LocalTime.now()),y,0);
        //res.add(res);
       // reserve.add(res);

        db.insert_Reservation(full_name, phone, Date.valueOf(java.time.LocalDate.now()), Time.valueOf(LocalTime.now()));
        db.insert_table_res(y,db.get_table_id(y));
        System.out.println("Table reservation");
        db.get_table_res();
        db.delete_table(y);
         System.out.println("Table available");
            db.get_table();

        show_reservation();
       // res.show();
        Show_table();

    }

    public void cancel_reservation() throws Exception
    {
        show_reservation();
        System.out.println("Enter Id of Reservation you want to cancel: ");
        int p=s.nextInt();
     //   reserve.remove(reserve.get(p-1));
        db.delete_Reservation_id(p);
        //table.add(table.get_table(p-1));
        show_reservation();
    //    Show_table();

    }


   

      public void show_reservation() throws Exception{
          System.out.println("\t \t the available Reservation");
          db.get_Reservation();
      }
      
         public void Show_table() throws Exception{
          System.out.println("\t \t the available tables");

          t.show_availble_table();

      }
}
