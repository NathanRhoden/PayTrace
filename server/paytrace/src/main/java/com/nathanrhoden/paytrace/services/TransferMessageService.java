package com.nathanrhoden.paytrace.services;

import com.nathanrhoden.paytrace.entity.TransferMessage;
import com.nathanrhoden.paytrace.helpers.DateTimeUtil;
import com.nathanrhoden.paytrace.helpers.NumberGenerator;
import com.nathanrhoden.paytrace.repository.TransferMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class TransferMessageService {


    private final TransferMessageRepo transferMessageRepo;

    @Autowired
    public TransferMessageService(TransferMessageRepo transferMessageRepo) {
        this.transferMessageRepo = transferMessageRepo;
    }

    public List<TransferMessage> getAllTransferMessages() {
        return transferMessageRepo.findAll();
    }

    public void saveTransferMessage(TransferMessage transferMessage) {
        transferMessageRepo.save(generateTransferMessage(transferMessage));
    }

    private TransferMessage generateTransferMessage(TransferMessage transferMessage) {

        String uniqueTransferReference = NumberGenerator.generateNextReference();

        return TransferMessage.builder()
                .headerBlock(String.format("F01%sXXX%s", transferMessage.getOrdBIC(), uniqueTransferReference))
                .applicationHeader(String.format("O103%s%s%s%s97", DateTimeUtil.hourMin(), DateTimeUtil.yearMonthDate(),
                        transferMessage.getOrdBIC(), uniqueTransferReference
                ))
                .currency(transferMessage.getCurrency())
                .operationCode("CRED")
                .valueDate(Date.from(Instant.now()))
                .uniqueTransactionRef(transferMessage.getUniqueTransactionRef())
                .userBlockHeader("OPENBANKING")
                .ordBIC(transferMessage.getOrdBIC())
                .interbankSettledAmount(transferMessage.getInterbankSettledAmount())
                .instructedAmount(transferMessage.getInstructedAmount())
                .orderingCustomerAddress(transferMessage.getOrderingCustomerAddress())
                .orderingCustomerAccountNumber(transferMessage.getOrderingCustomerAccountNumber())
                .orderingCustomerName(transferMessage.getOrderingCustomerName())
                .remittanceInformation(transferMessage.getRemittanceInformation())
                .beneBIC(transferMessage.getBeneBIC())
                .beneficiaryCustomerAccountNumber(transferMessage.getBeneficiaryCustomerAccountNumber())
                .build();
    }

}
