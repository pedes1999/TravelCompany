package services;

import enums.CustomerCategory;
import java.util.List;
import java.util.Scanner;
import model.Customer;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer createCustomerFromConsole(List<Customer> customerList) {
        Scanner sc = new Scanner(System.in);
        int customerLastId = customerList.size();

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
        //!!!!!!!!!!!!!!EXCEPTION FOR EMAIL HERE////////////////////////////

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

    }

}
