package model;

import enums.CustomerCategory;

public class Customer extends PersistentClass implements Comparable<Customer> {

    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private String customerNationality;
    private CustomerCategory customerCategory;

    //TEST
    private double customerSpent;

    public Customer() {

    }

    //OVERLOAD CONSTRUCTORS FOR MONEY SPENT
    public Customer(int id, String customerName, String customerEmail, String customerAddress, String customerNationality, CustomerCategory customerCategory) {
        setId(id);
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerNationality = customerNationality;
        this.customerCategory = customerCategory;
    }

    public Customer(int id, String customerName, String customerEmail, String customerAddress, String customerNationality, CustomerCategory customerCategory, double customerSpent) {
        setId(id);
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerNationality = customerNationality;
        this.customerCategory = customerCategory;
        this.customerSpent = customerSpent;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerNationality() {
        return customerNationality;
    }

    public void setCustomerNationality(String customerNationality) {
        this.customerNationality = customerNationality;
    }

    public CustomerCategory getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory(CustomerCategory customerCategory) {
        this.customerCategory = customerCategory;
    }

    //TEST !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public double getCustomerSpent() {
        return customerSpent;
    }

    public void setCustomerSpent(double customerSpent) {
        this.customerSpent = customerSpent;
    }

    @Override
    public String toString() {
        return "Id= " + getId() + ", Name=" + customerName + ", Email=" + customerEmail + ", Address=" + customerAddress + ", Nationality=" + customerNationality + ", Category=" + customerCategory + ", Money Spent=" + customerSpent;
    }

    @Override
    public int compareTo(Customer o) {
        if (o == null) {
            return 0;
        }
        double result = customerSpent - o.customerSpent;
        if (result < 0) {
            return 1;
        } else if (result > 0) {
            return -1;
        }
        return getId() - o.getId();
    }

}
