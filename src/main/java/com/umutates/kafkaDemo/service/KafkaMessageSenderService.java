package com.umutates.kafkaDemo.service;

import com.umutates.kafkaDemo.dto.KafkaMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageSenderService {

    @Value("${kafkademo.kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    public void send(KafkaMessage kafkaMessage){
        kafkaTemplate.send(topic,kafkaMessage);
    }
}
