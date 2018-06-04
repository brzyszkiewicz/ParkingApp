package com.pls.me.hire.Touk.Ticket;

import com.pls.me.hire.Touk.Driver.DriverServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    private TicketServiceImplementation ticketService;

    @Autowired
    private DriverServiceImplementation driverService;

    @RequestMapping("/tickets/{ticketId}") //Get ticket details such as price
    public Ticket getTicket(@PathVariable long ticketId){
        return ticketService.getTicketById(ticketId);
    }

    @RequestMapping(method = RequestMethod.POST, value="/tickets/{userId}") // Start new ticket for a specified driver
    public void createTicket(@PathVariable long userId){
        ticketService.addTicket(new Ticket(driverService.getDriverById(userId)));
    }

    @RequestMapping("/{userId}/tickets") // Get all driver's tickets
    public List<Ticket> getTicketsByUserId(@PathVariable long userId){
        return ticketService.getTicketsByDriverId(userId);
    }

    @RequestMapping(method = RequestMethod.PUT, value= "/tickets/{ticketId}") //Update end-time and calculate price
    public void closeTicket(@PathVariable long ticketId){
        ticketService.updateTicket(ticketService.getTicketById(ticketId));

    }
}
