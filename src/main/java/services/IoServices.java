package services;

import exceptions.MarketException;

public interface IoServices {

    /**
     *
     * @param filename Saves customers to CSV
     * @throws CustomerException
     */
    void saveCustomerToCsv(String filename) throws MarketException;

    /**
     * saves itineraries to CSV
     *
     * @param filename
     * @throws MarketException
     */
    void saveItineraryToCsv(String filename) throws MarketException;

    /**
     * @param filename
     * @return saves Tickets to CSV
     * @throws CustomerException
     */
    void saveTicketToCsv(String filename) throws MarketException;
    

}
