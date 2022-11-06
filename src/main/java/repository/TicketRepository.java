
package repository;

import java.util.List;
import model.Customer;
import model.Itinerary;
import model.Ticket;

public interface TicketRepository {
    
    //CREATE A NEW TICKET
    int create(Ticket ticket);
    
    
    //GETTER FOR THE TICKET LIST
    List<Ticket> getTicketList();
    //INITIAL POPULATION OF TICKET LIST
    //List<Ticket> populateTicketList(List<Customer> customerList,List<Itinerary> itineraryList);
    
    //Read 
    List<Ticket> read();
    
 
}
