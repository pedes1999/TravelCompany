package repository;

import model.Itinerary;

public interface ItineraryRepository extends Repository<Itinerary> {

    void update(int itineraryId, double price);

}
