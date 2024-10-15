package com.nathanrhoden.paytrace.controllers;

import com.nathanrhoden.paytrace.dto.TicketDTO;
import com.nathanrhoden.paytrace.entity.Ticket;
import com.nathanrhoden.paytrace.entity.TransferMessage;
import com.nathanrhoden.paytrace.services.TicketService;
import com.nathanrhoden.paytrace.services.TransferMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/ticket")
public class TicketController {

    private final TicketService ticketService;
    private final TransferMessageService transferMessageService;

    @Autowired
    public TicketController(TicketService ticketService, TransferMessageService transferMessageService) {
        this.ticketService = ticketService;
        this.transferMessageService = transferMessageService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> saveTicket(@RequestBody TicketDTO ticketDto) {

        TransferMessage transferMessage = transferMessageService.
                getTransferMessageById(ticketDto.getUniqueTransferReference());

        Ticket ticket = Ticket.builder()
                .message(ticketDto.getMessage())
                .receivingBankId(ticketDto.getReceivingBankId())
                .sendingBankId(ticketDto.getSendingBankId())
                .uniqueTransferReference(ticketDto.getUniqueTransferReference())
                .transferMessage(transferMessage)
                .build();

        ticketService.saveTicket(ticket);

        return new ResponseEntity<>("TICKET SAVED IN TESTING", HttpStatus.OK);

    }
}
