package repository;

import enums.AirportCode;
import java.util.List;
import model.Itinerary;

public interface ItineraryRepository {

    //GETTER FOR ITINERARY LIST
    List<Itinerary> getItineraryList();

    //CREATE A NEW ITINERARY
    int create(Itinerary itinerary);

    //READ BASED ON DEPARTURE
    List<Itinerary> readDeparture(AirportCode airportCode,List<Itinerary> itineraryList);
    
    //READ BASED ON DESTINATION
    List<Itinerary> readDestination(AirportCode airportCode,List<Itinerary> itineraryList);

}
