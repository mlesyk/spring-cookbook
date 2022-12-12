package org.mlesyk.jmstemplate.consumer;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

@Configuration
public class AppConfiguration {

    @Bean
    public ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory("tcp://localhost:61616");
    }

    @Bean
    public Queue mailDestination() {
        return new ActiveMQQueue("mail.queue");
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setReceiveTimeout(10000);
        jmsTemplate.setDefaultDestination(mailDestination());
        return jmsTemplate;
    }

    @Bean
    public ConsumerImpl consumer() {
        ConsumerImpl consumer = new ConsumerImpl();
        consumer.setJmsTemplate(jmsTemplate());
        return consumer;
    }
}
