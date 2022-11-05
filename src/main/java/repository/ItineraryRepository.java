/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.Itinerary;

/**
 *
 * @author pnbdr
 */
public interface ItineraryRepository {
     //CRUD
    //Create
    int create(Itinerary itinerary);
    
    //Read
    List<Itinerary> read();
    
    //Update
    void update(int itineraryId);
    
    //Delete
    boolean delete(int itineraryId);
}
