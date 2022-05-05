package com.umutates.kafkaDemo.dto;

import java.time.LocalDate;

//KafkaMessage DTO represents messages sent to KAFKA
public class KafkaMessage {

    private String message;
    private LocalDate messageDate = LocalDate.now();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(LocalDate messageDate) {
        this.messageDate = messageDate;
    }

    @Override
    public String toString() {
        return "KafkaMessage{" +
                "message='" + message + '\'' +
                ", messageDate=" + messageDate +
                '}';
    }
}
