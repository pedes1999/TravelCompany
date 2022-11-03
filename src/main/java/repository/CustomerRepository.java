
package repository;

import model.Customer;


public interface CustomerRepository {
    //CRUD
    //Create
    int create(Customer customer);
    
    //Read
    Customer[] read();
    
    //Update
    void update(int customerId,String email);
    
    //Delete
    boolean delete(int customerId);
}
