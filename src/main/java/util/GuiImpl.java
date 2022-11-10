package util;

import com.google.gson.GsonBuilder;
import com.travelcompany.eshop.Eshop;
import enums.AirportCode;
import enums.CustomerCategory;
import enums.PaymentMethod;
import exceptions.MarketException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.Itinerary;
import model.Ticket;
import repository.CustomerRepository;
import repository.ItineraryRepository;
import repository.TicketRepository;
import services.IoServices;
import services.MarketService;

public class GuiImpl {

    private final CustomerRepository customerRepository;
    private final TicketRepository ticketRepository;
    private final ItineraryRepository itineraryRepository;
    private final MarketService marketService;
    private final IoServices ioService;
    boolean isRunning = true;

    public GuiImpl(CustomerRepository customerRepository, TicketRepository ticketRepository, ItineraryRepository itineraryRepository, MarketService marketService, IoServices ioService) {
        this.customerRepository = customerRepository;
        this.ticketRepository = ticketRepository;
        this.itineraryRepository = itineraryRepository;
        this.marketService = marketService;
        this.ioService = ioService;
    }

    /**
     * INITIALIZES THE CONSOLE GUI WITH ALL THE OPTIONS
     */
    public void printGui() {
        do {

            System.out.printf("-------------------------------------------------------\n");
            System.out.println("Please Give a number based on your Preference");
            System.out.printf("-------------------------------------------------------\n");
            System.out.println("PROJECT REPORT REQUIREMENTS");
            System.out.printf("-------------------------------------------------------\n");
            System.out.println("1 : List of the total number and list of the cost of tickets for all customers");
            System.out.println("2 : List of the total offered itineraries per departure");
            System.out.println("3: List of the total offered itineraries per destination");
            System.out.println("4: List of the customers with the most tickets ");
            System.out.println("5: List of the customers with the highest amount paid");
            System.out.println("6: List of the customers who have not purchased any ticket");
            System.out.printf("-------------------------------------------------------\n");
            System.out.println("ADDITIONAL FUNCTIONALITY");
            System.out.printf("-------------------------------------------------------\n");
            System.out.println("CUSTOMER INFORMATION");
            System.out.printf("-------------------------------------------------------\n");
            System.out.println("7 : Check The Customer List");
            System.out.println("8 : Save Customers To CSV");
            System.out.printf("-------------------------------------------------------\n");
            System.out.println("ITINERARY INFORMATION");
            System.out.println("9: Check The Full Itinerary List");
            System.out.println("10: Save Itineraries to CSV");
            System.out.printf("------------------------------------------------------\n");
            System.out.println("TICKET INFORMATION");
            System.out.println("11 : Check The Ticket List");
            System.out.println("12 : Save tickets To CSV");
            System.out.printf("------------------------------------------------------\n");
            System.out.println("CREATE INSTANCES");
            System.out.println("13 : Create a new Customer");
            System.out.println("14 : Create a new Itinerary");
            System.out.println("15 : Create a new Ticket");
            System.out.println("16 : Exit");
            System.out.printf("-------------------------------------------------------\n");

            Scanner sc = new Scanner(System.in);
            Integer choice = sc.nextInt();

            if (choice.equals(1)) {
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(marketService.searchCustomerNumAndTotalCost(customerRepository.read(), ticketRepository.read())));
            }
            if (choice.equals(2)) {
                AirportCode airCode = getAirportCode();

                List<Itinerary> departureList = marketService.searchDeparture(airCode);
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(departureList));
            }
            if (choice.equals(3)) {
                AirportCode airCode = getAirportCode();
                List<Itinerary> destinationList = marketService.searchDestination(airCode);
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(destinationList));
            }
            if (choice.equals(4)) {

                List<Customer> customerWithMostTickets = marketService.searchCustomersWithMostTickets(customerRepository.read(), ticketRepository.read());
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(customerWithMostTickets));
            }
            if (choice.equals(5)) {

                List<Customer> customerWithMostTickets = marketService.searchCustomerWithHighestTotalCost(customerRepository.read(), ticketRepository.read());
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(customerWithMostTickets));
            }
            if (choice.equals(6)) {
                List<Customer> customerNotPurchasedList = marketService.SearchCustomersNotPurchased(customerRepository.read(), ticketRepository.read());
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(customerNotPurchasedList));
            }
            if (choice.equals(7)) {
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(customerRepository.read()));
            }
            if (choice.equals(8)) {
                try {
                    ioService.saveCustomerToCsv("data/customers.csv");
                } catch (MarketException e) {
                    Logger.getLogger(Eshop.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (choice.equals(9)) {
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(itineraryRepository.read()));
            }
            if (choice.equals(10)) {
                try {
                    ioService.saveItineraryToCsv("data/itineraries.csv");
                } catch (MarketException e) {
                    Logger.getLogger(Eshop.class.getName()).log(Level.SEVERE, null, e);
                }
            }

            if (choice.equals(11)) {
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(ticketRepository.read()));
            }
            if (choice.equals(12)) {
                try {
                    ioService.saveTicketToCsv("data/tickets.csv");
                } catch (MarketException e) {
                    Logger.getLogger(Eshop.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (choice.equals(13)) {
                Customer newCustomer = createCustomerFromConsole();
                try {
                    marketService.addCustomer(newCustomer);
                    System.out.println("Customer was created Successfully!!");
                } catch (MarketException e) {
                    e.printStackTrace();
                }
            }
            if (choice.equals(14)) {
                Itinerary newItinerary = createItineraryFromConsole();
                try {
                    marketService.addItinerary(newItinerary);
                    System.out.println("Itinerary was Created Successfully!!");
                } catch (MarketException e) {
                    e.printStackTrace();
                }

            }
            if (choice.equals(15)) {
                try {
                    Ticket newTicket = createTicketFromConsole();
                    marketService.addTicket(newTicket);
                    System.out.println("Ticket was Created Successfully!!");
                } catch (MarketException e) {
                    e.printStackTrace();
                }
            }

            if (choice.equals(16)) {
                isRunning = false;
            }
        } while (isRunning);

    }

    /**
     *
     * @return CREATES A NEW CUSTOMER BASED ON THE USER'S INPUT
     */
    public Customer createCustomerFromConsole() {
        Scanner sc = new Scanner(System.in);
        Customer newCustomer = new Customer();

        System.out.println("Please State Customer's Name : ");
        String name = sc.next();
        newCustomer.setCustomerName(name);

        System.out.println("Please state Customer's Email : ");
        String email = sc.next();
        newCustomer.setCustomerEmail(email.trim());

        System.out.println("Please state Customer's City : ");
        String address = sc.next();
        newCustomer.setCustomerAddress(address.trim());

        System.out.println("Please state Customer's nationality : ");
        String nationality = sc.next();
        newCustomer.setCustomerNationality(nationality.trim());

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

    /**
     *
     * @return CREATES A NEW ITINERARY BASED ON THE USER'S INPUT
     */
    public Itinerary createItineraryFromConsole() {
        Scanner sc = new Scanner(System.in);
        Itinerary newItinerary = new Itinerary();

        newItinerary.setItineraryAirline("Skyline");

        while (true) {
            try {
                System.out.println("Please State Itinerary's Departure Airport Code : (CAPITAL LETTERS) ");
                System.out.println("PAR");
                System.out.println("LON");
                System.out.println("AMS");
                System.out.println("DUB");
                System.out.println("FRA");
                System.out.println("MEX");
                System.out.println("ATH");
                String departureChoice = sc.next().toUpperCase();
                newItinerary.setItineraryDeparture(AirportCode.valueOf(departureChoice.trim().toUpperCase()));
                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                System.out.println("Please enter A valid Code");
            }
        }
        while (true) {
            try {
                System.out.println("Please State Itinerary's Destination Airport Code : (CAPITAL LETTERS) ");
                System.out.println("PAR");
                System.out.println("LON");
                System.out.println("AMS");
                System.out.println("DUB");
                System.out.println("FRA");
                System.out.println("MEX");
                System.out.println("ATH");
                String departureChoice = sc.next();
                String departureChoiceUp = departureChoice.toUpperCase();
                newItinerary.setItineraryDestination(AirportCode.valueOf(departureChoiceUp.trim()));
                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                System.out.println("Please enter A valid Code");
            }
        }
        System.out.println("Please state Itinerary's Basic Price : ");
        Double price = sc.nextDouble();
        newItinerary.setBasicPrice(price);

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

    /**
     *
     * @return CREATES A TICKET FROM CONSOLE WITH VALUES GIVEN BY THE USER
     */
    public Ticket createTicketFromConsole() {
        Scanner sc = new Scanner(System.in);
        Ticket newTicket = new Ticket();

        System.out.println("Please select the customer's id you want to buy a ticket for : ");
        for (Customer c : customerRepository.read()) {
            System.out.println(c);
        }
        String customerId = sc.next();
        Customer selectedCustomer = customerRepository.read(Integer.parseInt(customerId));
        try {
            newTicket.setCustomerId(selectedCustomer.getId());
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("There is no customer with that id");
        }

        System.out.println("Please select the itinerary's id you want to buy a ticket for : ");
        for (Itinerary t : itineraryRepository.read()) {
            System.out.println(t);
        }
        String itineraryId = sc.next();
        Itinerary selectedItinerary = itineraryRepository.read(Integer.parseInt(itineraryId));

        try {
            newTicket.setItineraryId(selectedItinerary.getId());;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("There is no customer with that id");
        }

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

        double ticketPrice = marketService.discount(newTicket.getPaymentMethod(), selectedCustomer.getCustomerCategory(), selectedItinerary.getBasicPrice());
        newTicket.setPaymentAmount(ticketPrice);

        double initialCustomerSpent = selectedCustomer.getCustomerSpent();
        selectedCustomer.setCustomerSpent(initialCustomerSpent + ticketPrice);

        int ticketsPurchased = selectedCustomer.getTicketsPurchased();
        selectedCustomer.setTicketsPurchased(ticketsPurchased + 1);

        return newTicket;
    }

    /**
     *
     * @return AIRPORT CODE BASED ON THE USERS INPUT
     */
    public AirportCode getAirportCode() {
        System.out.println("===============================================");
        System.out.println("Please Give a number based on your Preference");
        System.out.println("===============================================");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Please State Itinerary's Airport Code : ");
            System.out.println("PAR");
            System.out.println("LON");
            System.out.println("AMS");
            System.out.println("DUB");
            System.out.println("FRA");
            System.out.println("MEX");
            System.out.println("ATH");
            String choice = sc.next();
            return AirportCode.valueOf(choice.trim().toUpperCase());

        }

    }

}
