package org.mlesyk.config;

import org.mlesyk.beans.Test1;
import org.mlesyk.beans.Test2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("org.mlesyk")
public class AppConfiguration {

    @Bean(initMethod = "initTest1", destroyMethod = "destroyTest1")
    public Test1 test1() {
        return new Test1();
    }

    @Bean(initMethod = "initTest2", destroyMethod = "destroyTest2")
    @Scope("prototype")
    public Test2 test2() {
        return new Test2();
    }
}
