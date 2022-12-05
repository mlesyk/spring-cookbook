package org.mlesyk;

import org.mlesyk.event.TestEvent1;
import org.mlesyk.event.TestEvent2;
import org.springframework.context.event.EventListener;

public class EventProcessor2 {

    @EventListener
    public void onApplicationEvent(TestEvent2 event) {
        System.out.println("EventProcessor2 TestEvent2 received");
    }

    @EventListener
    public void onApplicationEvent(TestEvent1 event) {
        System.out.println("EventProcessor2 TestEvent1 received");
    }
}
