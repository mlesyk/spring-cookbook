package org.mlesyk.rabbittemplate.producer;

import org.mlesyk.model.Mail;
import org.mlesyk.rabbittemplate.producer.conf.AppConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfiguration.class);

        ProducerImpl producer = context.getBean(ProducerImpl.class);
        producer.sendMail(new Mail("1234", "US", 1.5));

        System.in.read();

        context.close();
    }
}
