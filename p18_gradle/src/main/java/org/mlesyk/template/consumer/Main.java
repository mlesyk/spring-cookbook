package org.mlesyk.template.consumer;

import org.mlesyk.template.consumer.conf.AppConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(AppConfiguration.class);
    }

}
