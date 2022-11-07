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


public class Eshop {

    public static void main(String[] args) {
        
          CustomerRepository customerRepo = new CustomerRepositoryImpl();
          ItineraryRepository itineraryRepo = new ItineraryRepositoryImpl();
          TicketRepository ticketRepo= new TicketRepositoryImpl();
          MarketService marketService = new MarketServiceImpl(customerRepo,ticketRepo ,itineraryRepo);
          
          DataImport dataImport = new DataImport(customerRepo,ticketRepo,itineraryRepo,marketService);
          dataImport.insertCustomers();
          dataImport.insertItineraries();
          
          //GUI Start
          GuiImpl gui = new GuiImpl(customerRepo,ticketRepo,itineraryRepo,marketService);
          
          dataImport.insertTickets(customerRepo.read(),itineraryRepo.read());

            gui.printGui();
            
   }
}
