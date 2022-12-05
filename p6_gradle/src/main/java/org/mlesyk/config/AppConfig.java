package org.mlesyk.config;

import org.mlesyk.beans.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.mlesyk")
public class AppConfig {

    @Bean
    public TestApplicationContextAware testApplicationContextAware() {
        return new TestApplicationContextAware();
    }

    @Bean
    public TestBeanNameAware testBeanNameAware() {
        return new TestBeanNameAware();
    }

    @Bean
    public TestApplicationEventPublisherAware testApplicationEventPublisherAware() {
        return new TestApplicationEventPublisherAware();
    }

    @Bean
    public TestBeanFactoryAware testBeanFactoryAware() {
        return new TestBeanFactoryAware();
    }

    @Bean
    public TestEnvironmentAware testEnvironmentAware() {
        return new TestEnvironmentAware();
    }

    @Bean
    public TestMessageSourceAware testMessageSourceAware() {
        return new TestMessageSourceAware();
    }

    @Bean
    public TestResourceLoaderAware testResourceLoaderAware() {
        return new TestResourceLoaderAware();
    }
}
