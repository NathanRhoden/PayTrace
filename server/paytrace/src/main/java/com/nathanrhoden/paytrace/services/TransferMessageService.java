package com.nathanrhoden.paytrace.services;

import com.nathanrhoden.paytrace.entity.TransferMessage;
import com.nathanrhoden.paytrace.helpers.DateTimeUtil;
import com.nathanrhoden.paytrace.helpers.NumberGenerator;
import com.nathanrhoden.paytrace.repository.TransferMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferMessageService {


    private TransferMessageRepo transferMessageRepo;


    @Autowired
    public TransferMessageService(TransferMessageRepo transferMessageRepo) {
        this.transferMessageRepo = transferMessageRepo;
    }


    public TransferMessage generateTransferMessage(String BIC){

        String uniqueTransferReference = NumberGenerator.generateNextReference();

        return TransferMessage.builder()
                .headerBlock(String.format("F01%sXXX%s" , "ordBIC" , uniqueTransferReference))
                .applicationHeader(String.format("O103%s%s%s%s97", DateTimeUtil.hourMin() , DateTimeUtil.yearMonthDate(),
                    BIC , uniqueTransferReference
                )).build();
    }





}
