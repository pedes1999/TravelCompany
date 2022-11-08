/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import enums.AirportCode;
import enums.CustomerCategory;
import enums.PaymentMethod;
import java.util.List;
import model.Customer;
import model.Itinerary;
import model.Ticket;

/**
 *
 * @author pnbdr
 */
public interface MarketService {
    
    boolean addCustomer(Customer customer);
    boolean addItinerary(Itinerary itinerary);
    boolean addTicket(Ticket ticket);
    
      //Search BASED ON DEPARTURE
    List<Itinerary> searchDeparture(AirportCode airportCode);
    
    //Search BASED ON DESTINATION
    List<Itinerary> searchDestination(AirportCode airportCode);
    
    double discount(PaymentMethod paymentMethod, CustomerCategory customerCategory, double initialPrice);
    //search customers who didnt buy any tickets
    List<Customer> searchIfNotBuy(List<Customer> customerList, List<Ticket> ticketList);
    
    //search customers who have the most tickets
    List<Customer> customerMostTickets(List<Customer> customerList, List<Ticket> ticketList);
   
    
}
