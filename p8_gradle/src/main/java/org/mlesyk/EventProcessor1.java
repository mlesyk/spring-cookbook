package org.mlesyk;

import org.mlesyk.event.TestEvent1;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EventProcessor1 implements ApplicationListener<TestEvent1> {
    @Override
    public void onApplicationEvent(TestEvent1 event) {
        System.out.println("EventProcessor1 TestEvent1 received");
    }
}
