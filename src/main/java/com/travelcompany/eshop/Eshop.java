package com.travelcompany.eshop;

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
        //Initiating Customer Services and Repos
        CustomerService customerService = new CustomerServiceImpl();
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        //Initiating Itinerary Services and Repos
        ItineraryService itineraryService = new ItineraryServiceImpl();
        ItineraryRepository itineraryRepository = new ItineraryRepositoryImpl();

        //Initiating Ticket Services and Repos
        TicketService ticketService = new TicketServiceImpl();
        TicketRepository ticketRepository = new TicketRepositoryImpl();

        //Initiating 
        List<Customer> customerList = customerRepository.getFullCustomerList();
        List<Itinerary> itineraryList = itineraryRepository.getFullItineraryList();
        List<Ticket> ticketList = ticketRepository.getFullTicketList();

        //Initial Population Of the ticketList
        ticketList = ticketService.populateTicketData(customerList, itineraryList, ticketList);

        // !!!!! GUI IMPLEMENTATION !!!!!!
        boolean isRunning = true; // boolean to control the while condition to terminate Program!
        do {

            System.out.println("===============================================");
            System.out.println("Please Give a number based on your Preference");
            System.out.println("===============================================");
            System.out.println("1 : Check The Customer List");
            System.out.println("2 : Check The Itinerary List");
            System.out.println("3 : Check The Ticket List");
            System.out.println("4 : Create a new Customer");
            System.out.println("5 : Create a new Itinerary");
            System.out.println("6 : Create a new Ticket");
            System.out.println("7 : Exit");
            System.out.println("===============================================");

            //Get Input By User
            Scanner sc = new Scanner(System.in);
            Integer choice = sc.nextInt();

            //Print Customer List
            if (choice.equals(1)) {
                for (Customer c : customerList) {
                    System.out.println(c);
                }

            }

            //Print Itinerary List
            if (choice.equals(2)) {
                for (Itinerary i : itineraryList) {
                    System.out.println(i);
                }
            }
            //Print Ticket List (empty at start)
            if (choice.equals(3)) {
                for (Ticket t : ticketList) {
                    System.out.println(t);
                }
            }
            //Create a new Customer
            if (choice.equals(4)) {
                Customer newCustomer = customerService.createCustomerFromConsole(customerList);
                customerRepository.create(newCustomer);
                System.out.println("Customer was created Successfully!!");
            }
            //Create a new Itinerary
            if (choice.equals(5)) {
                Itinerary newItinerary = itineraryService.createItineraryFromConsole(itineraryList);
                itineraryRepository.create(newItinerary);
                System.out.println("Itinerary was Created Successfully!!");
            }
            //Create a new Ticket
            if (choice.equals(6)) {
                Ticket newTicket = ticketService.createTicketFromConsole(customerList, itineraryList, ticketList);
                ticketRepository.create(newTicket);
                System.out.println("Ticket was Created Successfully!!");

            }
            //Exit the programm
            if (choice.equals(7)) {
                isRunning = false;
            }

        } while (isRunning);
    }
}
