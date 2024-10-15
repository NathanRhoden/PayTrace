package com.nathanrhoden.paytrace.controllers;

import com.nathanrhoden.paytrace.dto.QueryDTO;
import com.nathanrhoden.paytrace.dto.TicketDTO;
import com.nathanrhoden.paytrace.entity.Ticket;
import com.nathanrhoden.paytrace.entity.TransferMessage;
import com.nathanrhoden.paytrace.services.TicketService;
import com.nathanrhoden.paytrace.services.TransferMessageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/ticket")
public class TicketController {

    private final TicketService ticketService;
    private final TransferMessageService transferMessageService;
    private final ModelMapper modelMapper;

    @Autowired
    public TicketController(TicketService ticketService, TransferMessageService transferMessageService, ModelMapper modelMapper) {
        this.ticketService = ticketService;
        this.transferMessageService = transferMessageService;
        this.modelMapper = modelMapper;
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

    @GetMapping()
    public ResponseEntity<QueryDTO> getAllTickets(@RequestParam String uniqueReference) {

        var transferMessage = transferMessageService.getTransferMessageById(uniqueReference);

        var ticketDtoList = ticketService.getAllTicketsByTransferMessage(uniqueReference)
                .stream()
                .map(this::convertToDto).
                toList();

        return new ResponseEntity<>(convertToDto(transferMessage, ticketDtoList), HttpStatus.OK);
    }

    private QueryDTO convertToDto(TransferMessage transferMessage, List<TicketDTO> ticketList) {

        QueryDTO queryDTO = new QueryDTO();

        modelMapper.map(transferMessage, queryDTO);

        queryDTO.setTicketList(ticketList);

        return queryDTO;

    }

    private TicketDTO convertToDto(Ticket ticket) {
        return modelMapper.map(ticket, TicketDTO.class);
    }


}
