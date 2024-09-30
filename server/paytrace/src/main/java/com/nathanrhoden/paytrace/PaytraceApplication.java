package com.nathanrhoden.paytrace;

import com.nathanrhoden.paytrace.repository.TransferMessageRepo;
import com.nathanrhoden.paytrace.services.TransferMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaytraceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaytraceApplication.class, args);
    }

    @Autowired
    TransferMessageService transferMessageService;


    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            var tm = transferMessageService.generateTransferMessage("MIDLGB22XXX");
            System.out.println(tm.toString());

        };
    }

}
