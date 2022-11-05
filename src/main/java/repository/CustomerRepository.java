
package repository;

import java.util.List;
import model.Customer;


public interface CustomerRepository {
    //CRUD
    //Create
    int create(Customer customer);
    
    //Read
    List<Customer> read();
    
    //Update
    void update(int customerId,String email);
    
    //Delete
    boolean delete(int customerId);
}
