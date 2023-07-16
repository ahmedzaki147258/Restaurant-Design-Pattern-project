package com.example.restrant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CashierController {

    @FXML
    private ComboBox comboavailableToPay;
    @FXML
    private Button cashBtn,creditBtn;

    @FXML
    private Label done,totalprice;

    WaiterController waiterController=new WaiterController();

    @FXML
    private void payCash(ActionEvent event){
        done.setVisible(true);
        done.setText("Done successfully with cash");
    }
    @FXML
    private void payCredit(ActionEvent event){
        done.setVisible(true);
        done.setText("Done successfully with credit");
    }
    @FXML
    private void showprice(ActionEvent event){
        int p=waiterController.calculate_total();
        totalprice.setText(p+"");
    }

    //back
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