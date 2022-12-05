package org.mlesyk;

import org.mlesyk.conf.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Runner runner = applicationContext.getBean(Runner.class);
        runner.publish();
        applicationContext.registerShutdownHook();
    }
}
