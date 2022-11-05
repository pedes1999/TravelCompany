/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import model.Itinerary;

/**
 *
 * @author pnbdr
 */
public class ItineraryRepositoryImpl implements ItineraryRepository {
    List<Itinerary> itineraryList = new ArrayList<>();
    @Override
    public int create(Itinerary itinerary) {
       itineraryList.add(itinerary);
       return itinerary.getId();
    }

    @Override
    public List<Itinerary> read() {
        return itineraryList;
    }

    @Override
    public void update(int itineraryId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int itineraryId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
