
package services;

import enums.CustomerCategory;
import enums.PaymentMethod;
import java.util.List;
import model.Ticket;
import repository.TicketRepository;
import repository.TicketRepositoryImpl;



public class TicketServiceImpl implements TicketService{
    TicketRepository ticketRepository = new TicketRepositoryImpl();
    List<Ticket> ticketList = ticketRepository.read();
    @Override
    public double discount(PaymentMethod paymentMethod, CustomerCategory customerCategory, double initialPrice) {
        if(customerCategory.equals(CustomerCategory.BUSINESS)) {
           if(paymentMethod == PaymentMethod.CASH) {
               return initialPrice - (0.1*initialPrice);
           } else if (paymentMethod == PaymentMethod.CREDIT)
               return initialPrice - (0.2*initialPrice);
           }
        
        
        if(customerCategory.equals(CustomerCategory.INDIVIDUAL)) {
           if(paymentMethod == PaymentMethod.CASH) {
               return initialPrice - (0.2*initialPrice);
           } else if (paymentMethod == PaymentMethod.CREDIT)
               return initialPrice - (0.3*initialPrice);
           }
        
            return 0;
        }

    @Override
    public List<Ticket> populateTickets() {
        ticketRepository.create(new Ticket(1, 1, 2, PaymentMethod.CASH, 500));
        ticketRepository.create(new Ticket(2, 2, 2, PaymentMethod.CASH, 500));
        ticketRepository.create(new Ticket(3, 3, 2, PaymentMethod.CASH, 500));
        ticketRepository.create(new Ticket(4, 2, 2, PaymentMethod.CASH, 500));
        ticketRepository.create(new Ticket(5, 3, 2, PaymentMethod.CASH, 500));
        ticketRepository.create(new Ticket(6, 1, 2, PaymentMethod.CASH, 500));
        ticketRepository.create(new Ticket(7, 1, 2, PaymentMethod.CASH, 500));
        ticketRepository.create(new Ticket(8, 1, 2, PaymentMethod.CASH, 500));
        ticketRepository.create(new Ticket(9, 1, 2, PaymentMethod.CASH, 500));
        return ticketList;
    }
        
    }

   
    

