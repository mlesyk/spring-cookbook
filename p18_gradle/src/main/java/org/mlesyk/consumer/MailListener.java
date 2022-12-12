package org.mlesyk.consumer;

import org.springframework.kafka.annotation.KafkaListener;

public class MailListener {

    @KafkaListener(topics = "mails")
    public void displayMail(String mail) {
        System.out.println(" Received: " + mail);
    }
}
