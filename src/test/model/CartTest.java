package model;

import exceptions.NegativeIdException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//unit test for cart class
class CartTest {
    Menu productList;
    Cart cart;
    public Product p1 = new Product(1, "Milk", 3);
    public Product p2 = new Product(2, "Bread", 1);
    public Product p3 = new Product(3, "Cheese", 2);

    @BeforeEach
    public void setup() {
        productList = new Menu("testMenu");
        cart = new Cart("testCart");
    }

    @Test
    public void testCart() {
        assertEquals(0, cart.showTotalCost());
        assertEquals(0,productList.totalInMenu());
    }

    @Test
    public void testToAddOneToCart() {
        cart.addToCart(p1);
        assertTrue(cart.contains(p1.getId()));
    }

    @Test
    public void testToAddManyToCart() {
        assertEquals(0, cart.totalInCart());
        cart.addToCart(p1);
        cart.addToCart(p2);
        cart.addToCart(p3);
        assertTrue(cart.contains(p1.getId()));
        assertTrue(cart.contains(p2.getId()));
        assertTrue(cart.contains(p3.getId()));
        assertEquals(3, cart.totalInCart());
    }

    @Test
    public void testRemoveFromCartNotThere() throws NegativeIdException {
        assertEquals(0, cart.totalInCart());
        cart.addToCart(p1);
        cart.addToCart(p2);
        cart.addToCart(p3);
        assertEquals(3,cart.totalInCart());
        cart.removeFromCart(13);
        assertEquals(3,cart.totalInCart());
        assertFalse(cart.contains(13));
    }

    @Test
    public void testRemoveFromCart() throws NegativeIdException {
        cart.addToCart(p1);
        cart.addToCart(p2);
        cart.addToCart(p3);
        assertTrue(cart.contains(p1.getId()));
        assertTrue(cart.contains(p2.getId()));
        assertTrue(cart.contains(p3.getId()));
        assertEquals(3, cart.totalInCart());
        cart.removeFromCart(p2.getId());
        assertTrue(cart.contains(p1.getId()));
        assertTrue(cart.contains(p3.getId()));
        assertFalse(cart.contains(p2.getId()));
        assertEquals(2, cart.totalInCart());
    }

    @Test
    public void testRemoveFromCartExceptionNotCalled() throws NegativeIdException {
        try {
            cart.addToCart(p1);
            cart.addToCart(p2);
            cart.addToCart(p3);
            cart.removeFromCart(p1.getId());
            // expected
        } catch (NegativeIdException negativeIdException) {
            fail("Caught NegativeIdException");
        }
    }

    @Test
    public void testRemoveFromCartExceptionCalled() throws NegativeIdException {
        try {
            cart.addToCart(p1);
            cart.addToCart(p2);
            cart.addToCart(p3);
            cart.removeFromCart(-(p1.getId()));
            fail("NegativeIdException was not thrown");
        } catch (NegativeIdException negativeIdException) {
            // expected
        }
    }

    @Test
    public void testDeleteItemNotThere(){
        assertEquals(0, cart.totalInCart());
        cart.addToCart(p1);
        cart.addToCart(p2);
        cart.addToCart(p3);
        assertEquals(3,cart.totalInCart());
        cart.deleteItem(13);
        assertEquals(3,cart.totalInCart());
        assertFalse(cart.contains(13));
    }
    @Test
    public void testDeleteItem() {
        cart.addToCart(p1);
        cart.addToCart(p2);
        cart.addToCart(p3);
        assertTrue(cart.contains(p1.getId()));
        assertTrue(cart.contains(p2.getId()));
        assertTrue(cart.contains(p3.getId()));
        assertEquals(3, cart.totalInCart());
        cart.deleteItem(p2.getId());
        assertTrue(cart.contains(p1.getId()));
        assertTrue(cart.contains(p3.getId()));
        assertFalse(cart.contains(p2.getId()));
        assertEquals(2, cart.totalInCart());
    }

    @Test
    public void testShowTotalCost() {
        cart.addToCart(p1);
        cart.addToCart(p2);
        assertEquals(4, cart.showTotalCost());
    }

    @Test
    public void testCheckInCart() {
        cart.addToCart(p1);
        cart.addToCart(p1);
        cart.addToCart(p1);
        cart.addToCart(p2);
        cart.addToCart(p3);
        assertEquals(3, cart.checkInCart(p1.getId()));
    }

    @Test
    public void testTotalInCart() throws NegativeIdException {
        cart.addToCart(p1);
        cart.addToCart(p2);
        assertEquals(2, cart.totalInCart());
        cart.removeFromCart(1);
        assertEquals(1, cart.totalInCart());
    }

    @Test
    public void testForContains(){
        Product p = new Product(1, "test", 3.2);
        assertFalse(cart.contains(1));
        cart.addToCart(p);
        assertTrue(cart.contains(1));
    }

    @Test
    public void testForDoesNotContains() throws NegativeIdException {
        Product p = new Product(1, "test", 3.2);
        assertFalse(cart.contains(1));
        cart.addToCart(p);
        assertTrue(cart.contains(1));
        cart.removeFromCart(1);
        assertFalse(cart.contains(1));
    }

}
