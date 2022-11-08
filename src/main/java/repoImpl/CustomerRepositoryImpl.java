package repoImpl;

import model.Customer;
import repository.CustomerRepository;

public class CustomerRepositoryImpl extends RepositoryImpl<Customer> implements CustomerRepository {
    //UPDATE USER'S EMAIL
    @Override
    public void update(int customerId, String email) {
        Customer customer = read(customerId);
        if (customer != null) {
            customer.setCustomerEmail(email);
        }
    }

}
