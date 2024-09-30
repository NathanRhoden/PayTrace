package com.nathanrhoden.paytrace.entity;

import com.nathanrhoden.paytrace.helpers.NumberGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
@Entity
@Table(name = "TRANSFER_MESSAGE")
public class TransferMessage {

    private String headerBlock;
    private String applicationHeader;
    private String userBlockHeader;
    private String uniqueTransactionRef;
    private String operationCode ;
    private Date valueDate;
    private String currency;
    private String ordBIC;
    private String interbankSettledAmount;
    private String instructedAmount;
    private String orderingCustomerName;
    private String orderingCustomerAccountNumber;
    private String orderingCustomerAddress;
    private String remittanceInformation;

    @Id
    private Long id;

}
