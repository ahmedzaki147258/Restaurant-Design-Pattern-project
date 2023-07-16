/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.restrant;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    private static Database instance = new Database();
    private Connection connection;

    public static void main(String[] args) throws SQLException, Exception {
        getConnection();
    }

    Database() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/menu_orders", "root", "732001");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Database getinstance() {
        return instance;
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/menu_orders";
        String user = "root";
        String password = "";
        if (instance.connection == null) {
            instance.connection = DriverManager.getConnection(url, user, password);
        }
        return instance.connection;
    }

    ///query
    public ResultSet query(String query) throws SQLException {
        ResultSet resultset = query(query);
        if (resultset.next()) {
            return resultset;
        }
        return null;
    }

    public static void insertOrUpdate(String query) throws SQLException {
        Connection myconn = Database.getConnection();
        Statement mystmt = myconn.createStatement();
        mystmt.executeUpdate(query);
    }

    /**
     * **************************************
     */
    public ArrayList<String> get_table() throws Exception {
        try {
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM `table`");
            ResultSet result = statement.executeQuery();
            ArrayList<String> array = new ArrayList<String>();
            while (result.next()) {
                System.out.print(result.getInt("tableId"));
                System.out.print(" ");
                System.out.println(result.getInt("numofseatspereachtable"));
                array.add(result.getString("numofseatspereachtable"));
            }
            System.out.println("All records have been selected!");
            return array;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<String> get_table_res() throws Exception {
        try {
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM `table_reservation`");
            ResultSet result = statement.executeQuery();
            ArrayList<String> array = new ArrayList<String>();
            while (result.next()) {
                System.out.print(result.getInt("id_res_table"));
                System.out.print(" ");
                System.out.println(result.getInt("numofseats_res_table"));
                array.add(result.getString("numofseats_res_table"));
            }
            System.out.println("All records have been selected!");
            return array;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
   

    /**
     * **************************************
     */
    public int get_table_id(int id) throws Exception {
        try {
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM `table` where `tableId` ='" + id + "' ");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                return result.getInt("numofseatspereachtable");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;

    }
 public int get_table_res(int id_res_table) throws Exception {
        try {
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM `table_reservation` where `id_res_table` ='" + id_res_table+ "' ");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                return result.getInt("numofseats_res_table");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;

    }
    /**
     * **************************************
     */
    public void insert_table(int numofseats) throws Exception {
        try {
            Connection con = getConnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO `table` ( numofseatspereachtable) VALUES ( '" + numofseats + "')");
            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Insert Completed.");
        }
    }
    
    ///
    public void insert_table_res(int id_res_table,int numofseats_res_table ) throws Exception {
        try {
            Connection con = getConnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO `table_reservation` (id_res_table,numofseats_res_table ) VALUES ( '" + id_res_table + "','" + numofseats_res_table + "')");
            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Insert Completed.");
        }
    }

    /**
     * **************************************
     */
    public void update_table(int id, int numofseats) throws Exception {
        try {
            Connection con = getConnection();
            String sql = "Update `table` set numofseatspereachtable='" + numofseats + "' where tableId='" + id + "' ";
            PreparedStatement posted = con.prepareStatement(sql);
            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("updated ");
        }
    }

    /**
     * **************************************
     */
    public void delete_table(int id) throws Exception {
        try {
            Connection con = getConnection();
            PreparedStatement posted = con.prepareStatement(" delete  from `table` where tableId='" + id + "' ;");
            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("deleted ");
        }
    }

    /**
     * **************************************
     */
    public void get_Reservation() throws Exception {
        try {
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM reservation");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                System.out.println(result.getInt("id_res"));
                System.out.println(result.getString("name"));
                System.out.println(result.getInt("phone"));
                System.out.println(result.getDate("date"));
                System.out.println(result.getTime("Time"));
                
                System.out.println(" ");
            }
            System.out.println("All records have been selected!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * **************************************
     */
    public void insert_Reservation(String name, int phone, Date date, Time time) throws Exception {
        try {
            Connection con = getConnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO  reservation(name,phone,date,Time ) VALUES ('" + name + "', '" + phone + "','" + date + "', '" + time + "')");
            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Insert Completed.");
        }
    }

    /**
     * **************************************
     */
    public void delete_Reservation(String name) throws Exception {
        try {
            Connection con = getConnection();
            PreparedStatement posted = con.prepareStatement(" delete  from reservation where name='" + name + "' ;");
            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("deleted ");
        }
    }

    public ArrayList<String> get_table_id_id() throws Exception {
        try {
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM `table`");
            ResultSet result = statement.executeQuery();
            ArrayList<String> array = new ArrayList<String>();
            while (result.next()) {
                System.out.print(result.getInt("tableId"));
                System.out.print(" ");
                System.out.println(result.getInt("numofseatspereachtable"));
                array.add(result.getString("tableid"));
            }
            System.out.println("All records have been selected!");
            return array;
        }catch (Exception e){System.out.println(e); }
        return null;
    }

    /**
     * **************************************
     */
    public void delete_Reservation_id(int id) throws Exception {
        try {
            Connection con = getConnection();
            PreparedStatement posted = con.prepareStatement(" delete  from reservation where id_res ='" + id + "' ;");
            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("deleted ");
        }
    }
    /*//////
    

    /**
     * **************************************
     */
    public void insert_worker(String name, String job, int salary) throws Exception {
        try {
            Connection con = getConnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO `worker` ( name,job,salary) VALUES ( '" + name + "' , '" + job + "' , '" + salary + "')");
            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Insert Completed.");
        }
    }

    /**
     * **************************************
     */
    public void delete_worker(int id) throws Exception {
        try {
            Connection con = getConnection();
            PreparedStatement posted = con.prepareStatement(" delete  from worker where id ='" + id + "' ;");
            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("deleted ");
        }
    }

    /**
     * **************************************
     */
    public void update_worker(int id, String name, String job, int salary) throws Exception {
        try {
            Connection con = getConnection();
            String sql = "Update `worker` set name='" + name + "',job='" + job + "',salary='" + salary + "' where id='" + id + "' ";
            PreparedStatement posted = con.prepareStatement(sql);
            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("updated ");
        }
    }

    public void get_worker() throws Exception {
        try {
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM `worker`");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                System.out.print("Id: " + result.getInt("id") + ", ");
                System.out.println("Name: " + result.getString("name"));
                System.out.print(" ");
                System.out.println("Job: " + result.getString("job"));
                System.out.print(" ");
                System.out.println("Salary: " + result.getInt("salary"));
                System.out.println("*******");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
