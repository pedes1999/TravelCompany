package repository;

import java.util.List;
import model.Customer;
import model.Ticket;

public interface CustomerRepository extends Repository<Customer> {

    //Update User's email
    void update(int customerId, String email);
    
    //search customers who didnt buy any tickets
    List<Customer> searchIfNotBuy(List<Customer> customerList, List<Ticket> ticketList);

    //search customers who have the most tickets
    List<Customer> customerMostTickets(List<Customer> customerList, List<Ticket> ticketList);

}
