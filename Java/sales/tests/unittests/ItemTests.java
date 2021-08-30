package unittests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sales.Item;

public class ItemTests {
    private Item item;

    @BeforeEach
    protected void setUp() {
        item = new Item("Dragonfruit", 5.00, 4);
    }

    @Test
    @DisplayName("Test quantity before change and after change")
    public void getAndSetQuantity() {
        assertEquals(item.getQuantity(), 4);
        item.setQuantity(7);
        assertEquals(item.getQuantity(), 7);
    }

    @Test
    @DisplayName("Test title before change and after change")
    public void getAndSetTitle() {
        assertEquals(item.getTitle(), "Dragonfruit");
        item.setTitle("Avocado");
        assertEquals(item.getTitle(), "Avocado");
    }

    @Test
    @DisplayName("Test title before change and after change")
    public void getAndSetUnitPrice() {
        assertEquals(item.getUnitPrice(), 5);
        item.setUnitPrice(1.25);
        assertEquals(item.getUnitPrice(), 1.25);
    }

    @Test
    @DisplayName("Item total should be the quantity multiplied by the unit price")
    public void getItemTotal() {
        assertEquals(item.getItemTotal(), 20);
    }

    @Test
    @DisplayName("Item total for a bogo policy item should be calculated differently")
    public void getItemTotalDiscountPolicy() {
        item = new Item("Cranberries", 0.30, 25, true);
        assertEquals(3.90, item.getItemTotal(), 0.001);
    }
}