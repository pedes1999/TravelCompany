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
    
      //READ BASED ON DEPARTURE
    List<Itinerary> readDeparture(AirportCode airportCode,List<Itinerary> itineraryList);
    
    //READ BASED ON DESTINATION
    List<Itinerary> readDestination(AirportCode airportCode,List<Itinerary> itineraryList);
    
    double discount(PaymentMethod paymentMethod, CustomerCategory customerCategory, double initialPrice);

   
    
}