package repository;

import enums.CustomerCategory;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

public class CustomerRepositoryImpl implements CustomerRepository {

    private List<Customer> customerList = new ArrayList<>();

    //INITIAL POPULATION!!!
    public CustomerRepositoryImpl() {
        customerList.add(new Customer(1, "Maria Iordanous", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customerList.add(new Customer(2, "Dimitriou Dimitrios", "ddimitriou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customerList.add(new Customer(3, "Ioannis Ioannou", "iioannou@mail.com", "Athens", "Greek", CustomerCategory.BUSINESS));
        customerList.add(new Customer(4, "Antonio Molinari", "amolinari@mail.com", "Milan", "Italian", CustomerCategory.INDIVIDUAL));
        customerList.add(new Customer(5, "Frederico Rossi", "frossi@mail.com", "Milan", "Italian", CustomerCategory.INDIVIDUAL));
        customerList.add(new Customer(6, "Mario Conti", "mconti@mail.com", "Rome", "Italian", CustomerCategory.BUSINESS));
        customerList.add(new Customer(7, "Nathan Martin", "nmartin@mail.com", "Lyon", "French", CustomerCategory.BUSINESS));
        customerList.add(new Customer(8, "Enzo Collin", "ecollin@mail.com", "Lyon", "French", CustomerCategory.INDIVIDUAL));
        customerList.add(new Customer(9, "Frederic Michel", "fmichel@mail.com", "Athens", "French", CustomerCategory.INDIVIDUAL));
    }

    //GETTER FOR CUSTOMER LIST
    @Override
    public List<Customer> getCustomerList() {
        return customerList;
    }

    //CREATE A NEW CUSTOMER
    @Override
    public int create(Customer customer) {

        customerList.add(customer);
        return customer.getId();

    }

    //READ
    @Override
    public List<Customer> read() {
        return customerList;
    }

}
