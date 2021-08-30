package sales;
import java.util.ArrayList;

public class Sale {
    private Customer customer;
    private ArrayList<Item> itemList = new ArrayList<Item>();

    public Sale() {
        customer = new Regular();
    }

    public Sale(Customer customer) {
        setCustomer(customer);
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public double getDiscountRate(){
        return customer.getDiscountRate();
    }

    public double getDiscount(){
        return getSubTotal()*getDiscountRate();
    }

    public double getSubTotal() {
        double subTotal = 0.0;
        for (Item item: itemList) {
            subTotal += item.getItemTotal();
        }
        return subTotal;
    }

    public double getDiscountedSubTotal() {
        return getSubTotal() - getDiscount();
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}