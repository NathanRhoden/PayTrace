package com.nathanrhoden.paytrace.controllers;

import com.nathanrhoden.paytrace.dto.TransferMessageDTO;
import com.nathanrhoden.paytrace.entity.TransferMessage;
import com.nathanrhoden.paytrace.services.TransferMessageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/message")
public class TransferMessageController {

    private final TransferMessageService transferMessageService;
    private final ModelMapper modelMapper;

    @Autowired
    public TransferMessageController(TransferMessageService transferMessageService, ModelMapper modelMapper) {
        this.transferMessageService = transferMessageService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TransferMessageDTO>> getMessages() {
        List<TransferMessage> transferMessages = transferMessageService.getAllTransferMessages();
        List<TransferMessageDTO> transfers =  transferMessages.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(transfers , HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveMessage(@RequestBody TransferMessageDTO transferMessageDTO) {

        var tm = toEntity(transferMessageDTO);
        transferMessageService.saveTransferMessage(tm, transferMessageDTO.getOrdBank(), transferMessageDTO.getBeneBank());

        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }


    private TransferMessageDTO convertToDto(TransferMessage transferMessage) {
        return modelMapper.map(transferMessage, TransferMessageDTO.class);
    }

    private TransferMessage toEntity(TransferMessageDTO transferMessageDTO) {
        return modelMapper.map(transferMessageDTO, TransferMessage.class);

    }


}
