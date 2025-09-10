package onlineshopping.java;

public class Product {
	  private int id;
	  private String name;
	  private double price;
	  private int stock;
	  
	  
	  public Product(int id, String name, double price, int stock) {
	        this.id = id;
	        this.name = name;
	        this.price = price;
	        this.stock = stock;
	    }
	  
	  public void reduceStock(int qty) {
	        if (qty > stock) {
	            throw new IllegalArgumentException("Not enough stock available!");
	        }
	        stock -= qty;
	    }

	    public void increaseStock(int qty) {
	        stock += qty;
	    }

	    public int getId() { return id; }
	    public String getName() { return name; }
	    public double getPrice() { return price; }
	    public int getStock() { return stock; }
	  

}
