package model;

import enums.PaymentMethod;

public class Ticket extends PersistentClass {

    private Integer customerId;
    private Integer itineraryId;
    private PaymentMethod paymentMethod;
    private Double paymentAmount;

    public Ticket() {

    }

    public Ticket(int id, int customerId,int itineraryId, PaymentMethod paymentMethod, double paymentAmount) {
        setId(id);
        this.customerId = customerId;
        this.itineraryId = itineraryId;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
    }

    public Integer getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(int iteneraryId) {
        this.itineraryId = iteneraryId;
    }

    public Integer getCustomerId() {
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

    public Double getPaymentAmount() {
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
