package util;

import java.util.List;
import model.Ticket;
import repository.CustomerRepository;
import repository.ItineraryRepository;
import repository.TicketRepository;
import services.MarketService;

public class Helpers {

    private final CustomerRepository customerRepository;
    private final TicketRepository ticketRepository;
    private final ItineraryRepository itineraryRepository;
    private final MarketService marketService;

    public Helpers(CustomerRepository customerRepository, TicketRepository ticketRepository, ItineraryRepository itineraryRepository, MarketService marketService) {
        this.customerRepository = customerRepository;
        this.ticketRepository = ticketRepository;
        this.itineraryRepository = itineraryRepository;
        this.marketService = marketService;
    }

    /**
     *
     * @param customerId
     * @param ticketList
     * @return returns the initial Tickets purchased by customers
     */
    public int getInitialTicketsForCustomer(int customerId, List<Ticket> ticketList) {
        int ticketCounter = 0;
        for (Ticket ticket : ticketRepository.read()) {
            if (customerId == ticket.getCustomerId()) {
                ticketCounter++;
            }

        }
        return ticketCounter;
    }

    /**
     *
     * @param customerId
     * @param ticketList
     * @return returns the initial amount paid by customers
     */
    public double getInitialMneySpentForCustomer(int customerId, List<Ticket> ticketList) {
        double moneySpent = 0;
        for (Ticket ticket : ticketRepository.read()) {
            if (customerId == ticket.getCustomerId()) {
                moneySpent = moneySpent + ticket.getPaymentAmount();
            }

        }
        return moneySpent;
    }

}
