package org.mlesyk.producer.conf;

import org.mlesyk.producer.MailProducer;
import org.mlesyk.producer.MailProducerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfiguration {

    @Bean
    public MailProducer mailProducer() {
        return new MailProducerImpl();
    }
}