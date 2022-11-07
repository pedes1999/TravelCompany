package repoImpl;

import enums.AirportCode;
import java.util.ArrayList;
import java.util.List;
import model.Itinerary;
import model.Ticket;
import repository.ItineraryRepository;

public class ItineraryRepositoryImpl extends RepositoryImpl<Itinerary> implements ItineraryRepository {


    //Update itinerary's price
    @Override
    public void update(int itineraryId, double price) {
        Itinerary itinerary = read(itineraryId);
        if(itinerary != null) {
            itinerary.setBasicPrice(price);
        }
    }

    
    //Search Itinerary per Departure Airport Code
    @Override
    public List<Itinerary> searchPerDeparture(AirportCode airportCode) {
       List<Itinerary> departureList = new ArrayList<>();
        for (Itinerary itinerary : read()) {
            if (itinerary.getItineraryDeparture().equals(airportCode)) {
                departureList.add(itinerary);
            }
        }
        return departureList;
    }
    
     @Override
    public List<Itinerary> searchPerDestination(AirportCode airportCode) {
       List<Itinerary> destinationList = new ArrayList<>();
        for (Itinerary itinerary : read()) {
            if (itinerary.getIteneraryDestination().equals(airportCode)) {
                destinationList.add(itinerary);
            }
        }
        return destinationList;
    }

}
