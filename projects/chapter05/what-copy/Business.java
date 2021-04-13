import java.util.ArrayList;
/**
 * Write a description of class Business here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Business
{
    // instance variables - replace the example below with your own
    private ArrayList<Invoice> invoices;

    /**
     * Constructor for objects of class Business
     */
    public Business()
    {
        invoices = new ArrayList<>();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addInvoice(int tot)
    {
        invoices.add(new Invoice(tot)); 
    }
    
    public void addMultiInvoice() {
        addInvoice(6);
        addInvoice(5);
        addInvoice(6);
    }
    public int totalSales() {
        int salesTotal = 0; //initializing variable
        
        for(Invoice inv : invoices){ //iterating over the whole list
            salesTotal += inv.getTotal();    //incrementing salesTotal with the value from inv
        }
        return salesTotal; //return value
    }
}
