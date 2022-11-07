package repository;

import java.util.List;
import model.Customer;
import model.Ticket;

public interface CustomerRepository {

    void populateCustomerPrice(List<Customer> customerList, List<Ticket> ticketList);

    //CREATE A NEW CUSTOMER
    int create(Customer customer);

    //GETTER FOR CUSTOMER LIST
    List<Customer> getCustomerList();

    //search customers who didnt buy any tickets
    List<Customer> searchIfNotBuy(List<Customer> customerList, List<Ticket> ticketList);

    //search customers who have the most tickets
    List<Customer> customerMostTickets(List<Customer> customerList, List<Ticket> ticketList);

}
