/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comparators;

import java.util.Comparator;
import model.Customer;

/**
 *
 * @author pnbdr
 */
public class CustomerTicketComparator implements Comparator<Customer>{
     @Override
     public int compare(Customer c1, Customer c2) {
      return c2.getTicketsPurchased() - c1.getTicketsPurchased();
    }
}
