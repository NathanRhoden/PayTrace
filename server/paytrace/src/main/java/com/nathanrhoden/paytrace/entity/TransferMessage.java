package com.nathanrhoden.paytrace.entity;

import com.nathanrhoden.paytrace.DTO.TransferMessageDTO;
import com.nathanrhoden.paytrace.helpers.NumberGenerator;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

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
    private String interbankSettledAmount;
    private String instructedAmount;
    private String orderingCustomerName;
    private String orderingCustomerAccountNumber;
    private String orderingCustomerAddress;
    private String remittanceInformation;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
