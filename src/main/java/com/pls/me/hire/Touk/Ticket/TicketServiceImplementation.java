package com.pls.me.hire.Touk.Ticket;

import com.pls.me.hire.Touk.Driver.DriverType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class TicketServiceImplementation implements TicketService{

    @Autowired
    private TicketRepository ticketRepository;

    public void addTicket(Ticket ticket){

        ticketRepository.save(ticket);
    }

    public List<Ticket> getTicketsByDriverId(long id){

        return ticketRepository.findByDriverId(id);
    }

    public Ticket getTicketById(long id){

        return ticketRepository.getOne(id);
    }

    public void updateTicket(Ticket ticket){

        ticket.setEndTime(System.currentTimeMillis());
        long diff = ticket.getEndTime() - ticket.getStartTime();
        long hours = 0;
        double price = 0;
        if(diff%15000 == 0) hours = diff/15000;
        else if(diff < 14999) hours=0;
        else hours = ((diff/15000) +1);

        if(ticket.getDriver().getType() == DriverType.VIP){
            for (int i = 1; i < hours; i++){
                price = price + (2 * Math.pow(1.2, (i-1)));
            }
        }
        else if(ticket.getDriver().getType() == DriverType.REGULAR){
            for (int i = 0; i < hours; i++){
                if(i == 0) price = 1;
                else price = price + (2 * Math.pow(1.5, (i-1)));

            }
        }
        ticket.setPrice(price);
        ticketRepository.save(ticket);
    }
}
