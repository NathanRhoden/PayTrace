package com.nathanrhoden.paytrace;

import com.nathanrhoden.paytrace.entity.Bank;

import com.nathanrhoden.paytrace.entity.TransferMessage;
import com.nathanrhoden.paytrace.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class PaytraceApplication {

    private BankRepository bankRepository;

    @Autowired
    public PaytraceApplication(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(PaytraceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
          Bank b = new Bank();
          b.setTransferMessageSet(new ArrayList<>());
          bankRepository.save(b);
        };
    }
}
