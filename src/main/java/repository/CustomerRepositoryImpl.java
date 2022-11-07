package repository;

import enums.CustomerCategory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Customer;
import model.Ticket;

public class CustomerRepositoryImpl implements CustomerRepository {

    private List<Customer> customerList = new ArrayList<>();

    //INITIAL POPULATION!!!
    public CustomerRepositoryImpl() {
        customerList.add(new Customer(1, "Maria Iordanous", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL, 2));
        customerList.add(new Customer(2, "Dimitriou Dimitrios", "ddimitriou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL, 3));
        customerList.add(new Customer(3, "Ioannis Ioannou", "iioannou@mail.com", "Athens", "Greek", CustomerCategory.BUSINESS, 2));
        customerList.add(new Customer(4, "Antonio Molinari", "amolinari@mail.com", "Milan", "Italian", CustomerCategory.INDIVIDUAL, 1));
        customerList.add(new Customer(5, "Frederico Rossi", "frossi@mail.com", "Milan", "Italian", CustomerCategory.INDIVIDUAL, 1));
        customerList.add(new Customer(6, "Mario Conti", "mconti@mail.com", "Rome", "Italian", CustomerCategory.BUSINESS, 0));
        customerList.add(new Customer(7, "Nathan Martin", "nmartin@mail.com", "Lyon", "French", CustomerCategory.BUSINESS, 0));
        customerList.add(new Customer(8, "Enzo Collin", "ecollin@mail.com", "Lyon", "French", CustomerCategory.INDIVIDUAL, 0));
        customerList.add(new Customer(9, "Frederic Michel", "fmichel@mail.com", "Athens", "French", CustomerCategory.INDIVIDUAL, 0));
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

    //GETTING THE CUSTOMERSPENT FOR THE PREPOPULATED DATA
    @Override
    public void populateCustomerPrice(List<Customer> customerList, List<Ticket> ticketList) {
        for (Customer c : customerList) {
            for (Ticket t : ticketList) {
                if (c.getId() == t.getCustomerId()) {
                    c.setCustomerSpent(c.getCustomerSpent() + t.getPaymentAmount());
                }
            }
        }

    }

    //SEARCH FOR CUSTOMERS THAT HAVENT BOUGHT TICKETS
    @Override
    public List<Customer> searchIfNotBuy(List<Customer> customerList, List<Ticket> ticketList) {
        List<Customer> customerHasBoughtTicket = new ArrayList<>();
        List<Customer> customerListTemp = new ArrayList<>();
        customerListTemp.addAll(customerList);

        for (Customer customer : customerList) {
            for (Ticket ticket : ticketList) {
                if (ticket.getCustomerId() == customer.getId() && !customerHasBoughtTicket.contains(customer)) {
                    customerHasBoughtTicket.add(customer);
                }
            }
        }
        customerListTemp.removeAll(customerHasBoughtTicket);
        return customerListTemp;
    }

    //SEARCH FOR CUSTOMERS WITH THE MOST TICKETS
    @Override
    public List<Customer> customerMostTickets(List<Customer> customerList, List<Ticket> ticketList) {
        Set<Customer> setWithMostTickets = new HashSet<>();
        for (Customer c : customerList) {
            for (Ticket t : ticketList) {
                if (c.getId() == t.getCustomerId()) {

                    setWithMostTickets.add(c);

                }

            }
        }

        List<Customer> listWithMostTickets = new ArrayList<>(setWithMostTickets);
        return listWithMostTickets;
    }

}
