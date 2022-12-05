package org.mlesyk.beans;

import org.springframework.beans.factory.BeanNameAware;

public class TestBeanNameAware implements BeanNameAware {

    private String name;

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
