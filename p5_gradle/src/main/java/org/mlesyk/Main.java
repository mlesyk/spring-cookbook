package org.mlesyk;

import org.mlesyk.beans.Test1;
import org.mlesyk.beans.Test2;
import org.mlesyk.beans.TestParent;
import org.mlesyk.config.AppConfigTest1;
import org.mlesyk.config.AppConfigTest2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfigTest1.class, AppConfigTest2.class);

//        context.getEnvironment().setActiveProfiles("test1");
//        context.scan("org.mlesyk");
//        context.refresh();
//        TestParent test1 = context.getBean(org.mlesyk.beans.TestParent.class);
//        TestParent test11 = context.getBean(org.mlesyk.beans.TestParent.class);
//        System.out.println("singleton test1 == test11 " + (test1 == test11));

        context.getEnvironment().setActiveProfiles("test2");
        context.scan("org.mlesyk"); // IMPORTANT
        context.refresh();
        TestParent test2 = context.getBean(org.mlesyk.beans.TestParent.class);
        TestParent test22 = context.getBean(org.mlesyk.beans.TestParent.class);
        System.out.println("prototype test2 == test22 " + (test2 == test22));

    }
}
