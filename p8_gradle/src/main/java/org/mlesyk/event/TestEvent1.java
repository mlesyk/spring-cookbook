package org.mlesyk.event;

import org.springframework.context.ApplicationEvent;

public class TestEvent1 extends ApplicationEvent {

    String message;

    public TestEvent1(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
