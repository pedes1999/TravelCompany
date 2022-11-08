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
        "9,Frederic Michel, fmichel@mail.com,Athens,French,INDIVIDUAL"

    };

    private final static String[] ITINERARIES = {
        "1,ATH,PAR,2022/02/22 13:35,Skylines,300",
        "2,ATH,LON,2022/02/22 13:40,Skylines,420",
        "3,ATH,AMS,2022/02/22 13:45,Skylines,280",
        "4,ATH,PAR,2022/02/22 14:20,Skylines,310",
        "5,ATH,DUB,2022/02/22 14:35,Skylines,880",
        "6,ATH,FRA,2022/02/22 14:55,Skylines,380",
        "7,ATH,FRA,2022/02/22 15:35,Skylines,350",
        "8,ATH,MEX,2022/02/22 16:00,Skylines,1020",
        "9,ATH,DUB,2022/02/22 16:35,Skylines,770"
    };

    public void insertTickets(List<Customer> customerList, List<Itinerary> itineraryList) {
        ticketRepository.create(new Ticket(1, itineraryList.get(1).getId(), customerList.get(0).getId(), PaymentMethod.CASH, marketService.discount(PaymentMethod.CASH, customerList.get(0).getCustomerCategory(), itineraryList.get(1).getBasicPrice())));
        ticketRepository.create(new Ticket(2, itineraryList.get(2).getId(), customerList.get(1).getId(), PaymentMethod.CASH, marketService.discount(PaymentMethod.CASH, customerList.get(1).getCustomerCategory(), itineraryList.get(2).getBasicPrice())));
        ticketRepository.create(new Ticket(3, itineraryList.get(2).getId(), customerList.get(2).getId(), PaymentMethod.CREDIT, marketService.discount(PaymentMethod.CREDIT, customerList.get(2).getCustomerCategory(), itineraryList.get(2).getBasicPrice())));
        ticketRepository.create(new Ticket(4, itineraryList.get(3).getId(), customerList.get(1).getId(), PaymentMethod.CREDIT, marketService.discount(PaymentMethod.CREDIT, customerList.get(1).getCustomerCategory(), itineraryList.get(3).getBasicPrice())));
        ticketRepository.create(new Ticket(5, itineraryList.get(3).getId(), customerList.get(2).getId(), PaymentMethod.CASH, marketService.discount(PaymentMethod.CASH, customerList.get(2).getCustomerCategory(), itineraryList.get(3).getBasicPrice())));
        ticketRepository.create(new Ticket(6, itineraryList.get(6).getId(), customerList.get(3).getId(), PaymentMethod.CREDIT, marketService.discount(PaymentMethod.CREDIT, customerList.get(3).getCustomerCategory(), itineraryList.get(6).getBasicPrice())));
        ticketRepository.create(new Ticket(7, itineraryList.get(6).getId(), customerList.get(4).getId(), PaymentMethod.CREDIT, marketService.discount(PaymentMethod.CREDIT, customerList.get(4).getCustomerCategory(), itineraryList.get(6).getBasicPrice())));
        ticketRepository.create(new Ticket(8, itineraryList.get(7).getId(), customerList.get(1).getId(), PaymentMethod.CASH, marketService.discount(PaymentMethod.CASH, customerList.get(1).getCustomerCategory(), itineraryList.get(7).getBasicPrice())));
        ticketRepository.create(new Ticket(9, itineraryList.get(2).getId(), customerList.get(0).getId(), PaymentMethod.CASH, marketService.discount(PaymentMethod.CASH, customerList.get(0).getCustomerCategory(), itineraryList.get(2).getBasicPrice())));
    }

    public void insertCustomers() {
        System.out.println(ticketRepository.read());
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

    public void setCustomerTicketAndPrice() {
        for (Customer customer : customerRepository.read()) {
            customer.setTicketsPurchased(helpers.getInitialTicketsForCustomer(customer.getId(), ticketRepository.read()));
            customer.setCustomerSpent(helpers.getInitialMneySpentForCustomer(customer.getId(),ticketRepository.read()));
        }

    }

}
