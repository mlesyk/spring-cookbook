package org.mlesyk.producer;

import org.mlesyk.model.Mail;
import org.mlesyk.producer.conf.ProducerConfiguration;
import org.mlesyk.receiver.conf.AppConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProducerMain {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ProducerConfiguration.class);

        MailProducer frontDesk = context.getBean(MailProducer.class);
        frontDesk.sendMail(new Mail("1234", "US", 1.5));
    }
}
