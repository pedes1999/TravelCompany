package repository;

import enums.CustomerCategory;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

public class CustomerRepositoryImpl implements CustomerRepository {

    private List<Customer> customerList = new ArrayList<>();

    @Override
    public List<Customer> getFullCustomerList() {
        return customerList;
    }

    public CustomerRepositoryImpl() {
        customerList.add(new Customer(1, "Maria Iordanous", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customerList.add(new Customer(2, "Dimitriou Dimitrios", "ddimitriou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customerList.add(new Customer(3, "Ioannis Ioannou", "iioannou@mail.com", "Athens", "Greek", CustomerCategory.BUSINESS));
        customerList.add(new Customer(4, "Antonio Molinari", "amolinari@mail.com", "Milan", "Italian", CustomerCategory.INDIVIDUAL));
        customerList.add(new Customer(5, "Frederico Rossi", "frossi@mail.com", "Milan", "Italian", CustomerCategory.INDIVIDUAL));
        customerList.add(new Customer(6, "Mario Conti", "mconti@mail.com", "Rome", "Italian", CustomerCategory.BUSINESS));
    }

    @Override
    public int create(Customer customer) {

        customerList.add(customer);
        return customer.getId();

    }

    @Override
    public List<Customer> read() {
        return customerList;

    }

    @Override
    public void update(int customerId, String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int customerId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
