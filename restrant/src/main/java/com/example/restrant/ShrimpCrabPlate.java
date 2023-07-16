
package com.example.restrant;


public class ShrimpCrabPlate extends Meal{
    public ShrimpCrabPlate(baseMeal b)
    {
        super(b);
    }
    public ShrimpCrabPlate(){};
    @Override
    public String decorate(){
        return super.decorate()+" ,ShrimpCrabPlate";
    }
    public String dd(){
        return " ,ShrimpCrabPlate";
    }
}
