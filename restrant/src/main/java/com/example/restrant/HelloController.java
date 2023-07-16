package com.example.restrant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class HelloController {
    String branch,worker="";
    @FXML
    private AnchorPane WorkersPane;
    @FXML
    protected void onPressedMainPage(ActionEvent event) {
        Button b=(Button) event.getSource();
        String id = b.getId();
        //change style on click
        b.setStyle("-fx-background-color: #F44336FF");
        b.setTextFill(Paint.valueOf("#fff"));

        //set branch
        if(id.equals("almaza")||id.equals("festival")||id.equals("river")||id.equals("Heliopolis")||id.equals("ArkanPlaza")||id.equals("MadinatyOpenAirMall")){
            branch=id;
        }
        else if(id.equals("waiter")||id.equals("Cashier")||id.equals("Manager")||id.equals("Chef")||id.equals("Receiptionist")){
            worker=id;
        }
        //show workers
        if(!branch.equals("")){
            WorkersPane.setVisible(true);
        }
        //change scene worker
        if(!worker.equals("")&&!branch.equals("")){
            if(id.equals("waiter")) {
                try {
                    Parent my_root = FXMLLoader.load(getClass().getResource("waiter.fxml"));
                    Scene scene = new Scene(my_root, 1364, 707);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setTitle("Waiter!");
                    stage.setScene(scene);
                } catch (Exception e) {

                }
            }

            else if(id.equals("Receiptionist")) {
                try {
                    Parent my_root = FXMLLoader.load(getClass().getResource("Receptionist.fxml"));
                    Scene scene = new Scene(my_root, 1364, 707);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setTitle("Receptionist!");
                    stage.setScene(scene);
                } catch (Exception e) {

                }
            }

            else if(id.equals("Cashier")) {
                try {
                    Parent my_root = FXMLLoader.load(getClass().getResource("Cashier.fxml"));
                    Scene scene = new Scene(my_root, 1364, 707);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setTitle("Cashier!");
                    stage.setScene(scene);
                } catch (Exception e) {

                }
            }

            else if(id.equals("Manager")) {
                try {
                    Parent my_root = FXMLLoader.load(getClass().getResource("Manager.fxml"));
                    Scene scene = new Scene(my_root, 1364, 707);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setTitle("Manager!");
                    stage.setScene(scene);
                } catch (Exception e) {

                }
            }

            else if(id.equals("Chef")) {
                try {
                    Parent my_root = FXMLLoader.load(getClass().getResource("Chef.fxml"));
                    Scene scene = new Scene(my_root, 1364, 707);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setTitle("Manager!");
                    stage.setScene(scene);
                } catch (Exception e) {

                }
            }

        }
    }

}