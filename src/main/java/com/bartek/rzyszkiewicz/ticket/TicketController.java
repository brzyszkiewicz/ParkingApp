package com.bartek.rzyszkiewicz.ticket;

import com.bartek.rzyszkiewicz.driver.DriverServiceImplementation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TicketController {

    @Autowired
    private TicketServiceImplementation ticketService;

    @Autowired
    private DriverServiceImplementation driverService;

    @RequestMapping(value = "/tickets/{ticketId}", method = RequestMethod.GET)
    @ApiOperation("Returns ticket's details such as price")
    public Ticket getTicket(@ApiParam("ID of the ticket to be obtained") @PathVariable long ticketId) {
        Ticket tmp = null;
        try{
            tmp = ticketService.getTicketById(ticketId);
        }
        catch(TicketNotFoundException e){
            e.printStackTrace();
        }
        return tmp;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/tickets/{userId}")
    @ApiOperation("Creates new ticket with a driver assigned")
    public void createTicket(@ApiParam("ID of the driver that wants to create ticket") @PathVariable long userId) {
        ticketService.addTicket(new Ticket(driverService.getDriverById(userId)));
    }

    @RequestMapping(value = "/driver/{userId}/tickets", method = RequestMethod.GET)
    @ApiOperation("Returns driver's all ticket")
    public List<Ticket> getTicketsByUserId(@ApiParam("ID of the driver whose tickets to be returned") @PathVariable long userId) {
        return ticketService.getTicketsByDriverId(userId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/tickets/{ticketId}")
    @ApiOperation("Closes ticket with given ID")
    public void closeTicket(@ApiParam("ID of the ticket to be closed") @PathVariable long ticketId) {

        try {
            ticketService.updateTicket(ticketId);
        }
        catch (TicketNotFoundException e){
            e.printStackTrace();
        }

    }
}
