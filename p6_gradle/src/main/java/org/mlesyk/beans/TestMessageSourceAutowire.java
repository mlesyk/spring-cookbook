package org.mlesyk.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class TestMessageSourceAutowire {

    private MessageSource messageSource;

    @Autowired
    public TestMessageSourceAutowire(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }
}
