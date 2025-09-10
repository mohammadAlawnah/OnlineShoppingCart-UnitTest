package onlineshopping.test;

import static org.junit.jupiter.api.Assertions.*;
import onlineshopping.java.CartItem;
import onlineshopping.java.Product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CartItemTest {

    private Product product;
    private CartItem cartItem;

    @BeforeEach
    void setUp() {
        product = new Product(1, "Laptop", 1000.0, 2);
        cartItem = new CartItem(product, 2);
    }

    @Test
    @DisplayName("Test getProduct")
    void testGetProduct() {
        assertEquals(product, cartItem.getProduct(), "CartItem should return the correct product");
    }

    @Test
    @DisplayName("Test getQuantity")
    void testGetQuantity() {
        assertEquals(2, cartItem.getQuantity(), "CartItem should return the correct quantity");
    }

    @Test
    @DisplayName("Test getTotalPrice")
    void testGetTotalPrice() {
        assertEquals(2000.0, cartItem.getTotalPrice(), 
            "Total price should equal product price multiplied by quantity");
    }
}
