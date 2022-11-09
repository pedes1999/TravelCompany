package repoImpl;

import model.Itinerary;
import repository.ItineraryRepository;

public class ItineraryRepositoryImpl extends RepositoryImpl<Itinerary> implements ItineraryRepository {

    @Override
    public void update(int itineraryId, double price) {
        Itinerary itinerary = read(itineraryId);
        if (itinerary != null) {
            itinerary.setBasicPrice(price);
        }
    }

    @Override
    public double readBasicPrice(int itineraryId) {
        Itinerary itinerary = read(itineraryId);
        return itinerary.getBasicPrice();
    }

}
