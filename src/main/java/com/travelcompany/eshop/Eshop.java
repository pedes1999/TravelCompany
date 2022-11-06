package com.travelcompany.eshop;

import java.util.Collections;
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

        //Initiating The Collections from repos
        List<Customer> customerList = customerRepository.getCustomerList();
        List<Itinerary> itineraryList = itineraryRepository.getItineraryList();
        
        //IF NEED POPULATED
        //List<Ticket> ticketList = ticketRepository.populateTicketList(customerList, itineraryList);
        
        
        //IF NOT POPULATED
        List<Ticket> ticketList = ticketRepository.getTicketList();
        
        
        // !!!!! GUI IMPLEMENTATION !!!!!!
        
        
        boolean isRunning = true; // boolean to control the while condition to terminate Program!
        do {

            System.out.println("===============================================");
            System.out.println("Please Give a number based on your Preference");
            System.out.println("===============================================");
            System.out.println("1 : Check The Customer List");
            System.out.println("2 : Check The Full Itinerary List");
            System.out.println("3 : Check The Itinerary List Based on Departure/Destination Code");
            System.out.println("4 : Check The Ticket List");
            System.out.println("5 : Create a new Customer");
            System.out.println("6: Create a new Itinerary");
            System.out.println("7 : Create a new Ticket");
            System.out.println("8 : Exit");
            System.out.println("===============================================");
            
            //Get Input By User
            Scanner sc = new Scanner(System.in);
            Integer choice = sc.nextInt();
            
            //Print Customer List
            
            if (choice.equals(1)) {
                Collections.sort(customerList);
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
            
            if (choice.equals(3)) {
                List<Itinerary> departureList = itineraryService.searchPerDepartureOrDestination(itineraryList);
                for (Itinerary i : departureList ) {
                    System.out.println(i);
                }
            }
            //Print Ticket List (empty at start)
            if (choice.equals(4)) {
                for (Ticket t : ticketList) {
                    System.out.println(t);
                }
            }
            //Create a new Customer
            if (choice.equals(5)) {
                Customer newCustomer = customerService.createCustomerFromConsole(customerList);
                customerRepository.create(newCustomer);
                System.out.println("Customer was created Successfully!!");
            }
            //Create a new Itinerary
            if (choice.equals(6)) {
                Itinerary newItinerary = itineraryService.createItineraryFromConsole(itineraryList);
                itineraryRepository.create(newItinerary);
                System.out.println("Itinerary was Created Successfully!!");
            }
            //Create a new Ticket
            if (choice.equals(7)) {
                Ticket newTicket = ticketService.createTicketFromConsole(customerList, itineraryList, ticketList);
                ticketRepository.create(newTicket);
                System.out.println("Ticket was Created Successfully!!");

            }
            //Exit the programm
            if (choice.equals(8)) {
                isRunning = false;
            }

        } while (isRunning);
    }
}
