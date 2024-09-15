package com.ms_example.product_service.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms_example.product_service.dto.MyMessageDTO;
import com.ms_example.product_service.queue.MessageQueueService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/producer")
public class ProductServiceController {

    @Autowired
    private MessageQueueService messageQueueService;

    @PostMapping("/send-simple-message")
    public ResponseEntity<String> sendSimpleMessage(@RequestBody String message) {
        messageQueueService.sendMessage(new MyMessageDTO(LocalDateTime.now(), message));
        log.info("Message sent: {}", message);
        return ResponseEntity.ok().body(String.format("Message sent: %s", message));
    }

}
