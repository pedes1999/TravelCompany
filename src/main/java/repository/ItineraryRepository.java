package repository;

import enums.AirportCode;
import java.util.List;
import model.Itinerary;
import model.Ticket;

public interface ItineraryRepository extends Repository<Itinerary> {

  
    void update(int itineraryId,double price);
    List<Itinerary> searchPerDeparture(AirportCode airportCode);
    List<Itinerary> searchPerDestination(AirportCode airportCode);
}
