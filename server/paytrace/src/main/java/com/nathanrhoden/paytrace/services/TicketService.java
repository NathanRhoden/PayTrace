package com.nathanrhoden.paytrace.services;

import com.nathanrhoden.paytrace.entity.Ticket;
import com.nathanrhoden.paytrace.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {


    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void saveTicket(Ticket ticket) {

        ticketRepository.save(ticket);

    }
}
