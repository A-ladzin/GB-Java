package hw;

import java.util.HashMap;

public class LapTop {

    private HashMap<String, Object> specs = new HashMap<>();
    
    String name = "";

    public LapTop(int price, int RAM, int Storage, String os, String color){

        specs.put("Price", price);
        specs.put("RAM", RAM);
        specs.put("Storage",Storage);
        specs.put("OS", os);
        specs.put("Color", color);
    }
    
    public HashMap<String,Object> GetSpec()
    {
        return specs;
            }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Serial number: " + this.name + " Specifications: " + specs.toString();
    }
}
