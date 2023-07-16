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
import java.util.List;

public class WaiterController {
    @FXML
    private AnchorPane addOrderPane,modifypane;
    static List<baseMeal> order = new ArrayList<>();
    static List<String> oo = new ArrayList<>();
    static List<Menu> menu = new ArrayList<>();
    int seat;
    Menu Seafood;
    Menu Salads;
    Menu pizaa;
    Menu Salmon;
    Menu SeafoodProvencal;
    Menu ShrimpCrabPlate;
    Menu SeafoodCurry;
    Menu CeasrSalad;
    Menu ChickenQuinoa;
    Menu SalmonSeeds;
    Menu CitusSalad;
    Menu Margarita;
    Menu ChickenBBQ;
    Menu SeaFoodPizaa;
    baseMeal b = new firstMeal();
    @FXML
    private ComboBox comboTableId,foodcombox;
    String id;
    MenuItems menuItems=new MenuItems();
    @FXML
    private TextField numOfSeats;
    @FXML
    private Label show;
    Database database=new Database();
    int SelectedId;
    ArrayList<String> arrayList=new ArrayList<>();

    private void MenuItems() {
        /*Sections of Menu*/
        Seafood = new Menu(null, 0, "Seafood");
        Salads = new Menu(null, 0, "Salads");
        pizaa = new Menu(null, 0, "pizaa");

        /*Item of Seafood*/
        Salmon = new Menu("Salmon", 280, "Seafood");
        SeafoodProvencal = new Menu("Seafood Provencal", 260, "Seafood");
        ShrimpCrabPlate = new Menu("Shrimp CrabPlate", 245, "Seafood");
        SeafoodCurry = new Menu("Seafood Curry", 250, "Seafood");

        /*Item of Salads*/
        CeasrSalad = new Menu("Ceasr Salad", 125, "Salads");
        ChickenQuinoa = new Menu("Chicken Quinoa", 130, "Salads");
        SalmonSeeds = new Menu("Salmon Seeds", 245, "Salads");
        CitusSalad = new Menu("Citus Salad", 250, "Salads");
        /*Item of pizaa*/
        Margarita = new Menu("Margarita", 110, "pizaa");
        ChickenBBQ = new Menu("Chicken BBQ", 145, "pizaa");
        SeaFoodPizaa = new Menu("Seafood", 225, "pizaa");

        Seafood.add(Salmon);
        Seafood.add(SeafoodProvencal);
        Seafood.add(ShrimpCrabPlate);
        Seafood.add(SeafoodCurry);

        Salads.add(CeasrSalad);
        Salads.add(ChickenQuinoa);
        Salads.add(SalmonSeeds);
        Salads.add(CitusSalad);

        pizaa.add(Margarita);
        pizaa.add(ChickenBBQ);
        pizaa.add(SeaFoodPizaa);

        //order=new ArrayList<>();
    }
    @FXML
    protected void modifyOrdershowPane(ActionEvent event) {
        addOrderPane.setVisible(false);
        modifypane.setVisible(true);
    }
    @FXML
    protected void addOrdershowPane(ActionEvent event) {
        addOrderPane.setVisible(true);
        modifypane.setVisible(false);
        MenuItems();

//combo box
        comboTableId.getItems().clear();//clear combobox
        arrayList.clear();//clear array list
        try {
            arrayList = database.get_table_id_id();
        } catch (Exception e) {
        }

        comboTableId.getItems().addAll(arrayList);
    }

//section
        @FXML
        void SectionChoose(ActionEvent event){
            Button button=(Button) event.getSource();
           // panemenu.setVisible(true);
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
    protected void selectedIdComboBox() throws Exception {
        SelectedId = Integer.parseInt(comboTableId.getValue().toString());

        seat = database.get_table_id(SelectedId);
        System.out.println(seat);
        numOfSeats.setText(seat+"");
    }
    @FXML
    protected void chooseOrder() throws Exception {
            //oo.clear();
            //order.clear();
            //menu.clear();
            String choose = foodcombox.getValue().toString();
            System.out.println(choose);
            if (id.equals("salad")) {//salad
                if (choose.equals("Ceasr Salad   with price 125")) {
                    b = new CeasrSalad(b);
                    order.add(new CeasrSalad(b));
                    menu.add(CeasrSalad);
                    oo.add(new CeasrSalad().dd());
                } else if (choose.equals("Chicken Quinoa   with price 130")) {
                    b = new ChickenQuinoa(b);
                    order.add(b);
                    menu.add(ChickenQuinoa);
                    oo.add(new ChickenQuinoa().dd());
                } else if (choose.equals("Salmon Seeds   with price 245")) {
                    b = new SalmonSeeds(b);
                    order.add(b);
                    menu.add(SalmonSeeds);
                    oo.add(new SalmonSeeds().dd());
                } else if (choose.equals("Citus Salad   with price 250")) {
                    b = new CitusSalad(b);
                    order.add(b);
                    menu.add(CitusSalad);
                    oo.add(new CitusSalad().dd());
                }
            } else if (id.equals("pizza")) {//pizza
                if (choose.equals("Margarita   with price 110")) {
                    b = new Margarita(b);
                    order.add(new Margarita());
                    oo.add(new Margarita().dd());
                    menu.add(Margarita);
                } else if (choose.equals("Chicken BBQ   with price 145")) {
                    b = new ChickenBBQ(b);
                    order.add(new ChickenBBQ());
                    oo.add(new ChickenBBQ().dd());
                    menu.add(ChickenBBQ);
                } else if (choose.equals("Seafood   with price 225")) {
                    b = new SeaFoodPizaa(b);
                    order.add(new SeaFoodPizaa());
                    oo.add(new SeaFoodPizaa().dd());
                    menu.add(SeaFoodPizaa);
                }

            } else if (id.equals("seefood")) {//seefood
                if (choose.equals("Salmon   with price 280")) {
                    b = new Salmon(b);
                    order.add(b);
                    oo.add(new Salmon().dd());
                    menu.add(Salmon);
                    counter_price+=Salmon.getPrice();
                } else if (choose.equals("Seafood Provencal   with price 260")) {
                    b = new SeafoodProvencal(b);
                    order.add(b);
                    oo.add(new SeafoodProvencal().dd());
                    menu.add(SeafoodProvencal);
                    counter_price+=SeafoodProvencal.getPrice();
                } else if (choose.equals("Shrimp CrabPlate   with price 245")) {
                    b = new ShrimpCrabPlate(b);
                    order.add(b);
                    menu.add(ShrimpCrabPlate);
                    oo.add(new ShrimpCrabPlate().dd());
                    counter_price+=ShrimpCrabPlate.getPrice();
                } else if (choose.equals("Seafood Curry   with price 250")) {
                    b = new SeafoodCurry(b);
                    order.add(b);
                    menu.add(SeafoodCurry);
                    counter_price+=SeafoodCurry.getPrice();
                    oo.add(new ShrimpCrabPlate().dd());
                }
            }
        }

 static int counter_price=0;
    public int calculate_total() {
        for (Menu m : menu) {
            counter_price += m.getPrice();
        }
        return counter_price;
    }

    @FXML
    protected void AddOrder() throws Exception {
        System.out.println(counter_price+"");
        show.setText(b.decorate());
        calculate_total();
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
