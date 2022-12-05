package org.mlesyk.conf;

import org.mlesyk.EventProcessor1;
import org.mlesyk.EventProcessor2;
import org.mlesyk.Runner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.mlesyk")
public class AppConfig {

    @Bean
    EventProcessor2 eventProcessor2() {
        return new EventProcessor2();
    }

//    @Bean
//    EventProcessor1 eventProcessor1() {
//        return new EventProcessor1();
//    }

    @Bean
    Runner runner() {
        return new Runner();
    }
}
