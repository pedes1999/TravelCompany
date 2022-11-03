/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.Customer;

/**
 *
 * @author pnbdr
 */
public interface CustomerRepository {
    //CRUD
    //Create
    int create(Customer customer);
    
    //Read
    Customer[] read();
    
    //Update
    void update(int customerId,String email);
    
    //Delete
    boolean delete(int customerId);
}
