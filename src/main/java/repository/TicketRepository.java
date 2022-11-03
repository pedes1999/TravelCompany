
package repository;

import model.OrderedTickets;

public interface TicketRepository {
    //CRUD
    //Create
    int create(OrderedTickets ticketId);
    //Read Single
    OrderedTickets read( int customerId);
    
    //Read multiple
    OrderedTickets[] read();
    
    //Update email
    void update(int ticketId);
    
   //Delete
    boolean delete(int ticketId);
}
