/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;


import dtos.TotalCustTotalCost;
import enums.AirportCode;
import enums.CustomerCategory;
import enums.PaymentMethod;
import exceptions.MarketException;
import java.util.List;
import model.Customer;
import model.Itinerary;
import model.Ticket;

/**
 *
 * @author pnbdr
 */
public interface MarketService {
    
    /**
     *
     * @param customer
     * @return Creates a new customer to the Customer Repository
     * @throws MarketException
     */
    boolean addCustomer(Customer customer) throws MarketException;

    /**
     *
     * @param itinerary
     * @return Creates a new itinerary to the itinerary Repository
     * @throws MarketException
     */
    boolean addItinerary(Itinerary itinerary) throws MarketException;

    /**
     *
     * @param ticket
     * @return Creates a new Ticket to the ticket Repository
     * @throws MarketException
     */
    boolean addTicket(Ticket ticket) throws MarketException;

    /**
     *
     * @param paymentMethod
     * @param customerCategory
     * @param initialPrice
     * @return the Calculated price of a Ticket
     */
    double discount(PaymentMethod paymentMethod, CustomerCategory customerCategory, double initialPrice);

    /**
     *
     * @param customerList
     * @param ticketList
     * @return the number of Customers and their total amount spent
     */
    List<TotalCustTotalCost> searchCustomerNumAndTotalCost(List<Customer> customerList, List<Ticket> ticketList);

    /**
     *
     * @param airportCode
     * @return list of itineraries based on Departure Code
     */
    List<Itinerary> searchDeparture(AirportCode airportCode); 

    /**
     *
     * @param airportCode
     * @return list of itineraries based on Destination Code
     */
    List<Itinerary> searchDestination(AirportCode airportCode);

    /**
     *
     * @param customerList
     * @param ticketList
     * @return list of customers who haven't bought any tickets
     */
    List<Customer> SearchCustomersNotPurchased(List<Customer> customerList, List<Ticket> ticketList);

    /**
     *
     * @param customerList
     * @param ticketList
     * @return list of customers with descenting order based on their tickets Purchased
     */
    List<Customer> searchCustomersWithMostTickets(List<Customer> customerList, List<Ticket> ticketList);

    /**
     *
     * @param customerList
     * @param ticketList
     * @return list of customers with descenting order based on their amount spent
     */
    List<Customer> searchCustomerWithHighestTotalCost(List<Customer> customerList,List<Ticket> ticketList);
    
  
    
}
