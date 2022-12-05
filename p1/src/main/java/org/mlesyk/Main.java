package org.mlesyk;

import org.mlesyk.beans.Test1;
import org.mlesyk.beans.Test2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        Test1 test1 = context.getBean(org.mlesyk.beans.Test1.class);
        Test2 test2 = context.getBean(org.mlesyk.beans.Test2.class);
        Test1 test11 = (Test1)context.getBean("test1");
        Test2 test22 = (Test2)context.getBean("test2");
        System.out.println("singleton test1 == test11 " + (test1 == test11));
        System.out.println("prototype test2 == test22 " + (test2 == test22));
    }
}
