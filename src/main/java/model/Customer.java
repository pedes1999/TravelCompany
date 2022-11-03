/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import enums.CustomerCategory;

/**
 *
 * @author pnbdr
 */
public class Customer extends PersistentClass{
    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private String customerNationality;
    private CustomerCategory customerCategory;

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

    @Override
    public String toString() {
        return "Id= " + getId() + ", Name=" + customerName + ", Email=" + customerEmail + ", Address=" + customerAddress + ", Nationality=" + customerNationality + ", Category=" + customerCategory;
    }
    
    
    
}
