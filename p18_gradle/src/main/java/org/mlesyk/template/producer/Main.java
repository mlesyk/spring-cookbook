package org.mlesyk.template.producer;

import org.mlesyk.model.Mail;
import org.mlesyk.template.producer.conf.AppConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {


    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfiguration.class);
        context.registerShutdownHook();

        ProducerImpl frontDesk = context.getBean(ProducerImpl.class);
        frontDesk.sendMail(new Mail("1234", "US", 1.5));

        System.in.read();

    }

}
