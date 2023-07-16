package com.example.restrant;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResiptionistController {
    @FXML
    private Label createsucceesfully,cancel;

    @FXML
    private TextField numOfTable,numOfSeats,Fullname,phone,time,ShowNumIfSeats,numOfSeats1,numOfSeats2,Fullname1;
    @FXML
    private DatePicker date;
    @FXML
    private AnchorPane paneAddTable,panemodifytable,createReservationPane,cancelReservationPane;
    @FXML
    private ComboBox comboModifyTable,comboAvailableTable,cancelReservationCombo,selectedIdComboBox1;
    int val;
    //List l=new ArrayList(5);
    ArrayList <String>arrayList=new ArrayList<>();
    int selectedId;
    Database database=new Database();

    @FXML
    protected void AddToTable(ActionEvent event) {
        try {
            //val = Integer.parseInt(numOfTable.getText()) + Integer.parseInt(numOfSeats.getText());
            //System.out.println(val);
            database.insert_table(Integer.parseInt(numOfSeats.getText()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    protected void ShowAddTablePane(ActionEvent event) {
        paneAddTable.setVisible(true);//add table
        panemodifytable.setVisible(false);//modify table
        createReservationPane.setVisible(false);//create reservation
        cancelReservationPane.setVisible(false);//cancel reservation
    }

    //modify table
    @FXML
    protected void ModifyTable(ActionEvent event) throws Exception {
        database.update_table(selectedId,Integer.parseInt(numOfSeats1.getText().toString()));
    }


    @FXML
    protected void DeleteTable(ActionEvent event) throws Exception {
        database.delete_table(selectedId);
    }
    @FXML
    protected void ModifyTablePane(ActionEvent event) {
        panemodifytable.setVisible(true);//modify table
        paneAddTable.setVisible(false);//add table
        createReservationPane.setVisible(false);//create reservation
        cancelReservationPane.setVisible(false);//cancel reservation
        comboModifyTable.getItems().clear();//clear combobox
        arrayList.clear();//clear array list
        try {
                arrayList=database.get_table_id_id();
            }
        catch (Exception e){}

        comboModifyTable.getItems().addAll(arrayList);
    }
    @FXML
    protected void selectedIdComboBox() throws Exception {
        selectedId = Integer.parseInt(comboModifyTable.getValue().toString());

        int seat = database.get_table_id(selectedId);
        System.out.println("***************");
        System.out.println(seat);
        System.out.println("***************");
        numOfSeats1.setText(seat+"");
    }
    @FXML
    protected void selectedIdComboBox1() throws Exception {
        selectedId = Integer.parseInt(selectedIdComboBox1.getValue().toString());

        int seat = database.get_table_id(selectedId);
        System.out.println(seat);
        numOfSeats2.setText(seat+"");
    }

    //create reservation
    @FXML
    protected void createReservationPane(ActionEvent event) {
        createReservationPane.setVisible(true);//create reservation
        panemodifytable.setVisible(false);//modify table
        paneAddTable.setVisible(false);//add table
        cancelReservationPane.setVisible(false);//cancel reservation
//combo box
        selectedIdComboBox1.getItems().clear();//clear combobox
        arrayList.clear();//clear array list
        try {
            arrayList=database.get_table_id_id();
        }
        catch (Exception e){}

        selectedIdComboBox1.getItems().addAll(arrayList);
    }
    @FXML
    protected void createReservation(ActionEvent event) throws Exception {
        if(!Fullname.getText().equals("")&&!phone.getText().equals("")&&!time.getText().equals("")&&!date.getValue().equals(null)&&!numOfSeats2.getText().equals("")){
            database.insert_Reservation(Fullname.getText().toString(),Integer.parseInt(phone.getText().toString()),java.sql.Date.valueOf(java.time.LocalDate.now()), Time.valueOf(LocalTime.now()));
            database.delete_table(selectedId);
            createsucceesfully.setVisible(true);
        }

    }

    //cancel reservation
    @FXML
    protected void CancelReservationPane(ActionEvent event) {
        cancelReservationPane.setVisible(true);//cancel reservation
        createReservationPane.setVisible(false);//create reservation
        panemodifytable.setVisible(false);//modify table
        paneAddTable.setVisible(false);//add table
    }
    @FXML
    protected void cancelReservation(ActionEvent event) throws Exception {
        if(!Fullname1.getText().equals("")){
            database.delete_Reservation(Fullname1.getText().toString());
            cancel.setVisible(true);
        }else {
            cancel.setVisible(false);
        }
    }

    @FXML
    protected void CancelIdComboBox(){
        selectedId = (Integer) cancelReservationCombo.getValue();
        System.out.println(selectedId);
    }
    @FXML void backClicked(ActionEvent event){
        try {
            Parent my_root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Scene scene = new Scene(my_root, 1364, 707);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Home!");
            stage.setScene(scene);
        } catch (Exception e) {

        }
    }
}