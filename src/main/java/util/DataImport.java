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

public class DataImport {

    private final CustomerRepository customerRepository;
    private final TicketRepository ticketRepository;
    private final ItineraryRepository itineraryRepository;
    private final MarketService marketService;
    private final Helpers helpers;

    public DataImport(CustomerRepository customerRepository, TicketRepository ticketRepository, ItineraryRepository itineraryRepository, MarketService marketService, Helpers helpers) {
        this.customerRepository = customerRepository;
        this.ticketRepository = ticketRepository;
        this.itineraryRepository = itineraryRepository;
        this.marketService = marketService;
        this.helpers = helpers;

    }

    private final static String[] CUSTOMERS = {
        "1,Maria Iordanous,miordanou@mail.com,Athens,Greek,INDIVIDUAL",
        "2,Dimitriou Dimitrios, ddimitriou@mail.com, Athens,Greek,INDIVIDUAL",
        "3,Ioannis Ioannou,iioannou@mail.com,Athens,Greek,BUSINESS",
        "4,Antonio Molinari,amolinari@mail.com,Milan,Italian,INDIVIDUAL",
        "5,Frederico Rossi,frossi@mail.com,Milan,Italian,INDIVIDUAL",
        "6,Mario Conti,mconti@mail.com,Rome,Italian,BUSINESS",
        "7,Nathan Martin,nmartin@mail.com,Lyon,French,BUSINESS",
        "8,Enzo Collin,ecollin@mail.com,Lyon,French,INDIVIDUAL",
        "9,Frederic Michel, fmichel@mail.com,Athens,French,INDIVIDUAL",
        "10,Periklis,p@mail.com,Athens,Greek,BUSINESS",
        "11,Maria,m@mail.com,Athens,Greek,INDIVIDUAL",
        "12,Spyros,s@mail.com,France,Greek,BUSINESS"

    };

    private final static String[] ITINERARIES = {
        "1,AMS,PAR,2022/02/22 13:35,Skylines,300",
        "2,ATH,LON,2022/02/22 13:40,Skylines,420",
        "3,DUB,AMS,2022/02/22 13:45,Skylines,280",
        "4,LON,PAR,2022/02/22 14:20,Skylines,310",
        "5,ATH,DUB,2022/02/22 14:35,Skylines,880",
        "6,MEX,FRA,2022/02/22 14:55,Skylines,380",
        "7,FRA,LON,2022/02/22 15:35,Skylines,350",
        "8,FRA,MEX,2022/02/22 16:00,Skylines,1020",
        "9,ATH,DUB,2022/02/22 16:35,Skylines,770",
        "10,DUB,LON,2022/02/22 17:40,Skylines,1000"
    };
    private final static String[] TICKETS = {
        "1,1,2,CASH",
        "2,2,3,CASH",
        "3,3,3,CREDIT",
        "4,2,4,CREDIT",
        "5,3,4,CASH",
        "6,4,7,CREDIT",
        "7,5,7,CREDIT",
        "8,2,9,CASH",
        "9,1,3,CASH",
        "10,6,8,CREDIT",
        "11,11,10,CREDIT",
        "12,12,10,CASH"

    };

    /**
     *
     * @param customerList
     * @param itineraryList Inserts Initial Tickets to ticketRepo
     */
    public void insertTickets(List<Customer> customerList, List<Itinerary> itineraryList) {
        for (String ticketString : TICKETS) {
            try {
                String words[] = ticketString.split(",");
                Ticket ticket = new Ticket();
                ticket.setId(Integer.parseInt(words[0].trim()));
                ticket.setCustomerId(Integer.parseInt(words[1].trim()));
                ticket.setItineraryId(Integer.parseInt(words[2].trim()));
                ticket.setPaymentMethod(PaymentMethod.valueOf(words[3].trim()));
                ticket.setPaymentAmount(marketService.discount(ticket.getPaymentMethod(), customerRepository.readCustomerCategory(ticket.getCustomerId()), itineraryRepository.readBasicPrice(ticket.getItineraryId())));
                ticketRepository.create(ticket);
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    /**
     * Inserts Initial Customers to customer Repository
     */
    public void insertCustomers() {
        for (String customerString : CUSTOMERS) {
            try {
                String words[] = customerString.split(",");
                Customer customer = new Customer();
                customer.setId(Integer.parseInt(words[0]));
                customer.setCustomerName(words[1].trim());
                customer.setCustomerEmail(words[2].trim());
                customer.setCustomerAddress(words[3].trim());
                customer.setCustomerNationality(words[4].trim());
                customer.setCustomerCategory(CustomerCategory.valueOf(words[5].trim()));

                customerRepository.create(customer);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    /**
     * Inserts Initial itineraries to itinerary Repository
     */
    public void insertItineraries() {
        for (String itineraryString : ITINERARIES) {
            try {
                String words[] = itineraryString.split(",");
                Itinerary itinerary = new Itinerary();
                itinerary.setId(Integer.parseInt(words[0]));
                itinerary.setItineraryDeparture(AirportCode.valueOf(words[1].trim()));
                itinerary.setItineraryDestination(AirportCode.valueOf(words[2].trim()));
                String splitDate[] = words[3].split(" ");
                String datePart[] = splitDate[0].split("/"); //Year,Month,Day
                String timePart[] = splitDate[1].split(":");
                itinerary.setItineraryDepartureDate(new Date(
                        Integer.parseInt(datePart[0]) - 1900,
                        Integer.parseInt(datePart[1]) - 1,
                        Integer.parseInt(datePart[2]),
                        Integer.parseInt(timePart[0]),
                        Integer.parseInt(timePart[1])
                ));
                itinerary.setItineraryAirline(words[4].trim());
                itinerary.setBasicPrice(Double.parseDouble(words[5].trim()));

                itineraryRepository.create(itinerary);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    /**
     * Sets the Tickets Purchased and customerSpent fields of Customer
     */
    public void setCustomerTicketAndPrice() {
        for (Customer customer : customerRepository.read()) {
            customer.setTicketsPurchased(helpers.getInitialTicketsForCustomer(customer.getId(), ticketRepository.read()));
            customer.setCustomerSpent(helpers.getInitialMneySpentForCustomer(customer.getId(), ticketRepository.read()));
        }

    }

}
