/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import enums.PaymentMethod;
import java.math.BigDecimal;

/**
 *
 * @author pnbdr
 */
public class OrderedTickets extends PersistentClass{
    private int iteneraryId;
    private int customerId;
    private PaymentMethod paymentMethod;
    private BigDecimal paymentAmount;

    public int getIteneraryId() {
        return iteneraryId;
    }

    public void setIteneraryId(int iteneraryId) {
        this.iteneraryId = iteneraryId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public String toString() {
        return "Id= "+ getId() + ", iteneraryId=" + iteneraryId + ", customerId=" + customerId + ", paymentMethod=" + paymentMethod + ", paymentAmount=" + paymentAmount + '}';
    }
    
    
}
