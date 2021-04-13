import java.util.ArrayList;
import java.util.Iterator;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(int id, String name, int quantity)
    {
        boolean check = false;
        
        for(Product stonk : stock) {
            if(id == stonk.getID()) {
                check = true;                   
            }
            if(check) {
                System.out.println("Please resubmit with a different ID number");    
            }
        }
        stock.add(new Product(id, name, quantity));
    }
    
    public void addTestProducts() {
        addProduct(1, "Pillow", 100);
        addProduct(2, "Book", 255);
        addProduct(3, "Calculator", 150);
        addProduct(4, "Door", 10);
        addProduct(5, "Car", 25);
        addProduct(6, "Truck", 50);
        addProduct(7, "Blob", 14);
        addProduct(8, "Pink Mercedes", 34);
        addProduct(9, "Flute", 87);
        addProduct(10, "Guitar", 65);
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        for(Product stonk: stock) {
            if(id == stonk.getID()) {
                stonk.increaseQuantity(amount);                 
            }
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        Product foundProduct = null; // initializing local variables. 
        boolean temp = false;
        int index = 0; 
        
        while(stock.size() > index && temp == false) {
            if(stock.get(index).getID() == id) {
                foundProduct = stock.get(index);
                System.out.println("Found: " + stock.get(index).getName());
                temp = true; //quiting the while loop if the object is found. 
            }
            
            index += 1; //increment
        }
        
        if(foundProduct == null) {
            System.out.println("Please enter a valid ID number.");    // letting user know of error. 
        }
        return foundProduct;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        int index = 0; // initializing variables
        for(Product stonk : stock) { // iterating through stock feild
            if(id == stonk.getID()) {
                index += stonk.getQuantity(); //incrementing index with the value of
            }                                  // index
        }
        return index;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for(Product stonk : stock) {
            System.out.println(stonk.toString()); //prints the every object in stock
            System.out.println("");
        }
    }
    /**
     * prints all objects in stock that have a quantity field less than the paramerter
     * @param level sets the variable at which the stock quantity is checked against. 
     */
    public void printLowStock(int level) { 
        for(Product stonk : stock) {
            if(level > stonk.getQuantity()) {
                System.out.println("Low stock: " + stonk.getName() + " ");
                System.out.println("Quantity left: " + stonk.getQuantity());
            }
        }
    }
    
    public Product findProduct(String name) {
        Product foundProduct = null;
        boolean temp = false;
        int index = 0;
        
        while(stock.size() > index && temp == false) {

            if(stock.get(index).getName() == name) {
                foundProduct = stock.get(index);
                temp = true;
            }
            
            index += 1;
        }
        
        return foundProduct;
    }
    
    /**
     * Prints out 1 through ten in the terminal
     */
    public void oneToTen() {
        int i = 1;
        while(i <= 10) {
            System.out.println(i);
            i += 1;
        }
    }
}
