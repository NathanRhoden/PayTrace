package com.nathanrhoden.paytrace.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {

    private String message;
    private Long sendingBankId;
    private Long receivingBankId;
    private String uniqueTransferReference;
}
