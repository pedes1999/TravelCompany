package repository;

import model.Ticket;

public interface TicketRepository extends Repository<Ticket> {

    /**
     *
     * @param TicketId
     * @param price
     * updates a ticket's price based on id
     */
    void update(int TicketId, double price);

}
