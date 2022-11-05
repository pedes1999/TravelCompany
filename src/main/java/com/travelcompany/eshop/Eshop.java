package com.travelcompany.eshop;

import enums.AirportCode;
import enums.CustomerCategory;
import enums.PaymentMethod;
import java.util.Date;
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
import services.TicketService;
import services.TicketServiceImpl;

public class Eshop {

    public static void main(String[] args) {

        TicketService ticketService = new TicketServiceImpl();
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        TicketRepository ticketRepository = new TicketRepositoryImpl();
        ItineraryRepository itineraryRepository = new ItineraryRepositoryImpl();
        List<Customer> customerList = customerRepository.read();
        List<Itinerary> itineraryList = itineraryRepository.read();
        List<Ticket> ticketList = ticketRepository.read();

        //POPULATING THE COLLECTIONS
        //TO BE IMPLEMENTED IN A SEPARATE CLASS IN THE REPOSITORY
        //Create  customers through Repo
        customerRepository.create(new Customer(1, "Maria Iordanou", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customerRepository.create(new Customer(2, "Dimitriou Dimitrios", "ddimitriou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customerRepository.create(new Customer(3, "Ioannis Ioannou", "iioannou@mail.com", "Athens", "Greek", CustomerCategory.BUSINESS));
        customerRepository.create(new Customer(4, "Antonio Molinari", "amolinari@mail.com", "Milan", "Italian", CustomerCategory.INDIVIDUAL));
        customerRepository.create(new Customer(5, "Frederico Rossi", "frossi@mail.com", "Milan", "Italian", CustomerCategory.INDIVIDUAL));
        customerRepository.create(new Customer(6, "Mario Conti", "mconti@mail.com", "Rome", "Italian", CustomerCategory.BUSINESS));
        //Create itineraries through Repo
        Date d = new Date();
        int currentDate = d.getDate();
        int currentMonth = d.getMonth();
        int currentYear = d.getYear();
        itineraryRepository.create(new Itinerary(1, AirportCode.ATH, AirportCode.PAR, new Date(currentYear, currentMonth, currentDate, 13, 35), "Skylines", 300));
        itineraryRepository.create(new Itinerary(2, AirportCode.ATH, AirportCode.LON, new Date(currentYear, currentMonth, currentDate, 13, 40), "Skylines", 420));
        itineraryRepository.create(new Itinerary(3, AirportCode.ATH, AirportCode.AMS, new Date(currentYear, currentMonth, currentDate, 13, 45), "Skylines", 280));
        itineraryRepository.create(new Itinerary(4, AirportCode.ATH, AirportCode.PAR, new Date(currentYear, currentMonth, currentDate, 14, 20), "Skylines", 310));
        itineraryRepository.create(new Itinerary(5, AirportCode.ATH, AirportCode.DUB, new Date(currentYear, currentMonth, currentDate, 14, 35), "Skylines", 880));
        itineraryRepository.create(new Itinerary(6, AirportCode.ATH, AirportCode.FRA, new Date(currentYear, currentMonth, currentDate, 14, 55), "Skylines", 380));
        itineraryRepository.create(new Itinerary(7, AirportCode.ATH, AirportCode.FRA, new Date(currentYear, currentMonth, currentDate, 15, 35), "Skylines", 350));
        itineraryRepository.create(new Itinerary(8, AirportCode.ATH, AirportCode.MEX, new Date(currentYear, currentMonth, currentDate, 16, 00), "Skylines", 1020));
        itineraryRepository.create(new Itinerary(9, AirportCode.ATH, AirportCode.DUB, new Date(currentYear, currentMonth, currentDate, 16, 35), "Skylines", 770));

        //Create Tickets through Repo
        ticketRepository.create(new Ticket(1, 1, 2, PaymentMethod.CASH, 500));
        ticketRepository.create(new Ticket(2, 2, 2, PaymentMethod.CASH, 500));
        ticketRepository.create(new Ticket(3, 3, 2, PaymentMethod.CASH, 500));
        ticketRepository.create(new Ticket(4, 2, 2, PaymentMethod.CASH, 500));
        ticketRepository.create(new Ticket(5, 3, 2, PaymentMethod.CASH, 500));
        ticketRepository.create(new Ticket(6, 1, 2, PaymentMethod.CASH, 500));
        ticketRepository.create(new Ticket(7, 1, 2, PaymentMethod.CASH, 500));
        ticketRepository.create(new Ticket(8, 1, 2, PaymentMethod.CASH, 500));
        ticketRepository.create(new Ticket(9, 1, 2, PaymentMethod.CASH, 500));
        
        
       Customer c1 = customerList.get(1);
       Itinerary  i1 = itineraryList.get(1);
        Ticket  t1 = ticketList.get(1);
        
       ticketRepository.create(new Ticket(2, i1.getId(), c1.getId(), PaymentMethod.CASH,ticketService.discount(t1.getPaymentMethod(),c1.getCustomerCategory(),i1.getBasicPrice())));
        for ( Ticket t : ticketList) {
            System.out.println(t);
        }
        
        boolean isRunning = true;
        do {

            System.out.println("===============================================");
            System.out.println("Please Give a number based on your Preference");
            System.out.println("1 : Check The Customer List");
            System.out.println("2 : Check The Itinerary List");
            System.out.println("2 : Create a new Customer");
            System.out.println("8 : Exit");

            System.out.println("===============================================");

            Scanner sc = new Scanner(System.in);
            Integer choice = sc.nextInt();

            //TO BE IMPLEMENTED IN A SEPARATE METHOD
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
                int customerLastId = customerList.size();
                Customer newCustomer = new Customer();
                //Set Customer's Id based on the last incrementing by one.
                newCustomer.setId(customerLastId + 1);

                //Set Customer's Name 
                System.out.println("Please State Customer's Name : ");
                String name = sc.next();
                newCustomer.setCustomerName(name);

                //Set Customer's Email
                System.out.println("Please state Customer's Email : ");
                String email = sc.next();
                newCustomer.setCustomerEmail(email);

                //Set Customer's Address
                System.out.println("Please state Customer's City : ");
                String address = sc.next();
                newCustomer.setCustomerAddress(address);

                //Set Customer's Nationality
                System.out.println("Please state Customer's nationality : ");
                String nationality = sc.next();
                newCustomer.setCustomerNationality(nationality);

                //Set Customer's Category
                while (true) {
                    System.out.println("Please state Customer's Category : ");
                    System.out.println("The Choices are : ");
                    System.out.println("1 : Individual");
                    System.out.println("2 : Bussiness");
                    Integer choiceCategory = sc.nextInt();
                    if (choiceCategory.equals(1)) {
                        newCustomer.setCustomerCategory(CustomerCategory.INDIVIDUAL);
                        break;
                    } else if (choiceCategory.equals(2)) {
                        newCustomer.setCustomerCategory(CustomerCategory.BUSINESS);
                        break;
                    } else {
                        System.out.println("That is not Valid. Please try again!!!!");
                    }

                }

                int checkId = customerRepository.create(newCustomer);
                if (checkId == newCustomer.getId()) {
                    System.out.println("The Customer Was Created Successfuly!");
                } else {
                    System.out.println("There was an error please try again!");
                }

            }
            if (choice.equals(4)) {
                isRunning = false;
            }

        } while (isRunning);
    }
}
