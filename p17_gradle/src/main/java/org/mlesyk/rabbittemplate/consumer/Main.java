package org.mlesyk.rabbittemplate.consumer;

import org.mlesyk.rabbittemplate.consumer.conf.AppConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(AppConfiguration.class);
    }

}
