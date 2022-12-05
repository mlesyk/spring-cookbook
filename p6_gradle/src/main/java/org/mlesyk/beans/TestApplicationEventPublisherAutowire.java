package org.mlesyk.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class TestApplicationEventPublisherAutowire {

    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public TestApplicationEventPublisherAutowire(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public ApplicationEventPublisher getApplicationEventPublisher() {
        return applicationEventPublisher;
    }
}
