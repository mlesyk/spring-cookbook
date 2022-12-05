package org.mlesyk.beans;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("test5")
public class Test4 {
    public Test4() {
        System.out.println("Test4 constructor");
    }
}
