package org.mlesyk.beans;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

public class TestMessageSourceAware implements MessageSourceAware {

    private MessageSource messageSource;

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }
}
