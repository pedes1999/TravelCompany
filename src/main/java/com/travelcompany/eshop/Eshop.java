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
        CustomerService customerService = new CustomerServiceImpl();
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        ItineraryService itineraryService = new ItineraryServiceImpl();
        ItineraryRepository itineraryRepository = new ItineraryRepositoryImpl();

        TicketService ticketService = new TicketServiceImpl();
        TicketRepository ticketRepository = new TicketRepositoryImpl();

        //Initiating collections from Repos
        List<Customer> customerList = customerRepository.getFullCustomerList();
        List<Itinerary> itineraryList = itineraryRepository.getFullItineraryList();
        List<Ticket> ticketList = ticketRepository.getFullTicketList();

        boolean isRunning = true;
        do {

            System.out.println("===============================================");
            System.out.println("Please Give a number based on your Preference");
            System.out.println("1 : Check The Customer List");
            System.out.println("2 : Check The Itinerary List");
            System.out.println("3 : Check The Ticket List");
            System.out.println("4 : Create a new Customer");
            System.out.println("5 : Create a new Itinerary");
            System.out.println("6 : Create a new Ticket");
            System.out.println("7 : Exit");

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
                for (Ticket t : ticketList) {
                    System.out.println(t);
                }
            }
            if (choice.equals(4)) {
                Customer newCustomer = customerService.createCustomerFromConsole(customerList);
                customerRepository.create(newCustomer);
                System.out.println("Customer was created Successfully!!");
            }
            if (choice.equals(5)) {
                Itinerary newItinerary = itineraryService.createItineraryFromConsole(itineraryList);
                itineraryRepository.create(newItinerary);
                System.out.println("Itinerary was Created Successfully!!");
            }
            if (choice.equals(6)) {
                Ticket newTicket = ticketService.createTicketFromConsole(customerList, itineraryList, ticketList);
                ticketRepository.create(newTicket);
                System.out.println("Ticket was Created Successfully!!");

            }
            if (choice.equals(7)) {
                isRunning = false;
            }

        } while (isRunning);
    }
}
