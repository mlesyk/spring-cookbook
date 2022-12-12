package org.mlesyk.receiver.conf;

import org.mlesyk.receiver.MailReceiver;
import org.mlesyk.receiver.MailReceiverImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    
    @Bean
    public MailReceiver mailReceiver() {
        return new MailReceiverImpl();
    }
    
    
}
