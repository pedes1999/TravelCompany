package repository;

import enums.AirportCode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Itinerary;

public class ItineraryRepositoryImpl implements ItineraryRepository {

    private List<Itinerary> itineraryList = new ArrayList<>();

   
    //INITIAL POPULATION!!!

    public ItineraryRepositoryImpl() {
        Date d = new Date();
        int currentDate = d.getDate();
        int currentMonth = d.getMonth();
        int currentYear = d.getYear();
        itineraryList.add(new Itinerary(1, AirportCode.ATH, AirportCode.PAR, new Date(currentYear, currentMonth, currentDate, 13, 35), "Skylines", 300));
        itineraryList.add(new Itinerary(2, AirportCode.ATH, AirportCode.LON, new Date(currentYear, currentMonth, currentDate, 13, 40), "Skylines", 420));
        itineraryList.add(new Itinerary(3, AirportCode.ATH, AirportCode.AMS, new Date(currentYear, currentMonth, currentDate, 13, 45), "Skylines", 280));
        itineraryList.add(new Itinerary(4, AirportCode.ATH, AirportCode.PAR, new Date(currentYear, currentMonth, currentDate, 14, 20), "Skylines", 310));
        itineraryList.add(new Itinerary(5, AirportCode.ATH, AirportCode.DUB, new Date(currentYear, currentMonth, currentDate, 14, 35), "Skylines", 880));
        itineraryList.add(new Itinerary(6, AirportCode.ATH, AirportCode.FRA, new Date(currentYear, currentMonth, currentDate, 14, 55), "Skylines", 380));
        itineraryList.add(new Itinerary(7, AirportCode.ATH, AirportCode.FRA, new Date(currentYear, currentMonth, currentDate, 15, 35), "Skylines", 350));
        itineraryList.add(new Itinerary(8, AirportCode.ATH, AirportCode.MEX, new Date(currentYear, currentMonth, currentDate, 16, 00), "Skylines", 1020));
        itineraryList.add(new Itinerary(9, AirportCode.ATH, AirportCode.DUB, new Date(currentYear, currentMonth, currentDate, 16, 35), "Skylines", 770));
    }
    
     //GETTER FOR ITINERARY LIST
    @Override
    public List<Itinerary> getItineraryList() {
        return itineraryList;
    }

    //CREATE A NEW ITINERARY
    @Override
    public int create(Itinerary itinerary) {
        itineraryList.add(itinerary);
        return itinerary.getId();
    }

    //READ
    @Override
    public List<Itinerary> read() {
        return itineraryList;
    }

}
