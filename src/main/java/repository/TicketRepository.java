package repository;

import model.Ticket;

public interface TicketRepository extends Repository<Ticket> {

    //INITIAL POPULATION OF TICKET LIST
    void update(int TicketId, double price);

}
