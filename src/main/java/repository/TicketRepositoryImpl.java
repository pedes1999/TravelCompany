
package repository;

import java.util.ArrayList;
import java.util.List;
import model.Ticket;


public class TicketRepositoryImpl implements TicketRepository{
    List<Ticket> ticketList = new ArrayList<>();
    
    
    public void populateCustomers(){
        
    }
    
    
    
    @Override
    public int create(Ticket ticket) {
       ticketList.add(ticket);
       return ticket.getId();
    }

    @Override
    public List<Ticket> read() {
        return ticketList;
    }


    @Override
    public void update(int ticketId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int ticketId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
