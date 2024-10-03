package com.nathanrhoden.paytrace.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
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
    private String beneBIC;
    private String beneficiaryCustomerAccountNumber;
    private String interbankSettledAmount;
    private String instructedAmount;
    private String orderingCustomerName;
    private String orderingCustomerAccountNumber;
    private String orderingCustomerAddress;
    private String remittanceInformation;

    @ManyToOne
    @JoinColumn(name = "bank_id" , nullable = false)
    private Bank bank;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
