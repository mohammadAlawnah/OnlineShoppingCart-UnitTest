package onlineshopping.test;

import static org.junit.jupiter.api.Assertions.*;
import onlineshopping.java.Product;
import onlineshopping.java.ShoppingCart;
import onlineshopping.java.CartItem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {

    private ShoppingCart cart;
    private Product laptop;
    private Product phone;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        laptop = new Product(1, "Laptop", 1000.0, 10);
        phone = new Product(2, "Phone", 500.0, 5);
    }

    @Test
    @DisplayName("Add product with valid qun")
    void testAddProductValid() {
        cart.addProduct(laptop, 2);
        assertEquals(1, cart.getItems().size(), "Cart should contain 1 item");
        assertEquals(8, laptop.getStock(), "Laptop stock should be reduced by 2");
    }

    @Test
    @DisplayName("Add product with invalid quan")
    void testAddProductInvalidQuantity() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addProduct(laptop, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addProduct(phone, -1);
        });
    }

    @Test
    @DisplayName("Remove product by ID")
    void testRemoveProduct() {
        cart.addProduct(laptop, 1);
        cart.addProduct(phone, 1);
        assertEquals(2, cart.getItems().size(), "Cart should contain 2 items");

        cart.removeProduct(1);
        assertEquals(1, cart.getItems().size(), "Cart should contain 1 item after removal");
        assertEquals(phone, cart.getItems().get(0).getProduct(), "Remaining item should be phone");
    }

    @Test
    @DisplayName("Calculate total price of cart")
    void testCalculateTotal() {
        cart.addProduct(laptop, 2);
        cart.addProduct(phone, 1); 
        assertEquals(2500.0, cart.calculateTotal(), 0.001, "Total should be 2500");
    }

    @Test
    @DisplayName("Clear cart removes all items")
    void testClearCart() {
        cart.addProduct(laptop, 1);
        cart.addProduct(phone, 1);
        assertFalse(cart.getItems().isEmpty(), "Cart should not be empty before clear");

        cart.clearCart();
        assertTrue(cart.getItems().isEmpty(), "Cart should be empty after clear");
    }

    @Test
    @DisplayName("Get items returns live list")
    void testGetItems() {
        cart.addProduct(laptop, 1);
        assertNotNull(cart.getItems(), "Items list should not be null");
        assertEquals(1, cart.getItems().size(), "Items list should contain 1 element");
        assertTrue(cart.getItems().get(0) instanceof CartItem, "Element should be CartItem");
    }
}
