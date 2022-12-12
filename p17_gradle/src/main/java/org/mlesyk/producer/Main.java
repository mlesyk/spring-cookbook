package org.mlesyk.producer;

import org.mlesyk.model.Mail;
import org.mlesyk.producer.conf.AppConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfiguration.class);
        context.registerShutdownHook();

        RabbitMQProducer frontDesk = context.getBean(RabbitMQProducer.class);
        frontDesk.sendMail(new Mail("1234", "US", 1.5));

        System.in.read();
    }
}
