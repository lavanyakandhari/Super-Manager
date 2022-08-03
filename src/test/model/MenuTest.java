package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// unit tests for menu class
class MenuTest {
    Menu productList;
    public Product p1 = new Product(1, "Milk", 3);
    public Product p2 = new Product(2, "Bread", 1);
    public Product p3 = new Product(3, "Cheese", 2);
    public Product p4 = new Product(4, "Cereal", 3);
    public Product p5 = new Product(5, "Chocolate", 5);
    public Product p6 = new Product(6, "Egg", 2);
    public Product p7 = new Product(7, "Jam", 4);

    @BeforeEach
    public void setup() {
        productList = new Menu("testMenuList");
        productList.addToMenu(p1.getId(), p1.getProductName(),p1.getProductPrice());
        productList.addToMenu(p2.getId(), p2.getProductName(),p2.getProductPrice());
        productList.addToMenu(p3.getId(), p3.getProductName(),p3.getProductPrice());
        productList.addToMenu(p4.getId(), p4.getProductName(),p4.getProductPrice());
        productList.addToMenu(p5.getId(), p5.getProductName(),p5.getProductPrice());
        productList.addToMenu(p6.getId(), p6.getProductName(),p6.getProductPrice());
        productList.addToMenu(p7.getId(), p7.getProductName(),p7.getProductPrice());
    }

    @Test
    public void testForConstructor(){
        assertEquals(7,productList.totalInMenu());
    }
    @Test
    public void testDeleteOneFromMenu() {
        assertEquals(7, productList.totalInMenu());
        productList.deleteFromMenu(1);
        assertEquals(6, productList.totalInMenu());
        assertFalse(productList.contains(1));
    }
    @Test
    public void testDeleteFromMenuNotThere(){
        assertEquals(7,productList.totalInMenu());
        productList.deleteFromMenu(13);
        assertEquals(7,productList.totalInMenu());
        assertFalse(productList.contains(13));
    }
    @Test
    public void testDeleteManyFromMenu() {
        assertEquals(7, productList.totalInMenu());
        productList.deleteFromMenu(1);
        productList.deleteFromMenu(2);
        productList.deleteFromMenu(3);
        assertEquals(4, productList.totalInMenu());
        assertFalse(productList.contains(1));
        assertFalse(productList.contains(2));
        assertFalse(productList.contains(3));
    }

    @Test
    public void testToAddOneToMenu() {
        productList.addToMenu(13, "fruit", 2);
        assertTrue(productList.contains(13));
        assertEquals(8, productList.totalInMenu());
    }
    @Test
    public void testToAddManyToMenu() {
        productList.addToMenu(13, "fruit", 2);
        productList.addToMenu(14, "flour", 4);
        assertTrue(productList.contains(13));
        assertTrue(productList.contains(14));
        assertEquals(9, productList.totalInMenu());
    }

    @Test
    public void testTotalInMenu() {
        assertEquals(7, productList.totalInMenu());
        productList.deleteFromMenu(p1.getId());
        assertEquals(6, productList.totalInMenu());
    }

    @Test
    public void testForContainInMenu() {
        assertTrue(productList.contains(1));
        productList.addToMenu(14, "fruit", 4);
        assertTrue(productList.contains(14));
    }

    @Test
    public void testForDoesNotContainInMenu() {
        assertTrue(productList.contains(1));
        productList.deleteFromMenu(1);
        assertFalse(productList.contains(1));
    }

}