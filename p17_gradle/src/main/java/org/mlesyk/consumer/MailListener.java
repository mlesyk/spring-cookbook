package org.mlesyk.consumer;

import org.mlesyk.model.Mail;

public class MailListener {

    public void displayMail(Mail mail) {
        System.out.println("Received: " + mail);
    }
}
