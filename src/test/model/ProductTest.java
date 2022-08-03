package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//unit tests for product class
class ProductTest {
    Menu productList;
    public Product p1 = new Product(1, "Milk", 3);


    @BeforeEach
    public void setup() {
        productList = new Menu("testMenuList");
        productList.addToMenu(p1.getId(), p1.getProductName(), p1.getProductPrice());

    }

    @Test
    public void testGetProductName(){
    assertEquals("Milk",p1.getProductName());}

    @Test
    public void testGetId(){
        assertEquals(1, p1.getId());
    }

    @Test
    public void testForGetProductPrice(){
        assertEquals(3,p1.getProductPrice());
    }
}
