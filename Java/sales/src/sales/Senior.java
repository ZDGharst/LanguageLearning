package sales;
import java.util.Calendar;

public class Senior extends Customer {
    public double getDiscountRate() {
        Calendar calendar = Calendar.getInstance();
        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
            return 0.10;
        }
        return 0.05;
    }
}
