package repoImpl;

import enums.CustomerCategory;
import model.Customer;
import repository.CustomerRepository;

public class CustomerRepositoryImpl extends RepositoryImpl<Customer> implements CustomerRepository {

    @Override
    public void update(int customerId, String email) {
        Customer customer = read(customerId);
        if (customer != null) {
            customer.setCustomerEmail(email);
        }
    }

    @Override
    public CustomerCategory readCustomerCategory(int customerId) {
        Customer customer = read(customerId);
        return customer.getCustomerCategory();
    }

}
