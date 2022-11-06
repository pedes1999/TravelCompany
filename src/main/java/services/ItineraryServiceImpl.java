package services;

import enums.AirportCode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.Itinerary;
import repository.ItineraryRepository;
import repository.ItineraryRepositoryImpl;

public class ItineraryServiceImpl implements ItineraryService {

    ItineraryRepository itineraryRepository = new ItineraryRepositoryImpl();

    @Override
    public Itinerary createItineraryFromConsole(List<Itinerary> itineraryList) {
        Scanner sc = new Scanner(System.in);
        int itineraryLastId = itineraryList.size();
        System.out.println(itineraryLastId);
        Itinerary newItinerary = new Itinerary();
        //Set Itinerary's Id based on the last incrementing by one.
        newItinerary.setId(itineraryLastId + 1);

        //AIrline is always SKylines
        newItinerary.setItineraryAirline("Skyline");

        OUTER:
        while (true) {
            System.out.println("Please State Itinerary's Departure Airport Code : ");
            System.out.println("1 : PAR");
            System.out.println("2 : LON");
            System.out.println("3 : AMS");
            System.out.println("4 : DUB");
            System.out.println("5 : FRA");
            System.out.println("6 : MEX");
            System.out.println("7 : ATH");
            Integer choiceDeparture = sc.nextInt();
            switch (choiceDeparture) {
                case 1:
                    newItinerary.setItineraryDeparture(AirportCode.PAR);
                    break OUTER;
                case 2:
                    newItinerary.setItineraryDeparture(AirportCode.LON);
                    break OUTER;
                case 3:
                    newItinerary.setItineraryDeparture(AirportCode.AMS);
                    break OUTER;
                case 4:
                    newItinerary.setItineraryDeparture(AirportCode.DUB);
                    break OUTER;
                case 5:
                    newItinerary.setItineraryDeparture(AirportCode.FRA);
                    break OUTER;
                case 6:
                    newItinerary.setItineraryDeparture(AirportCode.MEX);
                    break OUTER;
                case 7:
                    newItinerary.setItineraryDeparture(AirportCode.ATH);
                    break OUTER;
                default:
                    System.out.println("Please enter a valid Departure Airport Code");
                    break;
            }
        }
        OUTER_1:
        while (true) {
            System.out.println("Please State Itinerary's Destination Airport Code : ");
            System.out.println("1 : PAR");
            System.out.println("2 : LON");
            System.out.println("3 : AMS");
            System.out.println("4 : DUB");
            System.out.println("5 : FRA");
            System.out.println("6 : MEX");
            System.out.println("7 : ATH");
            Integer choiceCategory = sc.nextInt();
            switch (choiceCategory) {
                case 1:
                    newItinerary.setItineraryDestination(AirportCode.PAR);
                    break OUTER_1;
                case 2:
                    newItinerary.setItineraryDestination(AirportCode.LON);
                    break OUTER_1;
                case 3:
                    newItinerary.setItineraryDestination(AirportCode.AMS);
                    break OUTER_1;
                case 4:
                    newItinerary.setItineraryDestination(AirportCode.DUB);
                    break OUTER_1;
                case 5:
                    newItinerary.setItineraryDestination(AirportCode.FRA);
                    break OUTER_1;
                case 6:
                    newItinerary.setItineraryDestination(AirportCode.MEX);
                    break OUTER_1;
                case 7:
                    newItinerary.setItineraryDestination(AirportCode.ATH);
                    break OUTER_1;
                default:
                    System.out.println("Please enter a valid Destination Airport Code");
                    break;
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

    //SEARCH ITINERARY DEPARTURE/DESTINATION BY AIRPORT CODE
    @Override
    public List<Itinerary> searchPerDepartureOrDestination(List<Itinerary> itineraryList) {
        System.out.println("===============================================");
        System.out.println("Please Give a number based on your Preference");
        System.out.println("===============================================");
        System.out.println("1 : Search for itineraries based on Departure Code");
        System.out.println("2 :  Search for itineraries based on Destination Code");
        System.out.println("===============================================");
        Scanner sc = new Scanner(System.in);
        Integer itineraryChoice = sc.nextInt();
        
        if(itineraryChoice.equals(1)){
            while (true) {
                System.out.println("Please State Itinerary's Departure Airport Code : ");
                System.out.println("1 : PAR");
                System.out.println("2 : LON");
                System.out.println("3 : AMS");
                System.out.println("4 : DUB");
                System.out.println("5 : FRA");
                System.out.println("6 : MEX");
                System.out.println("7 : ATH");
                Integer choiceDeparture = sc.nextInt();
                switch (choiceDeparture) {
                    case 1 -> {
                        return itineraryRepository.readDeparture(AirportCode.PAR,itineraryList);
                    }
                    case 2 -> {
                        return itineraryRepository.readDeparture(AirportCode.LON,itineraryList);
                    }
                    case 3 -> {
                        return itineraryRepository.readDeparture(AirportCode.AMS,itineraryList);
                    }
                    case 4 -> {
                        return itineraryRepository.readDeparture(AirportCode.DUB,itineraryList);
                    }
                    case 5 -> {
                        return itineraryRepository.readDeparture(AirportCode.FRA,itineraryList);
                    }
                    case 6 -> {
                        return itineraryRepository.readDeparture(AirportCode.MEX,itineraryList);
                    }
                    case 7 -> {
                        return itineraryRepository.readDeparture(AirportCode.ATH,itineraryList);
                    }
                    default -> System.out.println("Please enter a valid Departure Airport Code");
                }

            }
        } 
         else if(itineraryChoice.equals(2)){
              while (true) {
                System.out.println("Please State Itinerary's Destination Airport Code : ");
                System.out.println("1 : PAR");
                System.out.println("2 : LON");
                System.out.println("3 : AMS");
                System.out.println("4 : DUB");
                System.out.println("5 : FRA");
                System.out.println("6 : MEX");
                System.out.println("7 : ATH");
                Integer choiceDestination = sc.nextInt();
                  switch (choiceDestination) {
                      case 1 -> {
                          return itineraryRepository.readDestination(AirportCode.PAR,itineraryList);
                      }
                      case 2 -> {
                          return itineraryRepository.readDestination(AirportCode.LON,itineraryList);
                      }
                      case 3 -> {
                          return itineraryRepository.readDestination(AirportCode.AMS,itineraryList);
                      }
                      case 4 -> {
                          return itineraryRepository.readDestination(AirportCode.DUB,itineraryList);
                      }
                      case 5 -> {
                          return itineraryRepository.readDestination(AirportCode.FRA,itineraryList);
                      }
                      case 6 -> {
                          return itineraryRepository.readDestination(AirportCode.MEX,itineraryList);
                      }
                      case 7 -> {
                          return itineraryRepository.readDestination(AirportCode.ATH,itineraryList);
                      }
                      default -> System.out.println("Please enter a valid Destination Airport Code");
                  }

            }
        }
        return null;
}
}
