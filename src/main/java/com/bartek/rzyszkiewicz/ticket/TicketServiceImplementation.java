package com.bartek.rzyszkiewicz.ticket;

import com.bartek.rzyszkiewicz.driver.DriverType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.*;

@Service
public class TicketServiceImplementation implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public void addTicket(Ticket ticket) {

        ticketRepository.save(ticket);
    }

    public List<Ticket> getTicketsByDriverId(long id) {

        return ticketRepository.findByDriverId(id);
    }

    public Ticket getTicketById(long id) throws TicketNotFoundException{
        if(!ticketRepository.existsById(id)) throw new TicketNotFoundException("Ticket with given Id doesn't exist");
        else return ticketRepository.getOne(id);

    }

    public void updateTicket(long ticketId) throws TicketNotFoundException{

        if(!ticketRepository.existsById(ticketId)){
            throw new TicketNotFoundException("Ticket with given Id doesn't exist");
        }
        Ticket ticket = ticketRepository.getOne(ticketId);
        ticket.setEndTime(ZonedDateTime.now());
        ticket.setPrice(calculatePrice(ticket));
        ticketRepository.save(ticket);
    }

    double calculatePrice(Ticket ticket) {
        double price = 0;
        Duration diff = Duration.between(ticket.getStartTime(), ticket.getEndTime());
        long minutes = diff.toMinutes();
        long hours;
        if (minutes % 60 == 0) {
            hours = minutes / 60;
        } else if (minutes < 60) {
            hours = 0;
        } else {
            hours = ((minutes / 60) + 1);
        }

        if (ticket.getDriver().getType() == DriverType.VIP) {
            for (int i = 1; i < hours; i++) {
                price = price + (2 * Math.pow(1.2, (i - 1)));
            }
        } else if (ticket.getDriver().getType() == DriverType.REGULAR) {
            price = 1;
            for (int i = 1; i < hours; i++) {
                price = price + (2 * Math.pow(1.5, (i - 1)));

            }

        }
        return price;
    }
}
