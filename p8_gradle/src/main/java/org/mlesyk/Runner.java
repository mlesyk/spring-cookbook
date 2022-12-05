package org.mlesyk;


import org.mlesyk.event.TestEvent1;
import org.mlesyk.event.TestEvent2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

public class Runner {

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    public void publish() {
        TestEvent1 event1 = new TestEvent1("qwe");
        TestEvent2 event2 = new TestEvent2("qwqwqwe");
        applicationEventPublisher.publishEvent(event1);
        applicationEventPublisher.publishEvent(event2);
    }
}
