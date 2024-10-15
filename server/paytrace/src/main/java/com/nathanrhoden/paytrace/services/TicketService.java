package com.nathanrhoden.paytrace.services;

import com.nathanrhoden.paytrace.dto.TicketDTO;
import com.nathanrhoden.paytrace.entity.Ticket;
import com.nathanrhoden.paytrace.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TicketService {


    private TicketRepository ticketRepository;
    private TransferMessageService transferMessageService;


    public void saveTicket(Ticket ticket) {

        ticketRepository.save(ticket);

    }

    public List<Ticket> getAllTicketsByTransferMessage(String uniqueReference){

        var transferMessage = transferMessageService.getTransferMessageById(uniqueReference);

        return transferMessage.getTicketList();

    }
}
