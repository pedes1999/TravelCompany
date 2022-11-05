package services;

import enums.CustomerCategory;
import enums.PaymentMethod;
import java.util.List;
import java.util.Scanner;
import model.Customer;
import model.Itinerary;
import model.Ticket;

public class TicketServiceImpl implements TicketService {

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

    @Override
    public Ticket createTicketFromConsole(List<Customer> customerList, List<Itinerary> itineraryList, List<Ticket> ticketList) {
        Scanner sc = new Scanner(System.in);
        int ticketLastId = ticketList.size();
        Ticket newTicket = new Ticket();
        System.out.println(customerList);
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

    @Override
    public List<Ticket> populateTicketData(List<Customer> customerList, List<Itinerary> itineraryList, List<Ticket> ticketList) {
        ticketList.add(new Ticket(1, itineraryList.get(1).getId(), customerList.get(0).getId(), PaymentMethod.CASH, discount(PaymentMethod.CASH, customerList.get(0).getCustomerCategory(), itineraryList.get(1).getBasicPrice())));
        ticketList.add(new Ticket(2, itineraryList.get(2).getId(), customerList.get(1).getId(), PaymentMethod.CASH, discount(PaymentMethod.CASH, customerList.get(1).getCustomerCategory(), itineraryList.get(2).getBasicPrice())));
        ticketList.add(new Ticket(3, itineraryList.get(2).getId(), customerList.get(2).getId(), PaymentMethod.CREDIT, discount(PaymentMethod.CREDIT, customerList.get(2).getCustomerCategory(), itineraryList.get(2).getBasicPrice())));
        ticketList.add(new Ticket(4, itineraryList.get(3).getId(), customerList.get(1).getId(), PaymentMethod.CREDIT, discount(PaymentMethod.CREDIT, customerList.get(1).getCustomerCategory(), itineraryList.get(3).getBasicPrice())));
        ticketList.add(new Ticket(5, itineraryList.get(3).getId(), customerList.get(2).getId(), PaymentMethod.CASH, discount(PaymentMethod.CASH, customerList.get(2).getCustomerCategory(), itineraryList.get(3).getBasicPrice())));
        ticketList.add(new Ticket(6, itineraryList.get(6).getId(), customerList.get(3).getId(), PaymentMethod.CREDIT, discount(PaymentMethod.CREDIT, customerList.get(3).getCustomerCategory(), itineraryList.get(6).getBasicPrice())));
        ticketList.add(new Ticket(7, itineraryList.get(6).getId(), customerList.get(4).getId(), PaymentMethod.CREDIT, discount(PaymentMethod.CREDIT, customerList.get(4).getCustomerCategory(), itineraryList.get(6).getBasicPrice())));
        ticketList.add(new Ticket(8, itineraryList.get(8).getId(), customerList.get(1).getId(), PaymentMethod.CASH, discount(PaymentMethod.CASH, customerList.get(1).getCustomerCategory(), itineraryList.get(8).getBasicPrice())));
        ticketList.add(new Ticket(9, itineraryList.get(2).getId(), customerList.get(0).getId(), PaymentMethod.CASH, discount(PaymentMethod.CASH, customerList.get(0).getCustomerCategory(), itineraryList.get(3).getBasicPrice())));
        return ticketList;
    }

}
