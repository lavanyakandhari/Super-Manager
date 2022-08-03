package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.Cart;
import model.Menu;
import model.Product;
import org.json.*;

//referred to JsonSerializationDemo
// Represents a reader that reads shoppingApp from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads menu from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Menu readMenu() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseMenu(jsonObject);
    }

    // EFFECTS: reads cart from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Cart readCart() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCart(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses menu from JSON object and returns it
    private Menu parseMenu(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Menu mn = new Menu(name);
        addItemsMenu(mn, jsonObject);
        return mn;
    }

    // EFFECTS: parses cart from JSON object and returns it
    private Cart parseCart(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Cart ct = new Cart(name);
        addItemsCart(ct, jsonObject);
        return ct;
    }

    // MODIFIES: mn
    // EFFECTS: parses items from JSON object and adds them to menu
    private void addItemsMenu(Menu mn, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("menu");
        for (Object json : jsonArray) {
            JSONObject nextItem = (JSONObject) json;
            addItemMenu(mn, nextItem);
        }
    }

    // MODIFIES: mn
    // EFFECTS: parses items from JSON object and adds them to cart
    private void addItemsCart(Cart ct, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("cart");
        for (Object json : jsonArray) {
            JSONObject nextItem = (JSONObject) json;
            addItemCart(ct, nextItem);
        }
    }

    // MODIFIES: mn
    // EFFECTS: parses items from JSON object and adds it to menu
    private void addItemMenu(Menu mn, JSONObject jsonObject) {
        int id = jsonObject.getInt("id");
        String name = jsonObject.getString("name");
        Double price = jsonObject.getDouble("price");
        mn.addToMenu(id,name,price);
    }

    // MODIFIES: mn
    // EFFECTS: parses items from JSON object and adds it to cart
    private void addItemCart(Cart ct, JSONObject jsonObject) {
        int id = jsonObject.getInt("id");
        String name = jsonObject.getString("name");
        Double price = jsonObject.getDouble("price");
        Product p = new Product(id, name, price);
        ct.addToCart(p);
    }
}
