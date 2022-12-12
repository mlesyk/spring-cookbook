package org.mlesyk.jmstemplate.consumer;

import org.mlesyk.model.Mail;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("org.mlesyk.jmstemplate.consumer");

        ConsumerImpl backOffice = context.getBean(ConsumerImpl.class);
        Mail mail = backOffice.receiveMail();
        System.out.println("Mail #" + mail.getMailId() + " received");

    }
}
