package onlineshopping.java;

public class Customer {
    private int id;
    private String name;
    private ShoppingCart cart;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        this.cart = new ShoppingCart();
    }
    
    public int getId() {
    	return id;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public String getName() {
        return name;
    }

}
