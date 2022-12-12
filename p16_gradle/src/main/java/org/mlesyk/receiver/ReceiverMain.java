package org.mlesyk.receiver;

import org.mlesyk.receiver.conf.AppConfiguration;
import org.mlesyk.model.Mail;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ReceiverMain {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        MailReceiver backOffice = context.getBean(MailReceiver.class);
        Mail mail = backOffice.receiveMail();
        System.out.println("Mail #" + mail.getMailId() + " received");
    }
}
