package com.nathanrhoden.paytrace.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QueryDTO {

    private TransferMessageDTO transferMessage;
    private List<TicketDTO> ticketList;

}
