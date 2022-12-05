package org.mlesyk.beans;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Test1 implements DisposableBean, InitializingBean {

    public Test1() {
        System.out.println("Test1 constructor");
    }

    public void initTest1() {
        System.out.println("initTest1 call");
    }

    public void destroyTest1() {
        System.out.println("destroyTest1 call");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct Test1");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy Test1");
    }

    private void shutdown() {
        System.out.println("Shutdown Test1");
    }

    public void close() {
        System.out.println("Closing Test1");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy Test1");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean afterPropertiesSet Test1");
    }
}
