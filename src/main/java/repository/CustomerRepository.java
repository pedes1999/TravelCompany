package repository;

import java.util.List;
import model.Customer;

public interface CustomerRepository {

    //CREATE A NEW CUSTOMER
    int create(Customer customer);
    
    //GETTER FOR CUSTOMER LIST
    List<Customer> getCustomerList();
    
    //Read
    List<Customer> read();

}
