package com.travelcompany.eshop;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import model.Customer;
import model.Itinerary;
import model.Ticket;
import repository.CustomerRepository;
import repository.CustomerRepositoryImpl;
import repository.ItineraryRepository;
import repository.ItineraryRepositoryImpl;
import repository.TicketRepository;
import repository.TicketRepositoryImpl;
import services.CustomerService;
import services.CustomerServiceImpl;
import services.ItineraryService;
import services.ItineraryServiceImpl;
import services.TicketService;
import services.TicketServiceImpl;

public class Eshop {

    public static void main(String[] args) {

//             //Initiating Customer Services and Repos
        CustomerService customerService = new CustomerServiceImpl();
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

//        //Initiating Itinerary Services and Repos
        ItineraryService itineraryService = new ItineraryServiceImpl();
        ItineraryRepository itineraryRepository = new ItineraryRepositoryImpl();

//        //Initiating Ticket Services and Repos
        TicketService ticketService = new TicketServiceImpl();
        TicketRepository ticketRepository = new TicketRepositoryImpl();

//        //Initiating The Collections from repos
        List<Customer> customerList = customerRepository.getCustomerList();
        List<Itinerary> itineraryList = itineraryRepository.getItineraryList();
        List<Ticket> ticketList = ticketRepository.populateTicketList(customerList, itineraryList);
        customerRepository.populateCustomerPrice(customerList, ticketList);

        // !!!!! GUI IMPLEMENTATION !!!!!!
        boolean isRunning = true; // boolean to control the while condition to terminate Program!
        do {

            System.out.printf("--------------------------------------------\n");
            System.out.println("Please Give a number based on your Preference");
            System.out.printf("--------------------------------------------\n");
            System.out.println("CUSTOMER INFORMATION");
            System.out.printf("--------------------------------------------\n");
            System.out.println("1 : Check The Customer List");
            System.out.println("2 : Check The Customers who haven't bought any Tickets");
            System.out.println("3 : Check The Customers who have most Tickets");
            System.out.println("4 : Check The Customers with the largest cost of tickets");
            System.out.printf("--------------------------------------------\n");
            System.out.println("ITINERARY INFORMATION");
            System.out.println("5: Check The Full Itinerary List");
            System.out.println("6 : Check The Itinerary List Based on Departure/Destination Code");
            System.out.printf("--------------------------------------------\n");
            System.out.println("TICKET INFORMATION");
            System.out.println("7 : Check The Ticket List");
            System.out.printf("--------------------------------------------\n");
            System.out.println("CREATE INSTANCES");
            System.out.println("8 : Create a new Customer");
            System.out.println("9 : Create a new Itinerary");
            System.out.println("10 : Create a new Ticket");
            System.out.println("11 : Exit");
            System.out.printf("--------------------------------------------\n");

            //Get Input By User
            Scanner sc = new Scanner(System.in);
            Integer choice = sc.nextInt();

            //Print Customer List
            if (choice.equals(1)) {

                for (Customer c : customerList) {
                    System.out.println(c);
                }

            }
            //Print Customers who havent bought anything
            if (choice.equals(2)) {
                List<Customer> customerNotPurchasedList = customerRepository.searchIfNotBuy(customerList, ticketList);
                for (Customer c : customerNotPurchasedList) {
                    System.out.println(c);
                }
            }
            //List of the customers with the most tickets 
            if (choice.equals(3)) {

                List<Customer> customerWithMostTickets = customerRepository.customerMostTickets(customerList, ticketList);
                Comparator<Customer> ticketComparator = (c1, c2) -> {
                    return c2.getTicketsPurchased() - c1.getTicketsPurchased();
                };
                Collections.sort(customerWithMostTickets, ticketComparator);
                for (Customer c : customerWithMostTickets) {
                    System.out.println(c.toStringTicket());
                }
            }
            //List of the customer with the highest money Spent
            if (choice.equals(4)) {

                List<Customer> customerWithHighestCost = customerRepository.customerMostTickets(customerList, ticketList);
                Collections.sort(customerWithHighestCost);
                for (Customer c : customerWithHighestCost) {
                    System.out.println(c.toStringCost());
                }
            }
            //Print Itinerary List
            if (choice.equals(5)) {
                for (Itinerary i : itineraryList) {
                    System.out.println(i);
                }
            }
            //Print itineraryList based on Departure/Destination Code
            if (choice.equals(6)) {
                List<Itinerary> departureList = itineraryService.searchPerDepartureOrDestination(itineraryList);
                for (Itinerary i : departureList) {
                    System.out.println(i);
                }
            }
            //Print Ticket List (empty at start)
            if (choice.equals(7)) {
                for (Ticket t : ticketList) {
                    System.out.println(t);
                }
            }
            //Create a new Customer
            if (choice.equals(8)) {
                Customer newCustomer = customerService.createCustomerFromConsole(customerList);
                customerRepository.create(newCustomer);
                System.out.println("Customer was created Successfully!!");
            }
            //Create a new Itinerary
            if (choice.equals(9)) {
                Itinerary newItinerary = itineraryService.createItineraryFromConsole(itineraryList);
                itineraryRepository.create(newItinerary);
                System.out.println("Itinerary was Created Successfully!!");
            }
            //Create a new Ticket
            if (choice.equals(10)) {
                Ticket newTicket = ticketService.createTicketFromConsole(customerList, itineraryList, ticketList);
                ticketRepository.create(newTicket);
                System.out.println("Ticket was Created Successfully!!");

            }
            //Exit the programm
            if (choice.equals(11)) {
                isRunning = false;
            }

        } while (isRunning);
    }
}
