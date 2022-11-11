package services;

import exceptions.MarketException;
import exceptions.MarketExceptionCodes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import model.Customer;
import model.Itinerary;
import model.Ticket;
import repository.CustomerRepository;
import repository.ItineraryRepository;
import repository.TicketRepository;

public class IoServicesImpl implements IoServices {

    private final CustomerRepository customerRepository;
    private final TicketRepository ticketRepository;
    private final ItineraryRepository itineraryRepository;

    public IoServicesImpl(CustomerRepository customerRepository, TicketRepository ticketRepository, ItineraryRepository itineraryRepository) {
        this.customerRepository = customerRepository;
        this.ticketRepository = ticketRepository;
        this.itineraryRepository = itineraryRepository;
    }

    /**
     *
     * @param filename Saves customers to CSV
     * @throws MarketException
     */
    @Override
    public void saveCustomerToCsv(String filename) throws MarketException {
        File file = new File(filename);
        List<Customer> customerList = customerRepository.read();
        try ( PrintWriter pw = new PrintWriter(file)) {
            pw.println("Id,Name,Email,Address,Nationality,Category");
            for (Customer c : customerList) {
                pw.println(c.getId()
                        + "," + c.getCustomerName()
                        + "," + c.getCustomerEmail()
                        + "," + c.getCustomerAddress()
                        + "," + c.getCustomerNationality()
                        + "," + c.getCustomerCategory()
                );
            }
        } catch (FileNotFoundException e) {
            throw new MarketException(MarketExceptionCodes.CUSTOMER_NOT_FOUND);
        }
    }

    /**
     * saves itineraries to CSV
     *
     * @param filename
     * @throws MarketException
     */
    @Override
    public void saveItineraryToCsv(String filename) throws MarketException {
        File file = new File(filename);
        List<Itinerary> itineraryList = itineraryRepository.read();
        try ( PrintWriter pw = new PrintWriter(file)) {
            pw.println("Id,DepartureAirport Code,Destination AirportCode,Departure date,Airline,Basic price");
            for (Itinerary i : itineraryList) {
                pw.println(i.getId()
                        + "," + i.getItineraryDeparture()
                        + "," + i.getItineraryDestination()
                        + "," + i.getItineraryDepartureDate()
                        + "," + i.getItineraryAirline()
                        + "," + i.getBasicPrice()
                );
            }
        } catch (FileNotFoundException e) {
            throw new MarketException(MarketExceptionCodes.ITINERARY_NOT_FOUND);
        }
    }

    /**
     * @param filename saves Tickets to CSV
     * @throws MarketException
     */
    @Override
    public void saveTicketToCsv(String filename) throws MarketException {
        File file = new File(filename);
        List<Ticket> ticketList = ticketRepository.read();
        try ( PrintWriter pw = new PrintWriter(file)) {
            pw.println("Id,CustomerId,ItineraryId,PaymentMethod,Payment Amount");
            for (Ticket t : ticketList) {
                pw.println(t.getId()
                        + "," + t.getCustomerId()
                        + "," + t.getItineraryId()
                        + "," + t.getPaymentMethod()
                        + "," + t.getPaymentAmount()
                );
            }
        } catch (FileNotFoundException e) {
            throw new MarketException(MarketExceptionCodes.TICKET_NOT_FOUND);
        }
    }

}
