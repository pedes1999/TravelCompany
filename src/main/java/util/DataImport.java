/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import enums.AirportCode;
import enums.CustomerCategory;
import enums.PaymentMethod;
import java.util.Date;
import java.util.List;
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
public class DataImport {

    private final CustomerRepository customerRepository;
    private final TicketRepository ticketRepository;
    private final ItineraryRepository itineraryRepository;
    private final MarketService marketService;

    public DataImport(CustomerRepository customerRepository, TicketRepository ticketRepository, ItineraryRepository itineraryRepository, MarketService marketService) {
        this.customerRepository = customerRepository;
        this.ticketRepository = ticketRepository;
        this.itineraryRepository = itineraryRepository;
        this.marketService = marketService;

    }

    public void insertItineraries() {
        Date d = new Date();
        int currentDate = d.getDate();
        int currentMonth = d.getMonth();
        int currentYear = d.getYear();
        itineraryRepository.create(new Itinerary(1, AirportCode.PAR, AirportCode.PAR, new Date(currentYear, currentMonth, currentDate, 13, 35), "Skylines", 300));
        itineraryRepository.create(new Itinerary(2, AirportCode.MEX, AirportCode.LON, new Date(currentYear, currentMonth, currentDate, 13, 40), "Skylines", 420));
        itineraryRepository.create(new Itinerary(3, AirportCode.FRA, AirportCode.AMS, new Date(currentYear, currentMonth, currentDate, 13, 45), "Skylines", 280));
        itineraryRepository.create(new Itinerary(4, AirportCode.DUB, AirportCode.PAR, new Date(currentYear, currentMonth, currentDate, 14, 20), "Skylines", 310));
        itineraryRepository.create(new Itinerary(5, AirportCode.MEX, AirportCode.DUB, new Date(currentYear, currentMonth, currentDate, 14, 35), "Skylines", 880));
        itineraryRepository.create(new Itinerary(6, AirportCode.LON, AirportCode.FRA, new Date(currentYear, currentMonth, currentDate, 14, 55), "Skylines", 380));
        itineraryRepository.create(new Itinerary(7, AirportCode.PAR, AirportCode.FRA, new Date(currentYear, currentMonth, currentDate, 15, 35), "Skylines", 350));
        itineraryRepository.create(new Itinerary(8, AirportCode.ATH, AirportCode.MEX, new Date(currentYear, currentMonth, currentDate, 16, 00), "Skylines", 1020));
        itineraryRepository.create(new Itinerary(9, AirportCode.ATH, AirportCode.DUB, new Date(currentYear, currentMonth, currentDate, 16, 35), "Skylines", 770));
    }

    public List<Ticket> insertTickets(List<Customer> customerList, List<Itinerary> itineraryList) {
        ticketRepository.create(new Ticket(1, itineraryList.get(2).getId(), customerList.get(0).getId(), PaymentMethod.CASH, marketService.discount(PaymentMethod.CASH, customerList.get(0).getCustomerCategory(), itineraryList.get(1).getBasicPrice())));
        ticketRepository.create(new Ticket(2, itineraryList.get(3).getId(), customerList.get(1).getId(), PaymentMethod.CASH, marketService.discount(PaymentMethod.CASH, customerList.get(1).getCustomerCategory(), itineraryList.get(2).getBasicPrice())));
        ticketRepository.create(new Ticket(3, itineraryList.get(3).getId(), customerList.get(2).getId(), PaymentMethod.CREDIT, marketService.discount(PaymentMethod.CREDIT, customerList.get(2).getCustomerCategory(), itineraryList.get(2).getBasicPrice())));
        ticketRepository.create(new Ticket(4, itineraryList.get(4).getId(), customerList.get(1).getId(), PaymentMethod.CREDIT, marketService.discount(PaymentMethod.CREDIT, customerList.get(1).getCustomerCategory(), itineraryList.get(3).getBasicPrice())));
        ticketRepository.create(new Ticket(5, itineraryList.get(4).getId(), customerList.get(2).getId(), PaymentMethod.CASH, marketService.discount(PaymentMethod.CASH, customerList.get(2).getCustomerCategory(), itineraryList.get(3).getBasicPrice())));
        ticketRepository.create(new Ticket(6, itineraryList.get(7).getId(), customerList.get(3).getId(), PaymentMethod.CREDIT, marketService.discount(PaymentMethod.CREDIT, customerList.get(3).getCustomerCategory(), itineraryList.get(6).getBasicPrice())));
        ticketRepository.create(new Ticket(7, itineraryList.get(7).getId(), customerList.get(4).getId(), PaymentMethod.CREDIT, marketService.discount(PaymentMethod.CREDIT, customerList.get(4).getCustomerCategory(), itineraryList.get(6).getBasicPrice())));
        ticketRepository.create(new Ticket(8, itineraryList.get(8).getId(), customerList.get(1).getId(), PaymentMethod.CASH, marketService.discount(PaymentMethod.CASH, customerList.get(1).getCustomerCategory(), itineraryList.get(8).getBasicPrice())));
        ticketRepository.create(new Ticket(9, itineraryList.get(3).getId(), customerList.get(0).getId(), PaymentMethod.CASH, marketService.discount(PaymentMethod.CASH, customerList.get(0).getCustomerCategory(), itineraryList.get(2).getBasicPrice())));
        return ticketRepository.read();
    }

    public void insertCustomers() {
        customerRepository.create(new Customer(1, "Maria Iordanous", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL, 2));
        customerRepository.create(new Customer(2, "Dimitriou Dimitrios", "ddimitriou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL, 3));
        customerRepository.create(new Customer(3, "Ioannis Ioannou", "iioannou@mail.com", "Athens", "Greek", CustomerCategory.BUSINESS, 2));
        customerRepository.create(new Customer(4, "Antonio Molinari", "amolinari@mail.com", "Milan", "Italian", CustomerCategory.INDIVIDUAL, 1));
        customerRepository.create(new Customer(5, "Frederico Rossi", "frossi@mail.com", "Milan", "Italian", CustomerCategory.INDIVIDUAL, 1));
        customerRepository.create(new Customer(6, "Mario Conti", "mconti@mail.com", "Rome", "Italian", CustomerCategory.BUSINESS, 0));
        customerRepository.create(new Customer(7, "Nathan Martin", "nmartin@mail.com", "Lyon", "French", CustomerCategory.BUSINESS, 0));
        customerRepository.create(new Customer(8, "Enzo Collin", "ecollin@mail.com", "Lyon", "French", CustomerCategory.INDIVIDUAL, 0));
        customerRepository.create(new Customer(9, "Frederic Michel", "fmichel@mail.com", "Athens", "French", CustomerCategory.INDIVIDUAL, 0));

    }
}
