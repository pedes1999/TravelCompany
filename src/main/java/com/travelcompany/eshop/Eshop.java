package com.travelcompany.eshop;

import repoImpl.CustomerRepositoryImpl;
import repoImpl.ItineraryRepositoryImpl;
import repoImpl.TicketRepositoryImpl;
import repository.CustomerRepository;
import repository.ItineraryRepository;
import repository.TicketRepository;

import services.MarketService;
import services.MarketServiceImpl;
import util.DataImport;
import util.GuiImpl;
import util.Helpers;

public class Eshop {

    public static void main(String[] args) {
        //Initiating Repos and Service
        CustomerRepository customerRepo = new CustomerRepositoryImpl();
        ItineraryRepository itineraryRepo = new ItineraryRepositoryImpl();
        TicketRepository ticketRepo = new TicketRepositoryImpl();
        MarketService marketService = new MarketServiceImpl(customerRepo, ticketRepo, itineraryRepo);
        Helpers helpers = new Helpers(customerRepo, ticketRepo, itineraryRepo, marketService);
        
        //Data Import
        DataImport dataImport = new DataImport(customerRepo, ticketRepo, itineraryRepo, marketService,helpers);
        dataImport.insertCustomers();
        dataImport.insertItineraries();
        dataImport.insertTickets(customerRepo.read(), itineraryRepo.read());
        dataImport.setCustomerTicketAndPrice();
        //GUI Start
        GuiImpl gui = new GuiImpl(customerRepo, ticketRepo, itineraryRepo, marketService);
        
        gui.printGui();

    }
}
