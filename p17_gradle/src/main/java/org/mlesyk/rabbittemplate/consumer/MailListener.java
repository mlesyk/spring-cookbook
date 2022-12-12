package org.mlesyk.rabbittemplate.consumer;

import org.mlesyk.model.Mail;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class MailListener {

    @RabbitListener(queues = "mail.queue")
    public void displayMail(Mail mail) {
        System.out.println("Received: " + mail);
    }
}
