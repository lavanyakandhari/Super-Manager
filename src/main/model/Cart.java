package model;


import exceptions.NegativeIdException;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// represents a cart having totalCost and Products that can be added from a set menu
public class Cart implements Writable {
    private double totalCost;  //total cost of items in cart
    public ArrayList<Product> cart;   // a cart as a list of products
    private String name;

    //Constructor
    //EFFECTS: totalCost is set to 0, cart is set as an ArrayList, menu is set as a new Menu
    public Cart(String name) {
        this.cart = new ArrayList<>();
        this.name = name;
        totalCost = 0;
    }

    //EFFECTS: returns name of cart
    public String getNameCart() {
        return name;
    }

    // EFFECTS: Returns a list of all products at he supermarket
    // displays the menu to the user
    public List<Product> showCart() {
        return cart;
    }

    // MODIFIES: this
    // EFFECTS: adds a product to the customers cart.
    public void addToCart(Product p) {
        cart.add(p);
    }

    // MODIFIES: this
    // EFFECTS: removes one product from the customers cart and
    // Throws NegativeIDException if input id is invalid integer (negative number).
    public void removeFromCart(int id) throws NegativeIdException {
        if (id < 0) {
            throw new NegativeIdException();
        }
        deleteItem(id);
    }

    // MODIFIES: this
    // EFFECTS: removes one product from the customers cart.
    public void deleteItem(int id) {
        for (Product p : cart) {
            if (id == p.getId()) {
                cart.remove(p);
                break;
            }
        }
    }

    //MODIFIES: totalCost
    //EFFECTS: shows total cost of the items in the cart
    public double showTotalCost() {
        for (Product p : cart) {
            totalCost += p.getProductPrice();
        }
        return totalCost;
    }

    //EFFECTS: returns the quantity of a particular item present in the cart
    public int checkInCart(int id) {
        int count = 0;
        for (Product p : cart) {
            if (id == p.getId()) {
                count++;
            }
        }
        return count;
    }

    //EFFECTS: returns the number of items present in the given cart
    public int totalInCart() {
        int count = 0;
        for (Product p : cart) {
            count++;
        }
        return count;
    }


    //EFFECTS: returns true if the given item id is present in the cart and false otherwise
    public boolean contains(int pid) {
        for (Product p : cart) {
            if (pid == p.getId()) {
                return true;
            }
        }
        return false;
    }


    //referred to JsonSerializationDemo

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("cart", productsToJson());
        return json;
    }

    // EFFECTS: returns things in this cart as a JSON array
    private JSONArray productsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Product p : cart) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }
}