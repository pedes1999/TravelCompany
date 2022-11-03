
package services;

import enums.CustomerCategory;
import enums.PaymentMethod;


public interface TicketService {
    double discount(PaymentMethod paymentMethod,CustomerCategory customerCategory ,double initialPrice);
}
