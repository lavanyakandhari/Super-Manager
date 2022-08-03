package persistence;

import model.Cart;
import model.Menu;
import model.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//referred from JsonSerializationDemo
public class JsonTest {
    protected void checkItemMenu(String name, Menu menu, Product product) {
        assertEquals(name, product.getProductName());
        assertTrue(menu.contains(product.getId()));

    }

    protected void checkItemCart(String name, Cart cart, Product product) {
        assertEquals(name, product.getProductName());
        assertTrue(cart.contains(product.getId()));

    }
}
