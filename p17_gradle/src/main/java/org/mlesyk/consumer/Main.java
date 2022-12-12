package org.mlesyk.consumer;

import org.mlesyk.consumer.conf.AppConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfiguration.class);

        RabbitMQConsumer backOffice = context.getBean(RabbitMQConsumer.class);
        backOffice.receiveMail();

        System.in.read();
    }
}
