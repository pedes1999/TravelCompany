package repository;

import model.Itinerary;

public interface ItineraryRepository extends Repository<Itinerary> {

    /**
     *
     * @param itineraryId
     * @param price
     * updates the price of an itinerary based on its id
     */
    void update(int itineraryId, double price);
    
    /**
     *
     * @param itineraryId
     * @return the price of an itinerary based on its id
     */
    double readBasicPrice(int itineraryId);
}
