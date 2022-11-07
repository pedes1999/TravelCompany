/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import enums.AirportCode;
import enums.CustomerCategory;
import enums.PaymentMethod;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.Itinerary;
import model.Ticket;
import repository.CustomerRepository;
import repository.ItineraryRepository;
import repository.TicketRepository;

/**
 *
 * @author pnbdr
 */
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
        return itineraryRepository.searchPerDeparture(airportCode);
    }

    @Override
    public List<Itinerary> searchDestination(AirportCode airportCode) {
        return itineraryRepository.searchPerDestination(airportCode);
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
}
