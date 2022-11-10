package com.travelcompany.eshop;

import repoImpl.CustomerRepositoryImpl;
import repoImpl.ItineraryRepositoryImpl;
import repoImpl.TicketRepositoryImpl;
import repository.CustomerRepository;
import repository.ItineraryRepository;
import repository.TicketRepository;
import services.IoServices;
import services.IoServicesImpl;

import services.MarketService;
import services.MarketServiceImpl;
import util.DataImport;
import util.GuiImpl;
import util.Helpers;

public class Eshop {

    public static void main(String[] args) {
        //Initiating Repos and Service
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        ItineraryRepository itineraryRepository = new ItineraryRepositoryImpl();
        TicketRepository ticketRepository = new TicketRepositoryImpl();
        MarketService marketService = new MarketServiceImpl(customerRepository, ticketRepository, itineraryRepository);
        Helpers helpers = new Helpers(customerRepository, ticketRepository, itineraryRepository, marketService);
        IoServices ioService = new IoServicesImpl(customerRepository, ticketRepository, itineraryRepository);
        //Data Import
        DataImport dataImport = new DataImport(customerRepository, ticketRepository, itineraryRepository, marketService, helpers);
        dataImport.insertCustomers();
        dataImport.insertItineraries();
        dataImport.insertTickets(customerRepository.read(), itineraryRepository.read());
        dataImport.setCustomerTicketAndPrice();
        //GUI Start
        GuiImpl gui = new GuiImpl(customerRepository, ticketRepository, itineraryRepository, marketService, ioService);
        gui.printGui();

    }
}
