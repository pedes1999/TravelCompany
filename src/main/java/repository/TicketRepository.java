package repository;

import model.Ticket;

public interface TicketRepository extends Repository<Ticket> {

    /**
     *
     * @param ticketId
     * @param price
     * updates a ticket's price based on id
     */
    void update(int ticketId, double price);

}
