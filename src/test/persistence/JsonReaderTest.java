package persistence;

import model.Cart;
import model.Menu;
import model.Product;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//referred from JsonSerializationDemo
public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFileMenu() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Menu mn = reader.readMenu();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderNonExistentFileCart() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Cart ct = reader.readCart();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyMenu() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyMenu.json");
        try {
            Menu mn = reader.readMenu();
            assertEquals("My menu", mn.getNameMenu());
            assertEquals(0, mn.totalInMenu());
        } catch (IOException e) {
            e.printStackTrace();
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderEmptyCart() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyCart.json");
        try {
            Cart ct = reader.readCart();
            assertEquals("My cart", ct.getNameCart());
            assertEquals(0, ct.totalInCart());
        } catch (IOException e) {
            e.printStackTrace();
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralMenu.json");
        try {
            Menu mn = reader.readMenu();
            assertEquals("My menu", mn.getNameMenu());
            List<Product> products = mn.showMenu();
            assertEquals(2, products.size());
            checkItemMenu("butter", mn, products.get(0));
            checkItemMenu("orange", mn, products.get(1));
        } catch (IOException e) {
            e.printStackTrace();
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralCart() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralCart.json");
        try {
            Cart ct = reader.readCart();
            assertEquals("My cart", ct.getNameCart());
            List<Product> products = ct.showCart();
            assertEquals(2, products.size());
            checkItemCart("Milk", ct, products.get(0));
            checkItemCart("Bread", ct, products.get(1));
        } catch (IOException e) {
            e.printStackTrace();
            fail("Couldn't read from file");
        }
    }

}
