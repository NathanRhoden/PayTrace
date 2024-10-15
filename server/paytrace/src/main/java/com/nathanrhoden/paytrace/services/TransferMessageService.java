package com.nathanrhoden.paytrace.services;

import com.nathanrhoden.paytrace.entity.TransferMessage;
import com.nathanrhoden.paytrace.exceptions.BankNotFoundExpection;
import com.nathanrhoden.paytrace.helpers.DateTimeUtil;
import com.nathanrhoden.paytrace.helpers.NumberGenerator;
import com.nathanrhoden.paytrace.repository.BankRepository;
import com.nathanrhoden.paytrace.repository.TransferMessageRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransferMessageService {


    private final TransferMessageRepo transferMessageRepo;
    private final BankRepository bankRepository;

    @Autowired
    public TransferMessageService(TransferMessageRepo transferMessageRepo, BankRepository bankRepository) {
        this.transferMessageRepo = transferMessageRepo;
        this.bankRepository = bankRepository;
    }

    public List<TransferMessage> getAllTransferMessages() {
        return transferMessageRepo.findAll();
    }

    @Transactional
    public void saveTransferMessage(TransferMessage transferMessage, Long ordBankId, Long beneBankId) {
        List<Long> ids = new ArrayList<>();
        ids.add(ordBankId);
        ids.add(beneBankId);

        if(bankRepository.findAllById(ids).size() == 2){
            transferMessageRepo.save(transferMessage);
        }
        else {
            throw new BankNotFoundExpection("Bank not Found" , new Throwable("No Bank"));
        }
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

    public TransferMessage getTransferMessageById(String id) {
        return transferMessageRepo.findByUniqueTransactionRef(id);
    }
}
