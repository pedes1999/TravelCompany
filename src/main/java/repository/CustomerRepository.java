package repository;

import model.Customer;

public interface CustomerRepository extends Repository<Customer> {

    //Update User's email
    void update(int customerId, String email);
}
