package repoImpl;

import model.Itinerary;
import repository.ItineraryRepository;

public class ItineraryRepositoryImpl extends RepositoryImpl<Itinerary> implements ItineraryRepository {

    //Update itinerary's price
    @Override
    public void update(int itineraryId, double price) {
        Itinerary itinerary = read(itineraryId);
        if (itinerary != null) {
            itinerary.setBasicPrice(price);
        }
    }

}
