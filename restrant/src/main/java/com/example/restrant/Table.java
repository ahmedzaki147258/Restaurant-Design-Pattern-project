package com.example.restrant;

import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

class Table {

  private int table_number;
  private int num_of_seats;
    Database db = new Database();

    public Table(int num_of_seats) throws Exception {
        this.num_of_seats = num_of_seats;

    }

    public void setTable_number(int table_number) {
        this.table_number = table_number;
    }

    public void setNum_of_seats(int num_of_seats) {
        this.num_of_seats = num_of_seats;
    }

    public void setTable(Database db) {
        this.db = db;

    }

    public int getTable_number() {
        return table_number;
    }

    public int getNum_of_seats() {
        return num_of_seats;
    }

    public void update(Table T) throws SQLException, Exception {
        db.update_table(T.table_number, T.num_of_seats);
    }

    public void add(Table T) throws SQLException, Exception {
        db.insert_table(T.num_of_seats);
    }

    public void delet(Table T) throws SQLException, Exception {
        db.delete_table(T.table_number);
    }
    int count = 0;

    public void show_availble_table() throws SQLException, Exception {
        db.get_table();
    }

}
