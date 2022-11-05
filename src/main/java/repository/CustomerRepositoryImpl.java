
package repository;

import enums.CustomerCategory;
import java.util.ArrayList;
import java.util.List;
import model.Customer;


public class CustomerRepositoryImpl implements CustomerRepository{
    List<Customer> customerList = new ArrayList<>();
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
