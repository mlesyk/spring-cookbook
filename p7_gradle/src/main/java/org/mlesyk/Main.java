package org.mlesyk;

import org.mlesyk.beans.Test1;
import org.mlesyk.beans.Test2;
import org.mlesyk.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static Logger log = LoggerFactory.getLogger("MAIN");


    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Test1 test1 = applicationContext.getBean(Test1.class);

        test1.someVoidMethodExample();
        test1.someIntMethodExample();
        try {
            test1.someExceptionMethodExample();
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        Test2 test2 = applicationContext.getBean(Test2.class);

        test2.someVoidMethodExample();
        test2.someIntMethodExample();
        try {
            test2.someExceptionMethodExample();
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}
