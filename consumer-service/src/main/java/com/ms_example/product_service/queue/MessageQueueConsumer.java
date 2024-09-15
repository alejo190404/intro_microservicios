package com.ms_example.product_service.queue;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import com.ms_example.product_service.dto.MyMessageDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class MessageQueueConsumer {

    @Bean
    Consumer<Message<MyMessageDTO>> receiveMessage() {
        return message -> {
            log.info("Received message: {}", message);
            log.info("Payload: {}", message.getPayload());
            // Process the message here
        };
    }
}

