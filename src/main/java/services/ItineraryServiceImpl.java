/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import enums.AirportCode;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.Itinerary;
import repository.ItineraryRepository;
import repository.ItineraryRepositoryImpl;

/**
 *
 * @author pnbdr
 */
public class ItineraryServiceImpl implements ItineraryService {

    ItineraryRepository itineraryRepository = new ItineraryRepositoryImpl();
    List<Itinerary> itineraryList = itineraryRepository.read();

    @Override
    public List<Itinerary> populateItineraries() {
        Date d = new Date();
        int currentDate = d.getDate();
        int currentMonth = d.getMonth();
        int currentYear = d.getYear();
        itineraryRepository.create(new Itinerary(1, AirportCode.ATH, AirportCode.PAR, new Date(currentYear, currentMonth, currentDate, 13, 35), "Skylines", 300));
        itineraryRepository.create(new Itinerary(2, AirportCode.ATH, AirportCode.LON, new Date(currentYear, currentMonth, currentDate, 13, 40), "Skylines", 420));
        itineraryRepository.create(new Itinerary(3, AirportCode.ATH, AirportCode.AMS, new Date(currentYear, currentMonth, currentDate, 13, 45), "Skylines", 280));
        itineraryRepository.create(new Itinerary(4, AirportCode.ATH, AirportCode.PAR, new Date(currentYear, currentMonth, currentDate, 14, 20), "Skylines", 310));
        itineraryRepository.create(new Itinerary(5, AirportCode.ATH, AirportCode.DUB, new Date(currentYear, currentMonth, currentDate, 14, 35), "Skylines", 880));
        itineraryRepository.create(new Itinerary(6, AirportCode.ATH, AirportCode.FRA, new Date(currentYear, currentMonth, currentDate, 14, 55), "Skylines", 380));
        itineraryRepository.create(new Itinerary(7, AirportCode.ATH, AirportCode.FRA, new Date(currentYear, currentMonth, currentDate, 15, 35), "Skylines", 350));
        itineraryRepository.create(new Itinerary(8, AirportCode.ATH, AirportCode.MEX, new Date(currentYear, currentMonth, currentDate, 16, 00), "Skylines", 1020));
        itineraryRepository.create(new Itinerary(9, AirportCode.ATH, AirportCode.DUB, new Date(currentYear, currentMonth, currentDate, 16, 35), "Skylines", 770));
        return itineraryList;
    }

    @Override
    public Itinerary createItineraryFromConsole() {
        Scanner sc = new Scanner(System.in);
        int itineraryLastId = itineraryList.size();
        System.out.println(itineraryLastId);
        Itinerary newItinerary = new Itinerary();
        //Set Itinerary's Id based on the last incrementing by one.
        newItinerary.setId(itineraryLastId + 1);

        //ATH Departure AirportCode
        newItinerary.setItineraryDeparture(AirportCode.ATH);

        //AIrline is always SKylines
        newItinerary.setItineraryAirline("Skyline");
        //Set Destination Code
        while (true) {
            System.out.println("Please State Itinerary's Destination Airport Code : ");
            System.out.println("1 : PAR");
            System.out.println("2 : LON");
            System.out.println("3 : AMS");
            System.out.println("4 : DUB");
            System.out.println("5 : FRA");
            System.out.println("6 : MEX");
            Integer choiceCategory = sc.nextInt();
             if (choiceCategory.equals(1)) {
                newItinerary.setItineraryDestination(AirportCode.PAR);
                break;
            } else if (choiceCategory.equals(2)) {
               newItinerary.setItineraryDestination(AirportCode.LON);
                break;
            } else if (choiceCategory.equals(3)) {
               newItinerary.setItineraryDestination(AirportCode.AMS);
                break;
            } else if (choiceCategory.equals(4)) {
               newItinerary.setItineraryDestination(AirportCode.DUB);
                break;
            } else if (choiceCategory.equals(5)) {
               newItinerary.setItineraryDestination(AirportCode.FRA);
                break;
            } else if (choiceCategory.equals(4)) {
               newItinerary.setItineraryDestination(AirportCode.MEX);
                break;
            } else {
                 System.out.println("Please enter a valid Destination Airport Code");
            }
            
        }
        //Set Itinerary's Base Price
        System.out.println("Please state Itinerary's Basic Price : ");
        Double price = sc.nextDouble();
        newItinerary.setBasicPrice(price);

        //Set Itinerary's Date
        System.out.println("Please state Itinerary's Date : YY/MM/DD/HH/MM");
        String date = sc.next();
        String[] dateparts = date.split("/");
        int year = Integer.parseInt(dateparts[0]) - 1900;
        int month = Integer.parseInt(dateparts[1]) - 1;
        int day = Integer.parseInt(dateparts[2]);
        int hour = Integer.parseInt(dateparts[3]);
        int minute = Integer.parseInt(dateparts[4]);

        newItinerary.setItineraryDepartureDate(new Date(year, month, day, hour, minute));

        return newItinerary;
    }

}
