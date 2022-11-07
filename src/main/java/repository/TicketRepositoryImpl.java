package repository;

import enums.PaymentMethod;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.Itinerary;

import model.Ticket;
import services.TicketService;
import services.TicketServiceImpl;

public class TicketRepositoryImpl implements TicketRepository {

    private List<Ticket> ticketList = new ArrayList<>();
    TicketService ticketService = new TicketServiceImpl();

    //CONSTRUCTOR
    public TicketRepositoryImpl() {
    }

    //INITIAL POPOULATION OF THE TICKET LIST
    @Override
    public List<Ticket> populateTicketList(List<Customer> customerList, List<Itinerary> itineraryList) {
        ticketList.add(new Ticket(1, itineraryList.get(1).getId(), customerList.get(0).getId(), PaymentMethod.CASH, ticketService.discount(PaymentMethod.CASH, customerList.get(0).getCustomerCategory(), itineraryList.get(1).getBasicPrice())));
        ticketList.add(new Ticket(2, itineraryList.get(2).getId(), customerList.get(1).getId(), PaymentMethod.CASH, ticketService.discount(PaymentMethod.CASH, customerList.get(1).getCustomerCategory(), itineraryList.get(2).getBasicPrice())));
        ticketList.add(new Ticket(3, itineraryList.get(2).getId(), customerList.get(2).getId(), PaymentMethod.CREDIT, ticketService.discount(PaymentMethod.CREDIT, customerList.get(2).getCustomerCategory(), itineraryList.get(2).getBasicPrice())));
        ticketList.add(new Ticket(4, itineraryList.get(3).getId(), customerList.get(1).getId(), PaymentMethod.CREDIT, ticketService.discount(PaymentMethod.CREDIT, customerList.get(1).getCustomerCategory(), itineraryList.get(3).getBasicPrice())));
        ticketList.add(new Ticket(5, itineraryList.get(3).getId(), customerList.get(2).getId(), PaymentMethod.CASH, ticketService.discount(PaymentMethod.CASH, customerList.get(2).getCustomerCategory(), itineraryList.get(3).getBasicPrice())));
        ticketList.add(new Ticket(6, itineraryList.get(6).getId(), customerList.get(3).getId(), PaymentMethod.CREDIT, ticketService.discount(PaymentMethod.CREDIT, customerList.get(3).getCustomerCategory(), itineraryList.get(6).getBasicPrice())));
        ticketList.add(new Ticket(7, itineraryList.get(6).getId(), customerList.get(4).getId(), PaymentMethod.CREDIT, ticketService.discount(PaymentMethod.CREDIT, customerList.get(4).getCustomerCategory(), itineraryList.get(6).getBasicPrice())));
        ticketList.add(new Ticket(8, itineraryList.get(8).getId(), customerList.get(1).getId(), PaymentMethod.CASH, ticketService.discount(PaymentMethod.CASH, customerList.get(1).getCustomerCategory(), itineraryList.get(8).getBasicPrice())));
        ticketList.add(new Ticket(9, itineraryList.get(2).getId(), customerList.get(0).getId(), PaymentMethod.CASH, ticketService.discount(PaymentMethod.CASH, customerList.get(0).getCustomerCategory(), itineraryList.get(3).getBasicPrice())));
        return ticketList;
    }

    //GETTER FOR THE TICKET LIST
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    //ADD TICKET TO TICKETLIST
    @Override
    public int create(Ticket ticket) {
        ticketList.add(ticket);
        return ticket.getId();
    }

    //READ
    @Override
    public List<Ticket> read() {
        return ticketList;
    }

}
