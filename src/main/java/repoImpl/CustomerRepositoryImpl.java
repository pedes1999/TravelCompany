package repoImpl;

import enums.CustomerCategory;
import model.Customer;
import repository.CustomerRepository;

public class CustomerRepositoryImpl extends RepositoryImpl<Customer> implements CustomerRepository {

    /**
     *
     * @param customerId
     * @param email updates a specific User's email
     */
    @Override
    public void update(int customerId, String email) {
        Customer customer = read(customerId);
        if (customer != null) {
            customer.setCustomerEmail(email);
        }
    }

    /**
     *
     * @param customerId
     * @return the Customer Category of a user based on id.
     */
    @Override
    public CustomerCategory readCustomerCategory(int customerId) {
        Customer customer = read(customerId);
        return customer.getCustomerCategory();
    }

}
