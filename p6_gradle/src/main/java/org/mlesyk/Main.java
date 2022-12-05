package org.mlesyk;

import org.mlesyk.beans.*;
import org.mlesyk.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        TestApplicationContextAutowire testApplicationContextAutowire = applicationContext.getBean(TestApplicationContextAutowire.class);
        TestApplicationContextAware testApplicationContextAware = applicationContext.getBean(TestApplicationContextAware.class);

        TestApplicationEventPublisherAutowire testApplicationEventPublisherAutowire = applicationContext.getBean(TestApplicationEventPublisherAutowire.class);
        TestApplicationEventPublisherAware testApplicationEventPublisherAware = applicationContext.getBean(TestApplicationEventPublisherAware.class);

        TestBeanFactoryAutowire testBeanFactoryAutowire = applicationContext.getBean(TestBeanFactoryAutowire.class);
        TestBeanFactoryAware testBeanFactoryAware = applicationContext.getBean(TestBeanFactoryAware.class);

        TestBeanNameAware testBeanNameAware = applicationContext.getBean(TestBeanNameAware.class);

        TestEnvironmentAutowire testEnvironmentAutowire = applicationContext.getBean(TestEnvironmentAutowire.class);
        TestEnvironmentAware testEnvironmentAware = applicationContext.getBean(TestEnvironmentAware.class);

        TestMessageSourceAutowire testMessageSourceAutowire = applicationContext.getBean(TestMessageSourceAutowire.class);
        TestMessageSourceAware testMessageSourceAware = applicationContext.getBean(TestMessageSourceAware.class);

        TestResourceLoaderAutowire testResourceLoaderAutowire = applicationContext.getBean(TestResourceLoaderAutowire.class);
        TestResourceLoaderAware testResourceLoaderAware = applicationContext.getBean(TestResourceLoaderAware.class);

        System.out.println(testApplicationContextAutowire.getApplicationContext().equals(testApplicationContextAware.getApplicationContext()));
        System.out.println(testApplicationEventPublisherAutowire.getApplicationEventPublisher().equals(testApplicationEventPublisherAware.getApplicationEventPublisher()));
        System.out.println(testBeanFactoryAutowire.getBeanFactory().equals(testBeanFactoryAware.getBeanFactory()));
        System.out.println(testEnvironmentAutowire.getEnvironment().equals(testEnvironmentAware.getEnvironment()));
        System.out.println(testMessageSourceAutowire.getMessageSource().equals(testMessageSourceAware.getMessageSource()));
        System.out.println(testResourceLoaderAutowire.getResourceLoader().equals(testResourceLoaderAware.getResourceLoader()));
        System.out.println(testBeanNameAware.getName());
    }
}
