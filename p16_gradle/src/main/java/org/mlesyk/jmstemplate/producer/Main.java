package org.mlesyk.jmstemplate.producer;

import org.mlesyk.model.Mail;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.mlesyk.jmstemplate.producer");

        ProducerImpl frontDesk = context.getBean(ProducerImpl.class);
        frontDesk.sendMail(new Mail("1234", "US", 1.5));
    }
}
