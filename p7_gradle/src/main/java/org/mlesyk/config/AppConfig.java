package org.mlesyk.config;

import org.mlesyk.beans.Test1;
import org.mlesyk.beans.Test2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AppConfig {

    @Bean
    public Test1 test1() {
        return new Test1();
    }

    @Bean
    public Test2 test2() {
        return new Test2();
    }
}
