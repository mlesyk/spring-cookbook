package org.mlesyk.template.consumer;

import org.mlesyk.model.Mail;
import org.springframework.kafka.annotation.KafkaListener;

public class MailListener {

    @KafkaListener(topics = "mails")
    public void displayMail(Mail mail) {
        System.out.println("Mail #" + mail.getMailId() + ", country " +mail.getCountry()+" received");
    }
}
