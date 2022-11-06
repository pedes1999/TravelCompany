package services;

import enums.CustomerCategory;
import enums.PaymentMethod;
import java.util.List;
import java.util.Scanner;
import model.Customer;
import model.Itinerary;
import model.Ticket;

public class TicketServiceImpl implements TicketService {
    
    
    //DISCOUNT METHOD
    @Override
    public double discount(PaymentMethod paymentMethod, CustomerCategory customerCategory, double initialPrice) {
        if (customerCategory.equals(CustomerCategory.BUSINESS)) {
            if (paymentMethod == PaymentMethod.CASH) {
                return initialPrice - (0.1 * initialPrice);
            } else if (paymentMethod == PaymentMethod.CREDIT) {
                return initialPrice - (0.2 * initialPrice);
            }
        }

        if (customerCategory.equals(CustomerCategory.INDIVIDUAL)) {
            if (paymentMethod == PaymentMethod.CASH) {
                return initialPrice - (0.2 * initialPrice);
            } else if (paymentMethod == PaymentMethod.CREDIT) {
                return initialPrice - (0.3 * initialPrice);
            }
        }

        return 0;
    }
    
    //CREATE TICKET FROM CONSOLE
    @Override
    public Ticket createTicketFromConsole(List<Customer> customerList, List<Itinerary> itineraryList, List<Ticket> ticketList) {
        Scanner sc = new Scanner(System.in);
        int ticketLastId = ticketList.size();
        Ticket newTicket = new Ticket();
        
        //Set ticket Id incrementing by one
        newTicket.setId(ticketLastId + 1);

        //Set Ticket's CustomerId
        System.out.println("Please select the customer's id you want to buy a ticket for : ");
        for (Customer c : customerList) {
            System.out.println(c);
        }
        Integer customerId = sc.nextInt() - 1;

        //Select a customer from the list
        Customer selectedCustomer = customerList.get(customerId);
        newTicket.setCustomerId(selectedCustomer.getId());
        //!!!!!!!!!!!!!!!!!!!!!!!     EXCEPTION FOR CUSTOMERID HERE !!!!!!!!!!!!!!!!!!!!!

        //Set Ticket's ItineraryId
        System.out.println("Please select the itinerary's id you want to buy a ticket for : ");
        for (Itinerary t : itineraryList) {
            System.out.println(t);
        }
        Integer itineraryId = sc.nextInt() - 1;

        //Select a customer from the list
        Itinerary selectedItinerary = itineraryList.get(itineraryId);
        newTicket.setItineraryId(selectedItinerary.getId());
        //!!!!!!!!!!!!!!!!!!!!!!!!!!! EXCEPTION FOR ITINERARYID HERE !!!!!!!!!!!!!!!!!!!!!!

        //Set Ticket PaymentMethod
        while (true) {
            System.out.println("Please select the Payment Method: ");
            System.out.println("1: CASH");
            System.out.println("2: CREDIT");
            Integer paymentChoice = sc.nextInt();
            if (paymentChoice.equals(1)) {
                newTicket.setPaymentMethod(PaymentMethod.CASH);
                break;
            } else if (paymentChoice.equals(2)) {
                newTicket.setPaymentMethod(PaymentMethod.CREDIT);
                break;
            } else {
                System.out.println("Please enter a valid Payment Method");
            }
        }

        //Set Ticket PaymentAmount
        System.out.println(newTicket.getPaymentMethod());
        System.out.println(selectedCustomer.getCustomerCategory());
        System.out.println(selectedItinerary.getBasicPrice());
        newTicket.setPaymentAmount(discount(newTicket.getPaymentMethod(), selectedCustomer.getCustomerCategory(), selectedItinerary.getBasicPrice()));

        return newTicket;
    }

}
