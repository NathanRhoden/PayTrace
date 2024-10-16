package com.nathanrhoden.paytrace.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferMessageDTO {

    private Long ordBank;
    private Long beneBank;

    private String headerBlock;
    private String applicationHeader;
    private String userBlockHeader;
    private String uniqueTransactionRef;
    private String operationCode;
    private Date valueDate;
    private String currency;
    private String ordBIC;
    private Long interbankSettledAmount;
    private Long instructedAmount;
    private String orderingCustomerName;
    private String orderingCustomerAccountNumber;
    private String orderingCustomerAddress;
    private String beneBIC;
    private String beneficiaryCustomerAccountNumber;
    private String remittanceInformation;


}
