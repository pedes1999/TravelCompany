
package repository;

import java.util.List;
import model.Ticket;

public interface TicketRepository {
    //CRUD
    //Create
    int create(Ticket ticket);
   
    //Read multiple
    List<Ticket> read();
    
    List<Ticket> getFullTicketList();
    //Update email
    void update(int ticketId);
    
   //Delete
    boolean delete(int ticketId);
}
