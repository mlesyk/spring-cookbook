package org.mlesyk.config;

import org.mlesyk.beans.Test1;
import org.mlesyk.beans.TestParent;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.mlesyk")
@Profile("test1")
public class AppConfigTest1 {

    @Bean
    public TestParent testParent() {
        return new Test1();
    }

}
