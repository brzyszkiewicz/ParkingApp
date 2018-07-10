package com.bartek.rzyszkiewicz.ticket;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface TicketRepository  extends JpaRepository<Ticket, Long> {
    public List<Ticket> findByDriverId(long id);
}
