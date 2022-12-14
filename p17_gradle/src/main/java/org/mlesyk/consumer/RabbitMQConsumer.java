package org.mlesyk.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;
import org.mlesyk.model.Mail;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Service
public class RabbitMQConsumer {

    private static final String QUEUE_NAME = "mail.queue";

    private MailListener mailListener = new MailListener();
    private Connection connection;

    public Mail receiveMail() {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setPort(5672);

        Channel channel = null;
        try {

            connection = connectionFactory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);

            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    Mail mail = new ObjectMapper().readValue(body, Mail.class);
                    mailListener.displayMail(mail);
                }
            };
            channel.basicConsume(QUEUE_NAME, true, consumer);

        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @PreDestroy
    public void destroy() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (IOException e) {
            }
        }
    }


}
