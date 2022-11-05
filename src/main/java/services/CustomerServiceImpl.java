
package services;

import enums.CustomerCategory;
import java.util.List;
import java.util.Scanner;
import model.Customer;
import repository.CustomerRepository;
import repository.CustomerRepositoryImpl;


public class CustomerServiceImpl implements CustomerService {
 CustomerRepository customerRepository = new CustomerRepositoryImpl();
 List<Customer> customerList = customerRepository.read();
    @Override
    public List<Customer> populateCustomers() {
        customerRepository.create(new Customer(1, "Maria Iordanou", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customerRepository.create(new Customer(2, "Dimitriou Dimitrios", "ddimitriou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customerRepository.create(new Customer(3, "Ioannis Ioannou", "iioannou@mail.com", "Athens", "Greek", CustomerCategory.BUSINESS));
        customerRepository.create(new Customer(4, "Antonio Molinari", "amolinari@mail.com", "Milan", "Italian", CustomerCategory.INDIVIDUAL));
        customerRepository.create(new Customer(5, "Frederico Rossi", "frossi@mail.com", "Milan", "Italian", CustomerCategory.INDIVIDUAL));
        customerRepository.create(new Customer(6, "Mario Conti", "mconti@mail.com", "Rome", "Italian", CustomerCategory.BUSINESS));
        
        return customerList;
    }

    @Override
    public Customer createCustomerFromConsole() {
             Scanner sc = new Scanner(System.in);
             int customerLastId = customerList.size();
             System.out.println(customerLastId);
                Customer newCustomer = new Customer();
                //Set Customer's Id based on the last incrementing by one.
                newCustomer.setId(customerLastId + 1);

                //Set Customer's Name 
                System.out.println("Please State Customer's Name : ");
                String name = sc.next();
                newCustomer.setCustomerName(name);

                //Set Customer's Email
                System.out.println("Please state Customer's Email : ");
                String email = sc.next();
                newCustomer.setCustomerEmail(email);

                //Set Customer's Address
                System.out.println("Please state Customer's City : ");
                String address = sc.next();
                newCustomer.setCustomerAddress(address);

                //Set Customer's Nationality
                System.out.println("Please state Customer's nationality : ");
                String nationality = sc.next();
                newCustomer.setCustomerNationality(nationality);

                //Set Customer's Category
                while (true) {
                    System.out.println("Please state Customer's Category : ");
                    System.out.println("The Choices are : ");
                    System.out.println("1 : Individual");
                    System.out.println("2 : Bussiness");
                    Integer choiceCategory = sc.nextInt();
                    if (choiceCategory.equals(1)) {
                        newCustomer.setCustomerCategory(CustomerCategory.INDIVIDUAL);
                        break;
                    } else if (choiceCategory.equals(2)) {
                        newCustomer.setCustomerCategory(CustomerCategory.BUSINESS);
                        break;
                    } else {
                        System.out.println("That is not Valid. Please try again!!!!");
                    }

                }
                return newCustomer;
//                System.out.println(newCustomer);
//                int checkId = customerRepository.create(newCustomer);
//                if (checkId == newCustomer.getId()) {
//                    System.out.println("The Customer Was Created Successfuly!");
//                } else {
//                    System.out.println("There was an error please try again!");
//                }
        
    }

 
}
