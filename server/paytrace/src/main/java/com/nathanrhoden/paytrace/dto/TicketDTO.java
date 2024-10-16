package com.nathanrhoden.paytrace.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {

    private String message;
    private Long sendingBankId;
    private Long receivingBankId;
    private String uniqueTransferReference;
    private LocalDateTime dateTime;

}
