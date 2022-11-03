/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import enums.CustomerCategory;
import enums.PaymentMethod;
import java.math.BigDecimal;
import repository.CustomerRepositoryImpl;
import repository.TicketRepositoryImpl;

/**
 *
 * @author pnbdr
 */
public class TicketServiceImpl implements TicketService{
    private CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
    private TicketRepositoryImpl productRepository = new TicketRepositoryImpl();

    @Override
    public double discount(PaymentMethod paymentMethod, CustomerCategory customerCategory, double initialPrice) {
        if(customerCategory.equals(CustomerCategory.BUSSINESS)) {
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

   
    

