package repository;

import java.util.List;
import model.Itinerary;

public interface ItineraryRepository {
    //CRUD
    //Create

    int create(Itinerary itinerary);

    //Read
    List<Itinerary> read();
    
    List<Itinerary> getFullItineraryList();
    //Update
    void update(int itineraryId);

    //Delete
    boolean delete(int itineraryId);
}
