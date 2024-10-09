package com.nathanrhoden.paytrace.controllers;

import com.nathanrhoden.paytrace.entity.Bank;
import com.nathanrhoden.paytrace.services.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/bank")
public class BankController {

    private final BankService bankService;

    @PostMapping("/create")
    public ResponseEntity<String> savebank(@RequestBody Bank bank){
        bankService.saveBank(bank);
        return new ResponseEntity<>("saved" , HttpStatus.OK);
    }


    @GetMapping("/bic")
    public ResponseEntity<Bank> findBankByBIC(@RequestParam String bic){
        return new ResponseEntity<>(bankService.findBankByBic(bic) , HttpStatus.OK);
    }

}
