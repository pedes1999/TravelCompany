/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.List;
import model.Itinerary;

/**
 *
 * @author pnbdr
 */
public interface ItineraryService {
    List<Itinerary> populateItineraries();
    
    Itinerary createItineraryFromConsole();
}
