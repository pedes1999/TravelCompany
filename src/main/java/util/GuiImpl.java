/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import enums.AirportCode;
import enums.CustomerCategory;
import enums.PaymentMethod;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.Customer;
import model.Itinerary;
import model.Ticket;
import repository.CustomerRepository;
import repository.ItineraryRepository;
import repository.TicketRepository;
import services.MarketService;

/**
 *
 * @author pnbdr
 */
public class GuiImpl {

    private final CustomerRepository customerRepository;
    private final TicketRepository ticketRepository;
    private final ItineraryRepository itineraryRepository;
    private final MarketService marketService;
    boolean isRunning = true; // boolean to control the while condition to terminate Program!

    public GuiImpl(CustomerRepository customerRepository, TicketRepository ticketRepository, ItineraryRepository itineraryRepository, MarketService marketService) {
        this.customerRepository = customerRepository;
        this.ticketRepository = ticketRepository;
        this.itineraryRepository = itineraryRepository;
        this.marketService = marketService;

    }

    public void printGui() {
        do {

            System.out.printf("-------------------------------------------------------\n");
            System.out.println("Please Give a number based on your Preference");
            System.out.printf("-------------------------------------------------------\n");
            System.out.println("CUSTOMER INFORMATION");
            System.out.printf("-------------------------------------------------------\n");
            System.out.println("1 : Check The Customer List");
            System.out.println("2 : Check The Customers who haven't bought any Tickets");
            System.out.println("3 : Check The Customers who have most Tickets sorted by Price");
            System.out.printf("-------------------------------------------------------\n");
            System.out.println("ITINERARY INFORMATION");
            System.out.println("4: Check The Full Itinerary List");
            System.out.println("5 : Check The Itinerary List Based Departure Code");
            System.out.println("6 : Check The Itinerary List Based Destination Code");
            System.out.printf("------------------------------------------------------\n");
            System.out.println("TICKET INFORMATION");
            System.out.println("7 : Check The Ticket List");
            System.out.printf("------------------------------------------------------\n");
            System.out.println("CREATE INSTANCES");
            System.out.println("8 : Create a new Customer");
            System.out.println("9 : Create a new Itinerary");
            System.out.println("10 : Create a new Ticket");
            System.out.println("11 : Exit");
            System.out.printf("-------------------------------------------------------\n");

            //Get Input By User
            Scanner sc = new Scanner(System.in);
            Integer choice = sc.nextInt();

            //Print Customer List
            if (choice.equals(1)) {
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(customerRepository.read()));
            }
//            //Print Customers who havent bought anything
            if (choice.equals(2)) {
                List<Customer> customerNotPurchasedList = marketService.searchIfNotBuy(customerRepository.read(), ticketRepository.read());
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(customerNotPurchasedList));
            }
//            //List of the customers with the most tickets and highest amountPaid
            if (choice.equals(3)) {

                List<Customer> customerWithMostTickets = marketService.customerMostTickets(customerRepository.read(), ticketRepository.read());
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(customerWithMostTickets));
            }

//            //Print Itinerary List
            if (choice.equals(4)) {
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(itineraryRepository.read()));
            }
            //Print itineraryList based on Departure Code
            if (choice.equals(5)) {
                AirportCode airCode = getAirportCode();

                List<Itinerary> departureList = marketService.searchDeparture(airCode);
               System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(departureList));
            }

            if (choice.equals(6)) {
                AirportCode airCode = getAirportCode();
                List<Itinerary> destinationList = marketService.searchDestination(airCode);
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(destinationList ));
            }
            //Print Ticket List (empty at start)
            if (choice.equals(7)) {
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(ticketRepository.read()));
            }
//            //Create a new Customer
            if (choice.equals(8)) {
                Customer newCustomer = createCustomerFromConsole();
                marketService.addCustomer(newCustomer);
                System.out.println("Customer was created Successfully!!");
            }
            //Create a new Itinerary
            if (choice.equals(9)) {
                Itinerary newItinerary = createItineraryFromConsole();
                marketService.addItinerary(newItinerary);
                System.out.println("Itinerary was Created Successfully!!");
            }
            //Create a new Ticket
            if (choice.equals(10)) {
                Ticket newTicket = createTicketFromConsole();
                marketService.addTicket(newTicket);
                System.out.println("Ticket was Created Successfully!!");

            }
            //Exit the programm
            if (choice.equals(11)) {
                isRunning = false;
            }

        } while (isRunning);

    }

    public Customer createCustomerFromConsole() {
        Scanner sc = new Scanner(System.in);

        Customer newCustomer = new Customer();

        //Set Customer's Name 
        System.out.println("Please State Customer's Name : ");
        String name = sc.next();
        newCustomer.setCustomerName(name);

        //Set Customer's Email and check for its validity
        System.out.println("Please state Customer's Email : ");
        String email = sc.next();
        newCustomer.setCustomerEmail(email);
        //!!!!!!!!!!!!!!EXCEPTION FOR EMAIL HERE////////////////////////////

        //Set Customer's Address
        System.out.println("Please state Customer's City : ");
        String address = sc.next();
        newCustomer.setCustomerAddress(address);

        //Set Customer's Nationality
        System.out.println("Please state Customer's nationality : ");
        String nationality = sc.next();
        newCustomer.setCustomerNationality(nationality);

        OUTER:
        while (true) {
            System.out.println("Please state Customer's Category : ");
            System.out.println("The Choices are : ");
            System.out.println("1 : Individual");
            System.out.println("2 : Bussiness");
            Integer choiceCategory = sc.nextInt();
            switch (choiceCategory) {
                case 1:
                    newCustomer.setCustomerCategory(CustomerCategory.INDIVIDUAL);
                    break OUTER;
                case 2:
                    newCustomer.setCustomerCategory(CustomerCategory.BUSINESS);
                    break OUTER;
                default:
                    System.out.println("That is not Valid. Please try again!!!!");
                    break;
            }
        }

        return newCustomer;
    }

    //Create itineraryFromConsole
    public Itinerary createItineraryFromConsole() {
        Scanner sc = new Scanner(System.in);

        Itinerary newItinerary = new Itinerary();

        //AIrline is always SKylines
        newItinerary.setItineraryAirline("Skyline");

        OUTER:
        while (true) {
            System.out.println("Please State Itinerary's Departure Airport Code : ");
            System.out.println("1 : PAR");
            System.out.println("2 : LON");
            System.out.println("3 : AMS");
            System.out.println("4 : DUB");
            System.out.println("5 : FRA");
            System.out.println("6 : MEX");
            System.out.println("7 : ATH");
            Integer choiceDeparture = sc.nextInt();
            switch (choiceDeparture) {
                case 1:
                    newItinerary.setItineraryDeparture(AirportCode.PAR);
                    break OUTER;
                case 2:
                    newItinerary.setItineraryDeparture(AirportCode.LON);
                    break OUTER;
                case 3:
                    newItinerary.setItineraryDeparture(AirportCode.AMS);
                    break OUTER;
                case 4:
                    newItinerary.setItineraryDeparture(AirportCode.DUB);
                    break OUTER;
                case 5:
                    newItinerary.setItineraryDeparture(AirportCode.FRA);
                    break OUTER;
                case 6:
                    newItinerary.setItineraryDeparture(AirportCode.MEX);
                    break OUTER;
                case 7:
                    newItinerary.setItineraryDeparture(AirportCode.ATH);
                    break OUTER;
                default:
                    System.out.println("Please enter a valid Departure Airport Code");
                    break;
            }
        }
        OUTER_1:
        while (true) {
            System.out.println("Please State Itinerary's Destination Airport Code : ");
            System.out.println("1 : PAR");
            System.out.println("2 : LON");
            System.out.println("3 : AMS");
            System.out.println("4 : DUB");
            System.out.println("5 : FRA");
            System.out.println("6 : MEX");
            System.out.println("7 : ATH");
            Integer choiceCategory = sc.nextInt();
            switch (choiceCategory) {
                case 1:
                    newItinerary.setItineraryDestination(AirportCode.PAR);
                    break OUTER_1;
                case 2:
                    newItinerary.setItineraryDestination(AirportCode.LON);
                    break OUTER_1;
                case 3:
                    newItinerary.setItineraryDestination(AirportCode.AMS);
                    break OUTER_1;
                case 4:
                    newItinerary.setItineraryDestination(AirportCode.DUB);
                    break OUTER_1;
                case 5:
                    newItinerary.setItineraryDestination(AirportCode.FRA);
                    break OUTER_1;
                case 6:
                    newItinerary.setItineraryDestination(AirportCode.MEX);
                    break OUTER_1;
                case 7:
                    newItinerary.setItineraryDestination(AirportCode.ATH);
                    break OUTER_1;
                default:
                    System.out.println("Please enter a valid Destination Airport Code");
                    break;
            }
        }
        //Set Itinerary's Base Price
        System.out.println("Please state Itinerary's Basic Price : ");
        Double price = sc.nextDouble();
        newItinerary.setBasicPrice(price);

        //Set Itinerary's Date
        System.out.println("Please state Itinerary's Date : YY/MM/DD/HH/MM");
        String date = sc.next();
        String[] dateparts = date.split("/");
        int year = Integer.parseInt(dateparts[0]) - 1900;
        int month = Integer.parseInt(dateparts[1]) - 1;
        int day = Integer.parseInt(dateparts[2]);
        int hour = Integer.parseInt(dateparts[3]);
        int minute = Integer.parseInt(dateparts[4]);

        newItinerary.setItineraryDepartureDate(new Date(year, month, day, hour, minute));

        return newItinerary;
    }

    //CREATE TICKET FROM CONSOLE
    public Ticket createTicketFromConsole() {
        Scanner sc = new Scanner(System.in);
        Ticket newTicket = new Ticket();

        //Set Ticket's CustomerId
        System.out.println("Please select the customer's id you want to buy a ticket for : ");
        for (Customer c : customerRepository.read()) {
            System.out.println(c);
        }
        Integer customerId = sc.nextInt();

        //Select a customer from the list
        Customer selectedCustomer = customerRepository.read(customerId);
        newTicket.setCustomerId(selectedCustomer.getId());
        //!!!!!!!!!!!!!!!!!!!!!!!     EXCEPTION FOR CUSTOMERID HERE !!!!!!!!!!!!!!!!!!!!!

        //Set Ticket's ItineraryId
        System.out.println("Please select the itinerary's id you want to buy a ticket for : ");
        for (Itinerary t : itineraryRepository.read()) {
            System.out.println(t);
        }
        Integer itineraryId = sc.nextInt();

        //Select a customer from the list
        Itinerary selectedItinerary = itineraryRepository.read(itineraryId);
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
        double ticketPrice = marketService.discount(newTicket.getPaymentMethod(), selectedCustomer.getCustomerCategory(), selectedItinerary.getBasicPrice());
        newTicket.setPaymentAmount(ticketPrice);
        //Set Customer's money spent
        double initialCustomerSpent = selectedCustomer.getCustomerSpent();
        selectedCustomer.setCustomerSpent(initialCustomerSpent + ticketPrice);
        //SET TICKETS PURCHASED
        int ticketsPurchased = selectedCustomer.getTicketsPurchased();
        selectedCustomer.setTicketsPurchased(ticketsPurchased + 1);
        return newTicket;

    }

    //GET AIRPORT CODE FROM USER
    public AirportCode getAirportCode() {
        System.out.println("===============================================");
        System.out.println("Please Give a number based on your Preference");
        System.out.println("===============================================");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Please State Itinerary's Airport Code : ");
            System.out.println("1 : PAR");
            System.out.println("2 : LON");
            System.out.println("3 : AMS");
            System.out.println("4 : DUB");
            System.out.println("5 : FRA");
            System.out.println("6 : MEX");
            System.out.println("7 : ATH");
            Integer choiceDeparture = sc.nextInt();
            if (choiceDeparture == 1) {
                return AirportCode.PAR;
            } else if (choiceDeparture == 2) {
                return AirportCode.LON;
            } else if (choiceDeparture == 3) {
                return AirportCode.AMS;
            } else if (choiceDeparture == 4) {
                return AirportCode.DUB;
            } else if (choiceDeparture == 5) {
                return AirportCode.FRA;
            } else if (choiceDeparture == 6) {
                return AirportCode.MEX;
            } else if (choiceDeparture == 7) {
                return AirportCode.ATH;
            } else {
                System.out.println("Please enter a valid Airport Code");
            }
            return null;
        }

    }

}
