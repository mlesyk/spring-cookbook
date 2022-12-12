package org.mlesyk.jmstemplate.producer;

import org.mlesyk.model.Mail;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;
import javax.jms.MapMessage;

public class ProducerImpl {

    private JmsTemplate jmsTemplate;
    private Destination destination;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void sendMail(final Mail mail) {
        jmsTemplate.send(destination, session -> {
            MapMessage message = session.createMapMessage();
            message.setString("mailId", mail.getMailId());
            message.setString("country", mail.getCountry());
            message.setDouble("weight", mail.getWeight());
            return message;
        });
    }
}
