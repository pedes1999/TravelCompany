

package com.travelcompany.eshop;

import enums.AirportCode;
import enums.CustomerCategory;
import enums.PaymentMethod;
import java.util.Date;
import model.Customer;
import model.Itinerary;
import model.OrderedTickets;
import services.TicketService;
import services.TicketServiceImpl;

public class Eshop {

    public static void main(String[] args) {
        
        //customer1
        Customer customer =new Customer();
        customer.setId(1);
        customer.setCustomerName("Periklis Desyllas");
        customer.setCustomerAddress("Athens");
        customer.setCustomerEmail("pnbdreamhack@mail.com");
        customer.setCustomerNationality("Greek");
        customer.setCustomerCategory(CustomerCategory.BUSINESS);
        
        
        //Itenerary1
        Itinerary itinerary = new Itinerary();
        itinerary.setId(2);
        itinerary.setItineraryDeparture(AirportCode.PAR);
        itinerary.setItineraryDestination(AirportCode.ATH);
        Date d = new Date();
        itinerary.setItineraryDepartureDate(d);
        itinerary.setItineraryAirline("Skyline");
        itinerary.setBasicPrice(500);
        
        
        //OrderedTickets
        OrderedTickets ordert = new OrderedTickets();
        ordert.setId(1);
        ordert.setCustomerId(customer.getId());
        ordert.setIteneraryId(itinerary.getId());
        ordert.setPaymentMethod(PaymentMethod.CASH);
        //Payment Here
        //ordert.setPaymentAmount();
        
        
        TicketService ticketService = new TicketServiceImpl();
        System.out.println(ticketService.discount(ordert.getPaymentMethod(), customer.getCustomerCategory(),itinerary.getBasicPrice() ));
        
        
        System.out.println(itinerary);
        System.out.println("=======================================");
        System.out.println(customer);
        System.out.println("=======================================");
        System.out.println(ordert);
        
    }
}
