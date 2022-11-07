package repoImpl;

import model.Ticket;
import repository.TicketRepository;

public class TicketRepositoryImpl extends RepositoryImpl<Ticket> implements TicketRepository {

    @Override
    public void update(int productId, double price) {
        Ticket ticket = read(productId);
        if (ticket != null) {
            ticket.setPaymentAmount(price);
        }
    }

}
