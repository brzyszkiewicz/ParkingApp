package com.pls.me.hire.Touk.Ticket;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Ticket")
public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException(String string){
        super(string);
    }
}
