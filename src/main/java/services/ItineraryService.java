package services;

import java.util.List;
import model.Itinerary;

public interface ItineraryService {

    Itinerary createItineraryFromConsole(List<Itinerary> itineraryList);
    
    
    List<Itinerary> searchPerDepartureOrDestination(List<Itinerary> itineraryList);
}
