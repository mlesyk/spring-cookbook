package org.mlesyk.producer.conf;

import org.mlesyk.producer.RabbitMQProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public RabbitMQProducer rabbitMQProducer() {
        return new RabbitMQProducer();
    }
}
