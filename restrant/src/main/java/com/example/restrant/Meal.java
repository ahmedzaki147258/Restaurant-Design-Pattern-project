
package com.example.restrant;

public class Meal implements baseMeal {

    private baseMeal b;
    private Menu m;

    public Meal(baseMeal b) {
        this.b = b;
    }

    public Meal() {
    }

    ;
public Menu getMenu() {
        return m;
    }

    @Override
    public String decorate() {
        return b.decorate();
    }
//   public int get_price(){
//       return m.getPrice();
//   }

}
