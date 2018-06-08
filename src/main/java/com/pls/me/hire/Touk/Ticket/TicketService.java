package com.pls.me.hire.Touk.Ticket;

import java.util.List;


public interface TicketService {

    public void addTicket(Ticket ticket);
    public List<Ticket> getTicketsByDriverId(long id);
    public Ticket getTicketById(long id);
    public void updateTicket(long ticketId);

}
