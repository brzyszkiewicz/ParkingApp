package com.pls.me.hire.Touk.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface TicketRepository  extends JpaRepository<Ticket, Long> {
    public List<Ticket> findByDriverId(long id);
}
