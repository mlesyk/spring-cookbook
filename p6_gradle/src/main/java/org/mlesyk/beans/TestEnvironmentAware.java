package org.mlesyk.beans;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class TestEnvironmentAware implements EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Environment getEnvironment() {
        return environment;
    }
}
