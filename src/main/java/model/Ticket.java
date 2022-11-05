package model;

import enums.PaymentMethod;

public class Ticket extends PersistentClass {

    private int customerId;
    private int itineraryId;
    private PaymentMethod paymentMethod;
    private double paymentAmount;

    public Ticket() {

    }

    public Ticket(int id, int iteneraryId, int customerId, PaymentMethod paymentMethod, double paymentAmount) {
        setId(id);
        this.customerId = customerId;
        this.itineraryId = itineraryId;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
    }

    public int getIteneraryId() {
        return itineraryId;
    }

    public void setItineraryId(int iteneraryId) {
        this.itineraryId = iteneraryId;
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

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public String toString() {
        return "Id= " + getId() + ", iteneraryId=" + itineraryId + ", customerId=" + customerId + ", paymentMethod=" + paymentMethod + ", paymentAmount=" + paymentAmount + '}';
    }

}
