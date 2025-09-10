package onlineshopping.test;

import static org.junit.jupiter.api.Assertions.*;
import onlineshopping.java.Product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product(1, "Laptop", 1000.0, 10);
        System.out.println("Before each test method");
    }

    @Test
    @DisplayName("Reduce stock successfully")
    void testReduceStock_Success() {
        product.reduceStock(5);
        assertEquals(5, product.getStock(), "Stock should be reduced by 5");
    }

    @Test
    @DisplayName("Reduce stock throws exception when quantity exceeds stock")
    void testReduceStock_Exception() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            product.reduceStock(20);
        });
        assertEquals("Not enough stock available!", exception.getMessage());
    }

    @Test
    @DisplayName("Increase stock sucessfuly")
    void testIncreaseStock() {
        product.increaseStock(5);
        assertEquals(15, product.getStock(), "Stock should increase by 5");
    }

    @Test
    @DisplayName("Test getters")
    void testGetters() {
        assertEquals(1, product.getId());
        assertEquals("Laptop", product.getName());
        assertEquals(1000.0, product.getPrice());
        assertEquals(10, product.getStock());
    }
}
