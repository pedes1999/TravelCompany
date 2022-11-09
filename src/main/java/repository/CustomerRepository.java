package repository;

import enums.CustomerCategory;
import model.Customer;

public interface CustomerRepository extends Repository<Customer> {

    /**
     *
     * @param customerId
     * @param email
     * updates a specific User's email
     */
    void update(int customerId, String email);
    
    /**
     *
     * @param customerId
     * @return the Customer Category of a user based on id.
     */
    CustomerCategory readCustomerCategory(int customerId);
        
    
}
