package repoImpl;

import model.Itinerary;
import repository.ItineraryRepository;

public class ItineraryRepositoryImpl extends RepositoryImpl<Itinerary> implements ItineraryRepository {

    /**
     *
     * @param itineraryId
     * @param price updates the price of an itinerary based on its id
     */
    @Override
    public void update(int itineraryId, double price) {
        Itinerary itinerary = read(itineraryId);
        if (itinerary != null) {
            itinerary.setBasicPrice(price);
        }
    }
    
     /**
     *
     * @param itineraryId
     * @return the price of an itinerary based on its id
     */
    @Override
    public double readBasicPrice(int itineraryId) {
        Itinerary itinerary = read(itineraryId);
        return itinerary.getBasicPrice();
    }

}
