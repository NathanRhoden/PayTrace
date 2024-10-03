package com.nathanrhoden.paytrace.services;

import com.nathanrhoden.paytrace.entity.Bank;
import com.nathanrhoden.paytrace.repository.BankRepository;
import com.nathanrhoden.paytrace.repository.TransferMessageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BankService {

    private final BankRepository bankRepository;
    private final TransferMessageRepo transferMessageRepo;

    public Bank saveBank(Bank bank){
        return bankRepository.save(bank);
    }

    public List<Bank> retrieveAllBanks(){
        return bankRepository.findAll();
    }

    public Bank findBankByBic(String bankBIC){
        Bank b = bankRepository.findByBic(bankBIC);

        if(b == null){
            throw new RuntimeException("BANK NOT FOUND");
        }
        return b;
    }

}
