package org.mlesyk.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class TestEnvironmentAutowire {

    Environment environment;

    @Autowired
    public TestEnvironmentAutowire(Environment environment) {
        this.environment = environment;
    }

    public Environment getEnvironment() {
        return environment;
    }
}
