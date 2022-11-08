package services;

import enums.AirportCode;
import enums.CustomerCategory;
import enums.PaymentMethod;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Customer;
import model.Itinerary;
import model.Ticket;
import repository.CustomerRepository;
import repository.ItineraryRepository;
import repository.TicketRepository;

public class MarketServiceImpl implements MarketService {

    private final CustomerRepository customerRepository;
    private final TicketRepository ticketRepository;
    private final ItineraryRepository itineraryRepository;

    public MarketServiceImpl(CustomerRepository customerRepository, TicketRepository ticketRepository, ItineraryRepository itineraryRepository) {
        this.customerRepository = customerRepository;
        this.ticketRepository = ticketRepository;
        this.itineraryRepository = itineraryRepository;
    }

    //Add Customer
    @Override
    public boolean addCustomer(Customer customer) {

        if (customer == null) {
            return false;
        }
        if (customer.getCustomerEmail() == null) {
            return false;
        }

        customerRepository.create(customer);
        return true;
    }

    //Add Itinerary
    @Override
    public boolean addItinerary(Itinerary itinerary) {

        if (itinerary == null) {
            return false;
        }

        itineraryRepository.create(itinerary);
        return true;
    }

    //Add Ticket
    @Override
    public boolean addTicket(Ticket ticket) {

        if (ticket == null) {
            return false;
        }

        ticketRepository.create(ticket);
        return true;
    }

    //READ BASED ON DEPARTURE/DESTINATION CODE
    @Override
    public List<Itinerary> searchDeparture(AirportCode airportCode) {
        List<Itinerary> departureList = new ArrayList<>();
        for (Itinerary itinerary : itineraryRepository.read()) {
            if (itinerary.getItineraryDeparture().equals(airportCode)) {
                departureList.add(itinerary);
            }
        }
        return departureList;
    }

    @Override
    public List<Itinerary> searchDestination(AirportCode airportCode) {
        List<Itinerary> destinationList = new ArrayList<>();
        for (Itinerary itinerary : itineraryRepository.read()) {
            if (itinerary.getIteneraryDestination().equals(airportCode)) {
                destinationList.add(itinerary);
            }
        }
        return destinationList;
    }

    //DISCOUNT METHOD
    @Override
    public double discount(PaymentMethod paymentMethod, CustomerCategory customerCategory, double initialPrice) {
        if (customerCategory.equals(CustomerCategory.BUSINESS)) {
            if (paymentMethod == PaymentMethod.CASH) {
                return initialPrice - (0.1 * initialPrice);
            } else if (paymentMethod == PaymentMethod.CREDIT) {
                return initialPrice - (0.2 * initialPrice);
            }
        }

        if (customerCategory.equals(CustomerCategory.INDIVIDUAL)) {
            if (paymentMethod == PaymentMethod.CASH) {
                return initialPrice + (0.2 * initialPrice);
            } else if (paymentMethod == PaymentMethod.CREDIT) {
                return initialPrice + (0.1 * initialPrice);
            }
        }

        return 0;
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
