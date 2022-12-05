package org.mlesyk.config;

import org.mlesyk.beans.Test2;
import org.mlesyk.beans.TestParent;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.mlesyk")
@Profile("test2")
public class AppConfigTest2 {
    @Bean
    @Scope("prototype")
    public TestParent testParent() {
        return new Test2();
    }
}
