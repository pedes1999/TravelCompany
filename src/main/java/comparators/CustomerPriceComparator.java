package comparators;

import java.util.Comparator;
import model.Customer;

/**
 *
 * Compares customers based on their amount spent
 */
public class CustomerPriceComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer c1, Customer c2) {
        if (c1 == null || c2 == null) {
            return 0;
        }
        double result = c1.getCustomerSpent() - c2.getCustomerSpent();
        if (result < 0) {
            return 1;
        } else if (result > 0) {
            return -1;
        }
        return c1.getId() - c2.getId();
    }
}
