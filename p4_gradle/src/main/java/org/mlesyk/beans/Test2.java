package org.mlesyk.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Test2 implements DisposableBean, InitializingBean {

    public Test2() {
        System.out.println("Test2 constructor");
    }

    public void initTest2() {
        System.out.println("initTest2 call");
    }

    public void destroyTest2() {
        System.out.println("destroyTest2 call");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct Test2");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy Test2");
    }

    private void shutdown() {
        System.out.println("Shutdown Test2");
    }

    public void close() {
        System.out.println("Closing Test2");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy Test2");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean afterPropertiesSet Test2");
    }
}
