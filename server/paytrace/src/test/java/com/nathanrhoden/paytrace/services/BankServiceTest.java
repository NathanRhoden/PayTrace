package com.nathanrhoden.paytrace.services;

import com.nathanrhoden.paytrace.entity.Bank;
import com.nathanrhoden.paytrace.repository.BankRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class BankServiceTest {

    @Mock
    private BankRepository bankRepository;

    @InjectMocks
    private BankService bankService;


    @Test
    void findBankByBic() {
        //given
        Bank testBank = new Bank(1L, "TESTBICXXX", "TESTBANK", "1 TEST STREET", "TEST TOWN",
                "TEST CITY", "TEST111222", "TEST KINGDOM");

        //when
        given(bankRepository.findByBic("TESTBANKXXX")).willReturn(testBank);

        var returnedBank = bankService.findBankByBic("TESTBANKXXX");

        //Then
        assertThat(returnedBank).isNotNull()
                        .isSameAs(testBank);

    }
}