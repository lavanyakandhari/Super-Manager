package model;


import org.json.JSONObject;
import persistence.Writable;

//Represents a product having an id, name and price(in dollars)
public class Product implements Writable {
    private int pid;              //product Id
    private String pname;         //product name
    private double price;         //product price per unit

    //REQUIRES: name and id have a non-zero length
    //EFFECTS: pname of product is set to name, o=price of product is set to price
    //and pid of product is set to id
    public Product(int id, String name, double price) {
        this.pid = id;
        this.pname = name;
        this.price = price;
    }

    //EFFECTS: returns the name of product
    public String getProductName() {
        return pname;
    }

    //EFFECTS: returns the price of product
    public double getProductPrice() {
        return price;
    }

    //EFFECTS: returns the id to product
    public int getId() {
        return pid;
    }

    //referred to JsonSerializationDemo

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("id", pid);
        json.put("name", pname);
        json.put("price", price);
        return json;
    }
}