package com.nathanrhoden.paytrace.services;

import com.nathanrhoden.paytrace.dto.TransferMessageDTO;
import com.nathanrhoden.paytrace.entity.TransferMessage;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;

class TransferMessageServiceTest {

    private ModelMapper modelMapper = new ModelMapper();

    @Test
    void whenConvertToDto_correct(){
        TransferMessage transferMessage = new TransferMessage();
        transferMessage.setCurrency("GBP");
        transferMessage.setBeneBIC("TESTBICXXX");
        transferMessage.setInstructedAmount(2500L);

        TransferMessageDTO transferMessageDTO = modelMapper.map(transferMessage , TransferMessageDTO.class);

        assertEquals(transferMessage.getCurrency() ,transferMessageDTO.getCurrency());
        assertEquals(transferMessage.getBeneBIC() , transferMessageDTO.getBeneBIC());
        assertEquals(transferMessage.getInstructedAmount() , transferMessageDTO.getInstructedAmount());

    }

}