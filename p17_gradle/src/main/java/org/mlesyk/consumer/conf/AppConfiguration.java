package org.mlesyk.consumer.conf;

import org.mlesyk.consumer.RabbitMQConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public RabbitMQConsumer rabbitMQConsumer() {
        return new RabbitMQConsumer();
    }
}
