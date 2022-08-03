package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

//Represents a menu having Products
public class Menu implements Writable {
    public ArrayList<Product> menu;
    private String name;


    //MODIFIES:this
    //EFFECTS: initialises menu with a name and adds 12 items to menu.
    public Menu(String name) {
        this.menu = new ArrayList<>();
        this.name = name;
    }

    //EFFECTS: returns the name os the menu
    public String getNameMenu() {
        return name;
    }

    // MODIFIES: this
    // EFFECTS: removes item from the menu
    public void deleteFromMenu(int id) {
        Product product = null;
        for (Product p : menu) {
            if (id == p.getId()) {
                product = p;
            }
        }
        if (product != null) {
            menu.remove(product);
        }
    }


    //MODIFIES: this
    //EFFECTS: adds a product to the menu with its id,name and price
    public void addToMenu(int id, String name, double cost) {
        Product p = new Product(id, name, cost);
        menu.add(p);
    }

    //EFFECTS: returns the total number of items listed in the menu
    public int totalInMenu() {
        int count = 0;
        for (Product p : menu) {
            count++;
        }
        return count;
    }

    //EFFECTS: returns true if the given item is present in the menu and false otherwise
    public boolean contains(int sid) {
        for (Product p : menu) {
            if (sid == p.getId()) {
                return true;
            }
        }
        return false;
    }

    // EFFECTS: Returns a list of all products at he supermarket
    // displays the menu to the user
    public List<Product> showMenu() {
        return menu;
    }

//referred to JsonSerializationDemo

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("menu", productsToJson());
        return json;
    }

    // EFFECTS: returns things in this menu as a JSON array
    private JSONArray productsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Product p : menu) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }
}