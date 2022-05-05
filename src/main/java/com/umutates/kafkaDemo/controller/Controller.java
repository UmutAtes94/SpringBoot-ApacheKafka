package com.umutates.kafkaDemo.controller;

import com.umutates.kafkaDemo.dto.KafkaMessage;
import com.umutates.kafkaDemo.service.KafkaMessageSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafkaDemo")
public class Controller {

    @Autowired
    private KafkaMessageSenderService kafkaMessageSenderService;

    @PostMapping
    public void sendMessage(@RequestBody KafkaMessage message) {
        kafkaMessageSenderService.send(message);
    }
}
