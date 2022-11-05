package services;

import enums.CustomerCategory;
import enums.PaymentMethod;
import java.util.List;
import model.Customer;
import model.Itinerary;
import model.Ticket;

public interface TicketService {

    double discount(PaymentMethod paymentMethod, CustomerCategory customerCategory, double initialPrice);

    Ticket createTicketFromConsole(List<Customer> customerList, List<Itinerary> itineraryList, List<Ticket> ticketList);
    
    List<Ticket> populateTicketData(List<Customer> customerList, List<Itinerary> itineraryList, List<Ticket> ticketList);
}
