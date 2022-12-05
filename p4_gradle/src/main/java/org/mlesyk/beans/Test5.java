package org.mlesyk.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Test5 {
    public Test5() {
        System.out.println("Test5 constructor");
    }
}
