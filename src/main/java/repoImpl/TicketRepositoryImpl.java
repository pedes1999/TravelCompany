package repoImpl;

import model.Ticket;
import repository.TicketRepository;

public class TicketRepositoryImpl extends RepositoryImpl<Ticket> implements TicketRepository {

    
    /**
     *
     * @param ticketId
     * @param price
     * updates a ticket's price based on id
     */
    @Override
    public void update(int ticketId, double price) {
        Ticket ticket = read(ticketId);
        if (ticket != null) {
            ticket.setPaymentAmount(price);
        }
    }

}
