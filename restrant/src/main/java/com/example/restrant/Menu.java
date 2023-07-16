package com.example.restrant;

import java.util.ArrayList;
import java.util.List;

//composite pattern
public class Menu {

    private String ItemName;
    private String SectionName;
    private int price;
    private List<Menu> sub;

    public Menu(String i, int p, String s) {
        this.ItemName = i;
        this.price = p;
        this.SectionName = s;
        sub = new ArrayList<>();
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public void setSectionName(String SectionName) {
        this.SectionName = SectionName;
    }

    public String getItemName() {
        return ItemName;
    }

    public String getSectionName() {
        return SectionName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = 1;
    }

    public void add(Menu m) {
        sub.add(m);
    }

    public void remove(Menu m) {
        sub.remove(m);
    }

    public List<Menu> getSubordinates() {
        return sub;
    }

    public String showSections() {
        return (this.SectionName);
    }

    public String showItems() {
        return (this.ItemName + "   with price " + this.price);
    }

}
