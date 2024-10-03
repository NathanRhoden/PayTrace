package com.nathanrhoden.paytrace.controllers;

import com.nathanrhoden.paytrace.DTO.TransferMessageDTO;
import com.nathanrhoden.paytrace.entity.TransferMessage;
import com.nathanrhoden.paytrace.helpers.DateTimeUtil;
import com.nathanrhoden.paytrace.services.TransferMessageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/message")
public class TransferMessageController {

    private final TransferMessageService transferMessageService;
    private ModelMapper modelMapper;

    @Autowired
    public TransferMessageController(TransferMessageService transferMessageService, ModelMapper modelMapper) {
        this.transferMessageService = transferMessageService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public List<TransferMessageDTO> getMessages() {
        List<TransferMessage> transferMessages = transferMessageService.getAllTransferMessages();
        return transferMessages.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/save")
    public String saveMessage(@RequestBody TransferMessageDTO transferMessageDTO) {

        var tm = toEntity(transferMessageDTO);
        transferMessageService.saveTransferMessage(tm);

        return "saved";

    }


    private TransferMessageDTO convertToDto(TransferMessage transferMessage) {
        return modelMapper.map(transferMessage, TransferMessageDTO.class);
    }

    private TransferMessage toEntity(TransferMessageDTO transferMessageDTO) {
        TransferMessage transferMessage = modelMapper.map(transferMessageDTO, TransferMessage.class);

        return transferMessage;
    }


}
