/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.OrderedTickets;

/**
 *
 * @author pnbdr
 */
public interface TicketRepository {
    //CRUD
    //Create
    int create(OrderedTickets ticketId);
    //Read Single
    OrderedTickets read( int customerId);
    
    //Read multiple
    OrderedTickets[] read();
    
    //Update email
    void update(int ticketId);
    
   //Delete
    boolean delete(int ticketId);
}
