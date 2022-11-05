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

        ItineraryService itineraryService = new ItineraryServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        TicketService ticketService = new TicketServiceImpl();
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        TicketRepository ticketRepository = new TicketRepositoryImpl();
        ItineraryRepository itineraryRepository = new ItineraryRepositoryImpl();

        //Initiating collections from Repos
        List<Customer> customerList = customerRepository.read();
        List<Itinerary> itineraryList = itineraryRepository.read();
        List<Ticket> ticketList = ticketRepository.read();

        //POPULATING THE COLLECTIONS 
        customerList.addAll(customerService.populateCustomers());
        itineraryList.addAll(itineraryService.populateItineraries());
        ticketList.addAll(ticketService.populateTickets());

        boolean isRunning = true;
        do {

            System.out.println("===============================================");
            System.out.println("Please Give a number based on your Preference");
            System.out.println("1 : Check The Customer List");
            System.out.println("2 : Check The Itinerary List");
            System.out.println("3 : Create a new Customer");
            System.out.println("4 : Create a new Itinerary");
            System.out.println("5 : Exit");

            System.out.println("===============================================");

            Scanner sc = new Scanner(System.in);
            Integer choice = sc.nextInt();

            if (choice.equals(1)) {
                for (Customer c : customerList) {
                    System.out.println(c);
                }
            }
            if (choice.equals(2)) {
                for (Itinerary i : itineraryList) {
                    System.out.println(i);
                }
            }

            if (choice.equals(3)) {
                Customer newCustomer = customerService.createCustomerFromConsole();
                customerRepository.create(newCustomer);

                System.out.println("Customer was created Successfully!!");

            }

            if (choice.equals(4)) {
                Itinerary newItinerary = itineraryService.createItineraryFromConsole();
                itineraryRepository.create(newItinerary);
                System.out.println("Itinerary was Created Successfully!!");
            }
            if (choice.equals(5)) {
                isRunning = false;
            }

        } while (isRunning);
    }
}
