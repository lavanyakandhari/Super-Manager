package persistence;

import model.Cart;
import model.Menu;
import model.Product;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//referred from JsonSerializationDemo
public class JsonWriterTest extends JsonTest {
    @Test
    void testWriterInvalidFileMenu() {
        try {
            Menu mn = new Menu("My menu");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyMenu() {
        try {
            Menu mn = new Menu("My menu");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyMenu.json");
            writer.open();
            writer.writeMenu(mn);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyMenu.json");
            mn = reader.readMenu();
            assertEquals("My menu", mn.getNameMenu());
            assertEquals(0, mn.totalInMenu());
        } catch (IOException e) {
            e.printStackTrace();
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralMenu() {
        try {
            Menu mn = new Menu("My menu");
            mn.addToMenu(15, "butter",2);
            mn.addToMenu(17, "orange",1.5);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralMenu.json");
            writer.open();
            writer.writeMenu(mn);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralMenu.json");
            mn = reader.readMenu();
            assertEquals("My menu", mn.getNameMenu());
            List<Product> products = mn.showMenu();
            assertEquals(2, products.size());
            checkItemMenu("butter", mn, products.get(0));
            checkItemMenu("orange", mn, products.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterInvalidFileCart() {
        try {
            Cart ct = new Cart("My cart");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyCart() {
        try {
            Cart ct = new Cart("My cart");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyCart.json");
            writer.open();
            writer.writeCart(ct);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyCart.json");
            ct = reader.readCart();
            assertEquals("My cart", ct.getNameCart());
            assertEquals(0, ct.totalInCart());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralCart() {
        try {
            Cart ct = new Cart("My cart");
            Product p1 = new Product(1, "Milk", 3);
            Product p2 = new Product(2, "Bread", 2);
            ct.addToCart(p1);
            ct.addToCart(p2);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralCart.json");
            writer.open();
            writer.writeCart(ct);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralCart.json");
            ct = reader.readCart();
            assertEquals("My cart", ct.getNameCart());
            List<Product> products = ct.showCart();
            assertEquals(2, products.size());
            checkItemCart("Milk", ct, products.get(0));
            checkItemCart("Bread", ct, products.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }


}
