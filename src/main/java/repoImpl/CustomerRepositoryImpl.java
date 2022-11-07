package repoImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Customer;
import model.Ticket;
import repository.CustomerRepository;

public class CustomerRepositoryImpl extends RepositoryImpl<Customer> implements CustomerRepository {

    //SEARCH FOR CUSTOMERS THAT HAVENT BOUGHT TICKETS
    @Override
    public List<Customer> searchIfNotBuy(List<Customer> customerList, List<Ticket> ticketList) {
        List<Customer> customerHasBoughtTicket = new ArrayList<>();
        List<Customer> customerListTemp = new ArrayList<>();
        customerListTemp.addAll(customerList);

        for (Customer customer : customerList) {
            for (Ticket ticket : ticketList) {
                if (ticket.getCustomerId() == customer.getId() && !customerHasBoughtTicket.contains(customer)) {
                    customerHasBoughtTicket.add(customer);
                }
            }
        }
        customerListTemp.removeAll(customerHasBoughtTicket);
        return customerListTemp;
    }

    //SEARCH FOR CUSTOMERS WITH THE MOST TICKETS
    @Override
    public List<Customer> customerMostTickets(List<Customer> customerList, List<Ticket> ticketList) {
        Set<Customer> setWithMostTickets = new HashSet<>();
        for (Customer c : customerList) {
            for (Ticket t : ticketList) {
                if (c.getId() == t.getCustomerId()) {

                    setWithMostTickets.add(c);

                }

            }
        }

        List<Customer> listWithMostTickets = new ArrayList<>(setWithMostTickets);
        return listWithMostTickets;
    }

    //UPDATE USER'S EMAIL
    @Override
    public void update(int customerId, String email) {
        Customer customer = read(customerId);
        if (customer != null) {
            customer.setCustomerEmail(email);
        }
    }

}
