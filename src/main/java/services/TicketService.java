/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import enums.CustomerCategory;
import enums.PaymentMethod;
import java.math.BigDecimal;

/**
 *
 * @author pnbdr
 */
public interface TicketService {
    double discount(PaymentMethod paymentMethod,CustomerCategory customerCategory ,double initialPrice);
}
