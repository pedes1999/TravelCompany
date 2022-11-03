
package model;

import enums.AirportCode;

import java.util.Date;

public class Itinerary extends PersistentClass{
    private AirportCode itineraryDeparture;
    private AirportCode itineraryDestination;
    private Date itineraryDepartureDate;
    private String itineraryAirline;
    private double basicPrice;

    public AirportCode getIteneraryDestination() {
        return itineraryDestination;
    }

    public AirportCode getItineraryDeparture() {
        return itineraryDeparture;
    }

    public void setItineraryDeparture(AirportCode itineraryDeparture) {
        this.itineraryDeparture = itineraryDeparture;
    }

    public void setItineraryDestination(AirportCode itineraryDestination) {
        this.itineraryDestination = itineraryDestination;
    }

    public Date getItineraryDepartureDate() {
        return itineraryDepartureDate;
    }

    public void setItineraryDepartureDate(Date itineraryDepartureDate) {
        this.itineraryDepartureDate = itineraryDepartureDate;
    }

    public String getItineraryAirline() {
        return itineraryAirline;
    }

    public void setItineraryAirline(String itineraryAirline) {
        this.itineraryAirline = itineraryAirline;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(double basicPrice) {
        this.basicPrice = basicPrice;
    }

    @Override
    public String toString() {
        return "Id= " + getId() + ",Departure= " + itineraryDeparture + ", Destination=" + itineraryDestination + ", DepartureDate=" + itineraryDepartureDate + ", Airline=" + itineraryAirline + ", BasicPrice=" + basicPrice;
    }
    
    
    
}
