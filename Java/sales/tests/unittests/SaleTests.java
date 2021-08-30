package unittests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sales.*;

import java.util.Calendar;

public class SaleTests {
    private Customer customer;
    private Sale sale;
    private Item item1;
    private Item item2;

    @BeforeEach
    protected void setUp() throws Exception {
        customer = new Regular();
        sale = new Sale(customer);
        item1 = new Item("Pineapple", 2.50, 2);
        item2 = new Item("Orange", 1.00, 10);
        sale.addItem(item1);
        sale.addItem(item2);
    }

    @Test
    @DisplayName("Discount rate should be the total multiplied by the discount rate")
    public void getDiscount() {
        assertEquals(0.75, sale.getDiscount());
    }

    @Test
    @DisplayName("Subtotal before discount should be 15")
    public void getSubTotal() {
        assertEquals(15, sale.getSubTotal());
    }

    @Test
    @DisplayName("Subtotal after discount should be 15 minus the discount")
    public void getDiscountedSubTotal() {
        assertEquals(14.25, sale.getDiscountedSubTotal());
    }

    @Test
    @DisplayName("Discount rate for a preferred customer is different than discount rate for a regular customer")
    public void getDiscountPreferred() {
        sale.setCustomer(new Preferred());
        assertEquals(2.25, sale.getDiscount());
    }

    @Test
    @DisplayName("Discount rate for a senior is different than discount rate for a regular customer on Tuesday")
    public void getDiscountSenior() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        double discount = day == Calendar.TUESDAY ? 1.50 : 0.75;

        sale.setCustomer(new Senior());
        assertEquals(discount, sale.getDiscount());
    }

    @Test
    @DisplayName("Sale that have items with the BOGO policy should be discounted")
    public void getDiscountedSubTotalBOGO() {
        Item item3 = new Item("Watermelon", 1.00, 4, true);
        sale.addItem(item3);
        assertEquals(16.625, sale.getDiscountedSubTotal(), 0.001);
    }
}