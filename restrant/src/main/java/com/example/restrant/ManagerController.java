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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ManagerController {
    @FXML
    private TextField newFood, price,idworker,name,job,salary;
    @FXML
    private Label add;
    @FXML
    private AnchorPane panemenu,workerpane;
    @FXML
    private ComboBox foodcombox;
    private ArrayList <String>arrayList=new ArrayList<>();
    String id;
    Database database=new Database();
    MenuItems menuItems=new MenuItems();
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
    @FXML
    void SectionChoose(ActionEvent event){
        Button button=(Button) event.getSource();
        panemenu.setVisible(true);
        id = button.getId();
        if(id.equals("salad")){
            foodcombox.getItems().clear();//clear combobox
            arrayList.clear();//clear array list
            //setSelectbox
            for (Menu m2 : menuItems.Salads.getSubordinates()) {
                  arrayList.add(m2.showItems());
            }
            foodcombox.getItems().addAll(arrayList);
        }else if(id.equals("pizza")){
            foodcombox.getItems().clear();//clear combobox
            arrayList.clear();//clear array list
            for (Menu m2 : menuItems.pizaa.getSubordinates()) {
                arrayList.add(m2.showItems());
            }
            foodcombox.getItems().addAll(arrayList);
        }else if(id.equals("seefood")){
            foodcombox.getItems().clear();//clear combobox
            arrayList.clear();//clear array list
            for (Menu m2 : menuItems.Seafood.getSubordinates()) {
                arrayList.add(m2.showItems());
            }
            foodcombox.getItems().addAll(arrayList);
        }
    }
    @FXML
    void AddFood(ActionEvent event){
        if(!newFood.getText().equals("")&&!price.getText().equals("")){
            //add
            Menu menu = new Menu(newFood.getText().toString(), Integer.parseInt(price.getText().toString()), null);
            if(id.equals("salad")) {
                menuItems.Salads.add(menu);
            }else if(id.equals("pizza")){
                menuItems.pizaa.add(menu);
            } else if (id.equals("seefood")) {
                menuItems.Seafood.add(menu);
            }
            add.setVisible(true);
            //System.out.println(newFood.getText()+Float.parseFloat(price.getText())+" "+foodcombox.getValue());
        }
    }

    @FXML
    protected void menumodifyPane(ActionEvent event) {
        panemenu.setVisible(true);//menu reservation
        workerpane.setVisible(false);//worker table
    }
    @FXML
    protected void workermodifyPane(ActionEvent event) {
        panemenu.setVisible(false);//menu reservation
        workerpane.setVisible(true);//worker table
    }
    @FXML
    protected void addWorker() throws Exception {
        if(!name.getText().equals("")&&!job.getText().equals("")&&!salary.getText().equals("")){
            database.insert_worker(name.getText().toString(),job.getText().toString(),Integer.parseInt(salary.getText().toString()));
        }
    }

    @FXML
    protected void updateWorker() throws Exception {
        if(!name.getText().equals("")&&!job.getText().equals("")&&!salary.getText().equals("")&&!idworker.getText().equals("")){
            database.update_worker(Integer.parseInt(idworker.getText().toString()),name.getText().toString(),job.getText().toString(),Integer.parseInt(salary.getText().toString()));
        }
    }

    @FXML
    protected void deleteWorker() throws Exception {
        if(!idworker.getText().equals("")){
            database.delete_worker(Integer.parseInt(idworker.getText().toString()));
        }
    }
}
