
package services;

import enums.CustomerCategory;
import enums.PaymentMethod;
import java.util.List;
import model.Ticket;


public interface TicketService {
    double discount(PaymentMethod paymentMethod,CustomerCategory customerCategory ,double initialPrice);
    
    
    List<Ticket> populateTickets();
}
