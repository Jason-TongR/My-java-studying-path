// ShoppingCart.java
import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<String> items;
    private double totalPrice;
    
    public ShoppingCart() {
        items = new ArrayList<>();
        totalPrice = 0.0;
    }
    
    public void addItem(String itemName, double price) {
        items.add(itemName);
        totalPrice += price;
    }
    
    public int getItemCount() {
        return items.size();
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }
    
    public void clearCart() {
        items.clear();
        totalPrice = 0.0;
    }
}