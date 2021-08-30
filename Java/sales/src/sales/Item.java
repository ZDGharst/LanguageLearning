package sales;

public class Item {
    private String title;
    private double unitPrice;
    private int quantity;
    private Boolean bulkPurchaseDiscount;

    public Item(String title, double unitPrice, int quantity) {
        this.title = title;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.bulkPurchaseDiscount = false;
    }

    public Item(String title, double unitPrice, int quantity, Boolean bulkPurchaseDiscount) {
        this.title = title;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.bulkPurchaseDiscount = bulkPurchaseDiscount;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /* If the buy one, get the rest 50% discount is activated, calculate a different price. */
    public double getItemTotal() {
        if(bulkPurchaseDiscount && quantity > 1) {
            return unitPrice + (unitPrice * (quantity - 1)/ 2);
        }

        return unitPrice * quantity;
    }
}