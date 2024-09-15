package com.ms_example.product_service.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.ms_example.product_service.dto.MyMessageDTO;

@Service
public class MessageQueueService {

    // This attribute will store the queue name,
    // which is obtained from 
    // the property spring.cloud.stream.bindings.sendMessage-out-0.destination
    // from the application.yml file
    @Value("${spring.cloud.stream.bindings.sendMessage-out-0.destination}")
    private String queueName;

    @Autowired
    private StreamBridge streamBridge;


    public boolean sendMessage(MyMessageDTO message) {
        return streamBridge.send(queueName, MessageBuilder.withPayload(message).build());
    }
}
