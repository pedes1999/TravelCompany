package comparators;

import java.util.Comparator;
import model.Customer;

/**
 *
 * Compares customers based on the Tickets Purchased
 */
public class CustomerTicketComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer c1, Customer c2) {
        return c2.getTicketsPurchased() - c1.getTicketsPurchased();
    }
}
