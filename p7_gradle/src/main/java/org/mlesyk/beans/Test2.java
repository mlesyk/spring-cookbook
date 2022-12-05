package org.mlesyk.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test2 {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public Test2() {
        log.info("Test2 constructor");
    }

    public void someVoidMethodExample() {
        log.info("Test2 someVoidMethodExample");
    }

    public int someIntMethodExample() {
        log.info("Test2 someIntMethodExample");
        return 0;
    }

    public void someExceptionMethodExample() {
        log.info("Test2 someExceptionMethodExample");
        throw new RuntimeException("Exception thrown");
    }
}
