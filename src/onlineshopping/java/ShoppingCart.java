package onlineshopping.java;
import java.util.List;
import java.util.ArrayList;


public class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();
    
    public void addProduct(Product product, int qty) {
        if (qty <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0!");
        }
        product.reduceStock(qty);
        items.add(new CartItem(product, qty));
    }
    
    public void removeProduct(int productId) {
        items.removeIf(item -> item.getProduct().getId() == productId);
    }

    public double calculateTotal() {
        return items.stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }
    

    public void clearCart() {
        items.clear();
    }
    
    public List<CartItem> getItems() {
        return items;
    }
    


}
