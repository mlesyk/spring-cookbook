package org.mlesyk.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mlesyk.model.Mail;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

public class ProducerImpl {

    private final KafkaOperations<Integer, String> kafkaOperations;

    public ProducerImpl(KafkaOperations<Integer, String> kafkaOperations) {
        this.kafkaOperations = kafkaOperations;
    }

    public void sendMail(final Mail mail) {

        ListenableFuture<SendResult<Integer, String>> future = kafkaOperations.send("mails", convertToJson(mail));
        future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {

            @Override
            public void onFailure(Throwable ex) {
                ex.printStackTrace();
            }

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                System.out.println("Result (success): " + result.getRecordMetadata());
            }
        });
    }

    private String convertToJson(Mail mail) {
        try {
            return new ObjectMapper().writeValueAsString(mail);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
