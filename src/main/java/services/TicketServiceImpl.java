
package services;

import enums.CustomerCategory;
import enums.PaymentMethod;



public class TicketServiceImpl implements TicketService{
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
        
    }

   
    

