package org.mlesyk.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test1 {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public Test1() {
        log.info("Test1 constructor");
    }

    public void someVoidMethodExample() {
        log.info("Test1 someVoidMethodExample");
    }

    public int someIntMethodExample() {
        log.info("Test1 someIntMethodExample");
        return 0;
    }

    public void someExceptionMethodExample() {
        log.info("Test1 someExceptionMethodExample");
        throw new RuntimeException("Exception thrown");
    }
}
