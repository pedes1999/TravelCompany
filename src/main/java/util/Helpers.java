/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.List;
import model.Customer;
import model.Ticket;
import repository.CustomerRepository;
import repository.ItineraryRepository;
import repository.TicketRepository;
import services.MarketService;

/**
 *
 * @author pnbdr
 */
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

    public int getInitialTicketsForCustomer(int customerId, List<Ticket> ticketList) {
        int ticketCounter = 0;
        for (Ticket ticket : ticketRepository.read()) {
            if (customerId == ticket.getCustomerId()) {
                ticketCounter++;
            }

        }
        return ticketCounter;
    }
    
     public double getInitialMneySpentForCustomer(int customerId, List<Ticket> ticketList) {
        double moneySpent = 0 ;
        for (Ticket ticket : ticketRepository.read()) {
            if (customerId == ticket.getCustomerId()) {
                moneySpent = moneySpent + ticket.getPaymentAmount();
            }

        }
        return moneySpent;
    }
}
