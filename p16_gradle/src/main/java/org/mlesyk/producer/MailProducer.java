package org.mlesyk.producer;

import org.mlesyk.model.Mail;

public interface MailProducer {

    public void sendMail(Mail mail);

}
