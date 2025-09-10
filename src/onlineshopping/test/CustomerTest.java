package onlineshopping.test;

import static org.junit.jupiter.api.Assertions.*;
import onlineshopping.java.Customer;
import onlineshopping.java.ShoppingCart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer(1, "Mohammad");
    }

    @Test
    @DisplayName("Test getId")
    void testGetId() {
        assertEquals(1, customer.getId(), "Customer ID should be 1");
    }

    @Test
    @DisplayName("Test getName")
    void testGetName() {
        assertEquals("Mohammad", customer.getName(), "Customer name should be Mohammad");
    }

    @Test
    @DisplayName("Test getCart returns not null")
    void testGetCartNotNull() {
        assertNotNull(customer.getCart(), "Customer cart should not be null");
    }

    @Test
    @DisplayName("Test getCart")
    void testGetCartInstance() {
        ShoppingCart cart = customer.getCart();
        assertTrue(cart instanceof ShoppingCart, "Cart should be instance of ShoppingCart");
    }
}
