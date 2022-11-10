package services;

import comparators.CustomerPriceComparator;
import dtos.TotalCustTotalCost;
import enums.AirportCode;
import enums.CustomerCategory;
import enums.PaymentMethod;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Customer;
import model.Itinerary;
import model.Ticket;
import repository.CustomerRepository;
import repository.ItineraryRepository;
import repository.TicketRepository;
import comparators.CustomerTicketComparator;
import exceptions.MarketException;
import exceptions.MarketExceptionCodes;

public class MarketServiceImpl implements MarketService {

    private final CustomerRepository customerRepository;
    private final TicketRepository ticketRepository;
    private final ItineraryRepository itineraryRepository;

    public MarketServiceImpl(CustomerRepository customerRepository, TicketRepository ticketRepository, ItineraryRepository itineraryRepository) {
        this.customerRepository = customerRepository;
        this.ticketRepository = ticketRepository;
        this.itineraryRepository = itineraryRepository;
    }

    @Override
    public boolean addCustomer(Customer customer) throws MarketException {

        if (customer == null) {
            throw new MarketException(MarketExceptionCodes.CUSTOMER_NOT_FOUND);
        }
        if (customer.getCustomerEmail().contains("@travelcompany.com")) {
            throw new MarketException(MarketExceptionCodes.CUSTOMER_INVALID_EMAIL);
        }

        customerRepository.create(customer);
        return true;
    }

    @Override
    public boolean addItinerary(Itinerary itinerary) throws MarketException {

        if (itinerary == null) {
            throw new MarketException(MarketExceptionCodes.ITINERARY_NOT_FOUND);
        }
        if (itinerary.getItineraryDeparture() == null) {
            throw new MarketException(MarketExceptionCodes.AIRPORT_CODE_NOT_FOUND);
        }
        if (itinerary.getItineraryDestination() == null) {
            throw new MarketException(MarketExceptionCodes.AIRPORT_CODE_NOT_FOUND);
        }

        itineraryRepository.create(itinerary);
        return true;
    }

    @Override
    public boolean addTicket(Ticket ticket) throws MarketException {
        List<Integer> customerIdList = new ArrayList();
        List<Integer> itineraryIdList = new ArrayList();
        for (Customer c : customerRepository.read()) {
            customerIdList.add(c.getId());
        }

        for (Itinerary i : itineraryRepository.read()) {
            itineraryIdList.add(i.getId());
        }
        if (ticket == null) {
            return false;
        }

        if (!customerIdList.contains(ticket.getCustomerId())) {
            throw new MarketException(MarketExceptionCodes.CUSTOMER_NOT_FOUND);
        }

        if (!itineraryIdList.contains(ticket.getItineraryId())) {
            throw new MarketException(MarketExceptionCodes.ITINERARY_NOT_FOUND);
        }
        ticketRepository.create(ticket);
        for (Customer c : customerRepository.read()) {            
            if (ticket.getCustomerId() == c.getId()) {
                c.setTicketsPurchased(c.getTicketsPurchased() + 1);
                c.setCustomerSpent(c.getCustomerSpent() + ticket.getPaymentAmount());
            }
        }
        return true;
    }

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

    @Override
    public List<TotalCustTotalCost> searchCustomerNumAndTotalCost(List<Customer> customerList, List<Ticket> ticketList) {
        List<TotalCustTotalCost> totalList = new ArrayList<>();
        TotalCustTotalCost totalInfo = new TotalCustTotalCost();
        double costSum = 0;
        int customerCounter = 0;
        for (Customer c : customerList) {
            customerCounter++;
        }

        for (Ticket t : ticketList) {
            costSum = costSum + t.getPaymentAmount();
        }
        totalInfo.setTotalCustomers(customerCounter);
        totalInfo.setTotalTicketPrice(costSum);
        totalList.add(totalInfo);
        return totalList;
    }

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
            if (itinerary.getItineraryDestination().equals(airportCode)) {
                destinationList.add(itinerary);
            }
        }
        return destinationList;
    }

    @Override
    public List<Customer> SearchCustomersNotPurchased(List<Customer> customerList, List<Ticket> ticketList) {
        List<Customer> customerHasBoughtTicket = new ArrayList<>();
        List<Customer> customerNotBought = new ArrayList<>();
        customerNotBought.addAll(customerList);

        for (Customer customer : customerList) {
            for (Ticket ticket : ticketList) {
                if (ticket.getCustomerId() == customer.getId() && !customerHasBoughtTicket.contains(customer)) {
                    customerHasBoughtTicket.add(customer);
                }
            }
        }
        customerNotBought.removeAll(customerHasBoughtTicket);
        return customerNotBought;
    }

    @Override
    public List<Customer> searchCustomersWithMostTickets(List<Customer> customerList, List<Ticket> ticketList) {
        Set<Customer> setWithMostTickets = new HashSet<>();
        for (Customer c : customerList) {
            for (Ticket t : ticketList) {
                if (c.getId() == t.getCustomerId()) {
                    setWithMostTickets.add(c);
                }
            }
        }
        List<Customer> customersWithMostTickets = new ArrayList<>(setWithMostTickets);
        Collections.sort(customersWithMostTickets, new CustomerTicketComparator());
        return customersWithMostTickets;
    }

    @Override
    public List<Customer> searchCustomerWithHighestTotalCost(List<Customer> customerList, List<Ticket> ticketList) {
        Set<Customer> setWithHighestCost = new HashSet<>();
        for (Customer c : customerList) {
            for (Ticket t : ticketList) {
                if (c.getId() == t.getCustomerId()) {
                    setWithHighestCost.add(c);
                }
            }
        }
        List<Customer> customersWithHighestCost = new ArrayList<>(setWithHighestCost);
        Collections.sort(customersWithHighestCost, new CustomerPriceComparator());
        return customersWithHighestCost;
    }

}
