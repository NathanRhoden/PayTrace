package com.nathanrhoden.paytrace.services;

import com.nathanrhoden.paytrace.entity.TransferMessage;
import com.nathanrhoden.paytrace.helpers.DateTimeUtil;
import com.nathanrhoden.paytrace.helpers.NumberGenerator;
import com.nathanrhoden.paytrace.repository.TransferMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class TransferMessageService {


    private TransferMessageRepo transferMessageRepo;
    private final String opCode = "CRED";
    @Autowired
    public TransferMessageService(TransferMessageRepo transferMessageRepo) {
        this.transferMessageRepo = transferMessageRepo;
    }

    public TransferMessage generateTransferMessage(String ORDBIC,String BENEBIC, String uniqueReference ,String ccy ,
                                                   String instructed , String settled ,String ordCustName, String ordIban ,
                                                   String ordCustAddress , String information
                                                   ) {

        String uniqueTransferReference = NumberGenerator.generateNextReference();

        return TransferMessage.builder()
                .headerBlock(String.format("F01%sXXX%s", "ordBIC", uniqueTransferReference))
                .applicationHeader(String.format("O103%s%s%s%s97", DateTimeUtil.hourMin(), DateTimeUtil.yearMonthDate(),
                        ORDBIC, uniqueTransferReference))
                .userBlockHeader("RANDOM UUID")
                .uniqueTransactionRef(uniqueReference)
                .operationCode(opCode)
                .valueDate(Date.from(Instant.now()))
                .currency(ccy)
                .ordBIC(ORDBIC)
                .instructedAmount(instructed)
                .interbankSettledAmount(settled)
                .orderingCustomerAccountNumber(ordIban)
                .orderingCustomerName(ordCustName)
                .orderingCustomerAddress(ordCustAddress)
                .remittanceInformation(information)
                .build();


    }


}
