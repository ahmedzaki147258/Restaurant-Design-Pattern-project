package com.example.restrant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ChefController {
    List<String> arrayList=new ArrayList<>();
    @FXML
    private ComboBox combo;
    @FXML
    void show(ActionEvent event){
        combo.getItems().clear();//clear combobox
        arrayList.clear();//clear array list
        try {
            arrayList=WaiterController.oo;
        } catch (Exception e) {
        }

        combo.getItems().addAll(arrayList);
    }

    @FXML
    void backClicked(ActionEvent event){
        try{
            Parent my_root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Scene scene = new Scene(my_root, 1364, 707);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Manager!");
            stage.setScene(scene);
        } catch (Exception e) {

        }
    }
}
