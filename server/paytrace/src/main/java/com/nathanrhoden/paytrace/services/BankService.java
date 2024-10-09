package com.nathanrhoden.paytrace.services;

import com.nathanrhoden.paytrace.exceptions.BankAlreadyExistsExpection;
import com.nathanrhoden.paytrace.entity.Bank;
import com.nathanrhoden.paytrace.exceptions.BankNotFoundExpection;
import com.nathanrhoden.paytrace.repository.BankRepository;
import com.nathanrhoden.paytrace.repository.TransferMessageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BankService {

    private final BankRepository bankRepository;
    private final TransferMessageRepo transferMessageRepo;

    public Bank saveBank(Bank bank) {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withMatcher("bic", new ExampleMatcher.GenericPropertyMatcher().ignoreCase());

        Example<Bank> example = Example.of(bank, matcher);

        if (bankRepository.exists(example)) {
            throw new BankAlreadyExistsExpection("BANK ALREADY EXISTS");
        } else {

            return bankRepository.save(bank);
        }


    }

    public List<Bank> retrieveAllBanks() {
        return bankRepository.findAll();
    }

    public Bank findBankByBic(String bankBIC) {

        Bank b = bankRepository.findByBic(bankBIC);

        if (b == null) {
            throw new BankNotFoundExpection("BANK NOT FOUND ", new RuntimeException());
        }
        return b;
    }

}
