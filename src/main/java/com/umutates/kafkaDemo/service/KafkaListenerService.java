package com.umutates.kafkaDemo.service;

import com.umutates.kafkaDemo.dto.KafkaMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerService {

    //@KafkaListener annotation to listen topic
    @KafkaListener(
            topics = "${kafkademo.kafka.topic}",
            groupId = "${kafkademo.kafka.group.id}"
    )
    public void listen(@Payload KafkaMessage message) {
        System.out.println(message.toString());
    }
}
