package repository;

import java.util.List;
import model.Itinerary;

public interface ItineraryRepository {

    //GETTER FOR ITINERARY LIST
    List<Itinerary> getItineraryList();

    //CREATE A NEW ITINERARY
    int create(Itinerary itinerary);

    //Read
    List<Itinerary> read();

}
