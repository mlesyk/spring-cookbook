package org.mlesyk.jmstemplate.consumer;

import org.mlesyk.model.Mail;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;

public class ConsumerImpl {

    private JmsTemplate jmsTemplate;
    private Destination destination;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Mail receiveMail() {
        MapMessage message = (MapMessage) (destination == null ? jmsTemplate.receive() : jmsTemplate.receive(destination));
        try {
            if (message == null) {
                return null;
            }
            Mail mail = new Mail();
            mail.setMailId(message.getString("mailId"));
            mail.setCountry(message.getString("country"));
            mail.setWeight(message.getDouble("weight"));
            return mail;
        } catch (JMSException e) {
            throw JmsUtils.convertJmsAccessException(e);
        }
    }
}
